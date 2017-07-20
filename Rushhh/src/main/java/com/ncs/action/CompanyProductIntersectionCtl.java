package com.ncs.action;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuySupplierDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuySupplierForm;
import com.ncs.form.BuyerQuotationForm;
import com.ncs.form.CompanyProductIntersectionForm;
import com.ncs.form.StateForm;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.CompanyProductIntersectionI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/CompanyProductIntersection")
public class CompanyProductIntersectionCtl extends BaseCtl<CompanyProductIntersectionForm> {

	private static Logger log = Logger.getLogger(CompanyProductIntersectionCtl.class);

	@Override
	@Autowired
	@Qualifier("companyProductIntersectionService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	CompanyProductIntersectionI companyProductIntersection;

	@Autowired
	CompanyServiceI companyService;
	
	@Autowired
	AdminProductServiceI adminProductService;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private MessageServiceI messageService;
	
	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productList", adminProductService.find(ctx));
		return map;
	}
	
	public SearchCriteria getSearchCriteria(CompanyProductIntersectionForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getProductName())) {
			sc.setAttribute("productName", form.getProductName());
		}
		if (ctx != null && ctx.getBaseDTO() != null) {
			UserDTO dto = (UserDTO) ctx.getBaseDTO();
			sc.setAttribute("createdBy", dto.getCreatedBy());
			sc.setPagging(false);
		}
		
		
		
		return sc;
	};
	
	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByUser(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	@RequestMapping(value = "/findByProduct/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByProduct(@PathVariable("productId") Long productId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDto = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setAttribute("-createdBy", ctx.getCreatedBy());
		sc.setAttribute("=productId", productId);
		sc.setAttribute("-productType", "Buyer");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody CompanyProductIntersectionForm form, HttpSession session) {
		CompanyProductIntersectionDTO dto = (CompanyProductIntersectionDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		List<Object[]> uniqueAttributes = new ArrayList<Object[]>();
		uniqueAttributes.add(new Object[] { "createdBy", userDTO.getLoginId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId() });
		dto.setUniqueAttributes(uniqueAttributes);
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(CompanyDTO.class);
	
			sc.setAttribute("=id",userDTO.getGroupId());
			List list = companyService.find(sc, ctx);
			CompanyDTO companyDTO = new CompanyDTO();
			if (list != null && list.size() > 0) {
				companyDTO = (CompanyDTO) list.get(0);
			}
			dto.setCreatedBy(userDTO.getLoginId());
			dto.setModifiedBy(userDTO.getLoginId());
			dto.setCompanyId(userDTO.getGroupId());
			dto.setEmailId(userDTO.getLoginId());
			dto.setMobileNo(userDTO.getMobile());
			dto.setCompanyName(companyDTO.getCompanyName());
			dto.setGroupId(userDTO.getGroupId());
			dto.setGroupIdString(userDTO.getGroupIdString());
			service.add(dto, ctx);
			
			
			MessageDTO messageDTO = messageService.findByCode("SU08", ctx);
			System.out.println("inside code");
			if (messageDTO != null) {
				String message = messageDTO.getMessage();
				message = message.replace("<loginId>", dto.getCreatedBy());
				message = message.replace("<product>", dto.getProductName());
				message = message.replace("<type>", dto.getProductType());
				NotificationDTO receiverNotification = new NotificationDTO();
				receiverNotification.setSubject(messageDTO.getTitle());
				receiverNotification.setFrom("system");
				receiverNotification.setMessage(message);
				receiverNotification.setTo(dto.getCreatedBy());
				receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
				receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
				notificationService.add(receiverNotification, ctx);
			}
			MessageDTO messageDTO1 = messageService.findByCode("SU07", ctx);
			if (messageDTO != null) {
				String message = messageDTO1.getMessage();
				message = message.replace("<loginId>", dto.getCreatedBy());
				message = message.replace("<product>", dto.getProductName());
				message = message.replace("<type>", dto.getProductType());
				message = message.replace("<site>", "www.frozenb2b.in");
				NotificationDTO receiverNotification = new NotificationDTO();
				receiverNotification.setSubject(messageDTO.getTitle());
				receiverNotification.setFrom(dto.getCreatedBy());
				receiverNotification.setMessage(message);
				receiverNotification.setTo("frozenb2b@mabl.in");
				receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
				receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
				notificationService.add(receiverNotification, ctx);
			}

			
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been added successfully.");
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return ncsResponseData;
	}
}
