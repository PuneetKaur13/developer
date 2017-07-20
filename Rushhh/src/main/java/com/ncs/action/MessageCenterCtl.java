package com.ncs.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.MessageCenterDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CompanyProductIntersectionForm;
import com.ncs.form.MessageCenterForm;
import com.ncs.form.MessageForm;
import com.ncs.services.AdminProductPackagingServiceI;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.CompanyProductIntersectionI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.mail.MailManager;
import com.nenosystems.common.mail.MailMessage;
import com.nenosystems.common.mail.MailMessageImp;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/MessageCenter")
public class MessageCenterCtl extends BaseCtl<MessageCenterForm> {

	@Override
	@Autowired
	@Qualifier("messageCenterService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private AdminProductServiceI adminProductService;
	@Autowired
	private CompanyProductIntersectionI companyProductIntersection;
	@Autowired
	private NotificationServiceI notificationService;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productList", adminProductService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(MessageCenterForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(MessageCenterDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getType())) {
			sc.setAttribute("type", form.getType());
		}
		if (!DataValidator.isNull(form.getMessage())) {
			sc.setAttribute("message", form.getMessage());
		}

		return sc;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody MessageCenterForm form, HttpSession session) {
		MessageCenterDTO dto = (MessageCenterDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		JavaMailSender mailSender;
		MailManager mailManager=null;
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(CompanyProductIntersectionDTO.class);
			sc.setAttribute("=productId", dto.getProductId());
			sc.setAttribute("=productType", dto.getUserType());
			List<CompanyProductIntersectionDTO> list = companyProductIntersection.find(sc, ctx);
			dto.setCreatedBy(ctx.getCreatedBy());
			for (CompanyProductIntersectionDTO companyProductIntersectionDTO2 : list) {
				MailMessage mailMessage = null;
				if (dto != null) {
					String message1 = dto.getMessage();
					if (dto.getType().equals("NOTIFICATION")) {
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setFrom(dto.getCreatedBy());
						receiverNotification.setMessage(message1);
						receiverNotification.setSubject("Information");
						receiverNotification.setTo(companyProductIntersectionDTO2.getCreatedBy());
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					} else if (dto.getType().equals("EMAIL")) {

						try {
							mailMessage = new MailMessage();
							mailMessage.addTo(companyProductIntersectionDTO2.getCreatedBy());
							mailMessage.setMessage(message1);
							
							MailManager.getInstance().send(mailMessage);

						} catch (MessagingException e) {
							throw new MailParseException(e);
						}

					} else if (dto.getType().equals("SMS")) {
						String authkey = "39550AUXIvqCVe4VR54928f90";
						String senderId = "FROZEN";
						String route = "4";
						String mobile = companyProductIntersectionDTO2.getMobileNo();
						makeAPICall(authkey, mobile, senderId, message1, route);

					}

				}
			}

			service.add(dto, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been added successfully.");
		} catch (

		DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return ncsResponseData;
	}

	public static void makeAPICall(String authkey, String mobiles, String senderId, String message, String route) {

		// Prepare Url
		URLConnection myURLConnection = null;
		URL myURL = null;
		BufferedReader reader = null;

		// encoding message
		String encoded_message = URLEncoder.encode(message);

		// Send SMS API
		String mainUrl = "http://india.msg91.com/api/sendhttp.php?";

		// Prepare parameter string
		StringBuilder sbPostData = new StringBuilder(mainUrl);
		sbPostData.append("authkey=" + authkey);
		sbPostData.append("&mobiles=" + mobiles);
		sbPostData.append("&message=" + encoded_message);
		sbPostData.append("&route=" + route);
		sbPostData.append("&sender=" + senderId);
		sbPostData.append("&unicode=1&type=test");

		// final string
		mainUrl = sbPostData.toString();
		try {
			// prepare connection
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			// reading response
			String response;
			while ((response = reader.readLine()) != null)
				// print response
				System.out.println(response);

			// finally close connection
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
