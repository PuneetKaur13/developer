package com.ncs.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.jetty.server.Authentication.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.UserCardManagementDAOI;
import com.ncs.dao.UsersDAOI;
import com.ncs.dto.CardTypeDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.UserCardManagementDTO;
import com.ncs.dto.UserDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.exception.ForgetPassWordException;
import com.nenosystems.common.exception.UnauthorizedAccessException;
import com.nenosystems.common.exception.UserNotFoundException;
import com.nenosystems.common.mail.MailManager;
import com.nenosystems.common.mail.MailMessage;
import com.nenosystems.common.mail.MailMessageImp;
import com.nenosystems.common.services.ApplicationBeanContext;
import com.nenosystems.common.services.BaseServiceImpl;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.NCSMailUtil;

@Service("usersService")
public class UsersServiceImpl extends BaseServiceImpl implements UsersServiceI {
	@Autowired
	private static MailMessageImp mailMessage = null;
	@Autowired
	private UsersDAOI userdao = null;

	@Override
	@Autowired
	@Qualifier("usersDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}

	@Autowired
	private com.ncs.dao.UsersDAOI usersDAO = null;

	private Integer unSuccessLogin = 3;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private UserCardManagementServiceI userCardManagementService;

	@Autowired
	private CardTypeServiceI cardTypeService;

	public MailMessageImp getMailMessage() {
		return mailMessage;
	}

	public void setMailMessage(MailMessageImp mailMessage) {
		this.mailMessage = mailMessage;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void findbyStringSqlUpdate(String sql, UserContext userContext) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDTO forgetPassword(UserDTO userDto)
			throws UserNotFoundException, UnauthorizedAccessException, ForgetPassWordException {
		String email = userDto.getEmail();
		SearchCriteria criteria = new SearchCriteria(UserDTO.class);
		criteria.setAttribute("loginId", userDto.getLoginId());
		criteria.setAttribute("email", email);
		List l = dao.find(criteria, null);
		UserDTO dto = userDto;
		if (l.size() == 1) {
			dto = (UserDTO) l.get(0);
			NCSMailUtil.sendmail(getMailMassage(dto, null, "Forget"));
			throw new ForgetPassWordException("New Password has been sent to your Email ID");
		} else {
			throw new UserNotFoundException("Invalid Login ID");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		UserDTO userdto = (UserDTO) dto;
		MailMessage mailMessage = null;
		String otp = registerUserWithOTP(userdto, userContext);
		userdto.setOtp(otp);
		long pk = dao.add(dto, userContext);

		if (userdto.getCardTypeDTO() != null && userdto.getCardTypeDTO().getId() > 0) {
			Calendar curDate = Calendar.getInstance();
			UserCardManagementDTO userCardManagementDTO = new UserCardManagementDTO();
			userCardManagementDTO.setCardReferenceNo(curDate.get(Calendar.YEAR) + "" + "000"
					+ curDate.get(Calendar.MONTH) + "" + "1000" + "" + "00" + pk);
			userCardManagementDTO.setChipNo("100" + pk);
			userCardManagementDTO.setUserId(pk);
			userCardManagementDTO.setUserName(userdto.userName());

			Calendar oneYearExtend = Calendar.getInstance();
			oneYearExtend.add(Calendar.YEAR, 1);
			userCardManagementDTO.setDateOfIssue(curDate.getTime());
			userCardManagementDTO.setDateOfExpiry(oneYearExtend.getTime());
			userCardManagementDTO.setCreatedBy(dto.getCreatedBy());
			userCardManagementDTO.setModifiedBy(dto.getModifiedBy());
			userCardManagementDTO.setCreatedDate(dto.getCreatedDate());
			userCardManagementDTO.setModifiedDate(dto.getModifiedDate());
			CardTypeDTO cardTypeDTO = (CardTypeDTO) cardTypeService.findByPK(userdto.getCardTypeDTO().getId(),
					userContext);
			userCardManagementDTO.setCardTypeId(userdto.getCardTypeDTO().getId());
			userCardManagementDTO.setCardType(cardTypeDTO.getName());
			userCardManagementDTO.setCardTypeName(cardTypeDTO.getName());
			userdto.setCardId(userdto.getCardTypeDTO().getId());
			userdto.setCardType(cardTypeDTO.getName());
			userdto.setCardType(cardTypeDTO.getName());
			userdto.setCardReferenceNo(userCardManagementDTO.getCardReferenceNo());
			userCardManagementService.add(userCardManagementDTO, userContext);
		}

		MessageDTO messageDTO = messageService.findByCode("U01", userContext);
		if (messageDTO != null) {
			String message = messageDTO.getMessage();
			message = message.replace("<user>", userdto.getFirstName() + " " + userdto.getLastName());
			message = message.replace("<loginId>", dto.getCreatedBy());
			message = message.replace("<pwd>", DataUtil.decodeString(userdto.getPassword()));
			message = message.replace("<site>", "www.Rushhh.in");
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom("system");
			receiverNotification.setMessage(message);
			receiverNotification.setTo(dto.getCreatedBy());
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			dao.add(receiverNotification, userContext);
			try {
				mailMessage = new MailMessage();
				mailMessage.addTo(userdto.getLoginId());
				mailMessage.setSubject(messageDTO.getTitle());
				mailMessage.setMessage(message);
				MailManager.getInstance().send(mailMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		MessageDTO messageDTO1 = messageService.findByCode("SU01", userContext);
		if (messageDTO1 != null) {

			String message = messageDTO1.getMessage();
			message = message.replace("<user>", userdto.getFirstName() + " " + userdto.getLastName());
			message = message.replace("<loginId>", dto.getCreatedBy());
			message = message.replace("<pwd>", DataUtil.decodeString(userdto.getPassword()));
			message = message.replace("<otp>", userdto.getOtp());
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO1.getTitle());
			receiverNotification.setFrom("system");
			receiverNotification.setMessage(message);
			receiverNotification.setTo("Rushhh.in");
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			dao.add(receiverNotification, userContext);
			System.out.println("------------");
			try {
				mailMessage = new MailMessage();
				mailMessage.addTo(userdto.getLoginId());
				mailMessage.setSubject(messageDTO1.getTitle());
				mailMessage.setMessage(message);

				MailManager.getInstance().send(mailMessage);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		UserDTO userdto = (UserDTO) dto;
		userdto.setGroupIdString(userdto.getUserCompany());
		userdto.setGroupId(userdto.getUserCompanyId());
		dao.update(dto, userContext);
		/* NCSMailUtil.sendmail(userdto, "update", userContext); */

		// NCSMailUtil.sendmail(getMailMassage(userdto, userContext, "update"));
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void resendOTP(BaseDTO dto, UserContext userContext) throws Exception {
		UserDTO userdto = (UserDTO) dto;
		UserDTO dbDTO = (UserDTO) findByPK(userdto.getId(), userContext);
		String otp = registerUserWithOTP(dbDTO, userContext);
		dbDTO.setOtp(otp);
		userdto.setOtp(otp);
		dao.update(dbDTO, userContext);
		NCSMailUtil.sendmail(getMailMassage(dbDTO, userContext, "create"));
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String registerUserWithOTP(BaseDTO dto, UserContext userContext) throws Exception {
		UserDTO userdto = (UserDTO) dto;
		String authkey = "39550AUXIvqCVe4VR54928f90";
		String senderId = "RUSHHH";
		StringBuilder generatedToken = new StringBuilder();
		try {
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
			for (int i = 0; i < 6; i++) {
				generatedToken.append(number.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		String otp = generatedToken.toString();
		String route = "4";
		String mobile = userdto.getMobile();

		String message = "Dear User to complete registration process of Rushhh , Use OTP  " + otp + "  DON'T Share it!";
		makeAPICall(authkey, mobile, senderId, message, route);
		return otp;
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

	public static String hitUrl(String urlToHit, String param) {
		try {
			URL url = new URL(urlToHit);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setRequestMethod("POST");
			OutputStreamWriter wr = new OutputStreamWriter(http.getOutputStream(), "8859_1");
			wr.write(param);
			wr.flush();
			wr.close();
			http.disconnect();
			BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String inputLine;
			if ((inputLine = in.readLine()) != null) {
				in.close();
				return inputLine;
			} else {
				in.close();
				return "-1";
			}
		} catch (Exception e) {
			System.out.println("Exception Caught..!!!");
			e.printStackTrace();
			return "-2";
		}
	}

	public static void makeXMLAPICall(String authkey, String mobiles[], String senderId, String message, String route) {
		String strUrl = "http://india.msg91.com/api/postsms.php";
		// strUrl="http://india.msg91.com/api/ValidateXml.php";
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("data=<MESSAGE>");
		stringBuffer.append("<AUTHKEY>" + authkey + "</AUTHKEY>");
		stringBuffer.append("<ROUTE>4</ROUTE>");
		stringBuffer.append("<UNICODE>1</UNICODE>");
		stringBuffer.append("<CAMPAIGN>XML API</CAMPAIGN>");
		stringBuffer.append("<SENDER>" + senderId + "</SENDER>");

		for (int i = 0; i < mobiles.length; i++) {
			stringBuffer.append("<SMS TEXT='" + message + "' ><ADDRESS TO='" + mobiles[i] + "'></ADDRESS></SMS>");
		}
		// stringBuffer.append("<SENDER>MPSNCU</SENDER>");
		stringBuffer.append("</MESSAGE>");

		System.out.println(stringBuffer.toString());
		String output = hitUrl(strUrl, stringBuffer.toString());
		System.out.println("Output is: " + output);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List l = super.find(searchCriteria, userContext);
		return l;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext, Boolean flag) throws Exception {
		UserDTO userdto = (UserDTO) dto;
		dao.update(dto, userContext);
		/* NCSMailUtil.sendmail(userdto, "update", userContext); */
		if (flag) {
			NCSMailUtil.sendmail(getMailMassage(userdto, userContext, "update"));
		}
	}

	@Override
	public List add(List l, UserContext userContext) throws Exception {
		List pks = dao.add(l, userContext);
		sendMailMassage(l, userContext, "create");
		return pks;
	}

	@Override
	public void update(List l, UserContext userContext) throws Exception {
		dao.update(l, userContext);
		sendMailMassage(l, userContext, "update");
	}

	public List findbySql(String sql, UserContext userContext) {
		List l = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return l;

	}

	public String findbyStringSql(String sql, UserContext userContext) {
		return (String) sessionFactory.getCurrentSession().save(sql);
	}
	/**
	 * use for user are authenticate
	 * 
	 * @param userDto
	 * @param userContext
	 * @return
	 * @throws UserNotFoundException
	 * @throws UnauthorizedAccessException
	 */

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO authenticate(UserDTO userDto, UserContext userContext)
			throws UserNotFoundException, UnauthorizedAccessException {
		try {
			SearchCriteria sc = new SearchCriteria();
			String loginId = userDto.getLoginId();
			String mobile = userDto.getLoginId();
			String email = userDto.getLoginId();
			int deleted = userDto.getDeleted();
			String cardReferenceNo = userDto.getLoginId();

			// String password = DataUtil.encodeString(userDto.getPassword());
			String password = userDto.getPassword();
			String hql = "from UserDTO where (loginId = '" + loginId + "' OR mobile= '" + mobile + "' OR email= '"
					+ email + "'OR cardReferenceNo= '" + cardReferenceNo + "') AND password= '" + password
					+ "' AND deleted= '" + deleted + "'";
				
			sc = new SearchCriteria();
			sc.setDto(UserDTO.class);
			sc.setAttribute("loginId", loginId);
			sc.setAttribute("mobile", mobile);
			sc.setAttribute("password", password);
			sc.setAttribute("cardReferenceNo", cardReferenceNo);
			sc.setAttribute("deleted", 0);
			List l = userdao.findbyHql(hql, userContext);
			System.out.println("Authenticate " + l.size());
			UserDTO dto = null;
			if (l.size() == 1) {
				dto = (UserDTO) l.get(0);
				// check user active
				if (UserDTO.DEACTIVE.equals(dto.getStatus())) {
					throw new UnauthorizedAccessException("DEACTIVATED");
				}
				// check user have a company or not
				/*
				 * if (dto.getGroupId() == null) { throw new
				 * UnauthorizedAccessException("REGISTER COMPANY"); }
				 */
				if (UserDTO.DISAPPROVED.equals(dto.getStatus())) {
					throw new UnauthorizedAccessException("DISAPPROVED");
				}
				// check user valid access date
				Boolean flag = checkValidDate(dto.getValidFromDate(), dto.getValidToDate());
				if (!flag) {
					throw new UnauthorizedAccessException(
							"Invalid date range, You can not access application right now");
				}
				// check user valid access time
				flag = checkValidtime(dto.getAccessTimeFrom(), dto.getAccessTimeTo());
				if (!flag) {
					throw new UnauthorizedAccessException("User is Invalid not permission to login this time");
				}
				if (UserDTO.LOCKED.equals(dto.getStatus())) {
					UnauthorizedAccessException exception = new UnauthorizedAccessException("User is Locked");
					throw exception;
				}
				dto.setLastLogin(new Timestamp(new Date().getTime()));
				dto.setUnsucessfullLoginAttempt(0);
				try {
					dao.update(dto, userContext);
				} catch (Exception e) {
					//
					e.printStackTrace();
				}
				// template.update(dto);

				System.out.println("You are in Return");
				return dto;
			} else {
				System.out.println("user is found id ");
				hql = "from UserDTO where loginId = '" + loginId + "'";
				l = userdao.findbyHql(hql, userContext);
				// System.out.println("Authenticate " + l.size());
				if (l.size() == 1) {
					dto = (UserDTO) l.get(0);
					if (UserDTO.LOCKED.equals(dto.getStatus())) {
						UnauthorizedAccessException exception = new UnauthorizedAccessException("User is Locked");
						throw exception;
					}
					if (dto.getUnsucessfullLoginAttempt() == unSuccessLogin) {
						dto.setUnsucessfullLoginAttempt(0);
						dto.setStatus(UserDTO.LOCKED);
						try {
							System.out.println("user dao update");
							dao.update(dto, userContext);
						} catch (Exception e) {

							e.printStackTrace();
						}
						try {

							// NCSMailUtil.sendmail(dto, "Locked", userContext);

						} catch (RuntimeException e) {
							e.printStackTrace();
						}
						throw new UnauthorizedAccessException("User is Locked");
					} else {

						dto.setUnsucessfullLoginAttempt(dto.getUnsucessfullLoginAttempt() + 1);

						try {
							System.out.println("user dao success");
							dao.update(dto, userContext);
						} catch (Exception e) {
							//
							e.printStackTrace();
						}

					}

				} else {
					throw new UserNotFoundException(loginId + " not found");
				}
				throw new UserNotFoundException(loginId + " not found");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UnauthorizedAccessException("Invalid User ID");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public UserDTO authenticateGoogle(String name,String email, UserContext userContext)
			throws UserNotFoundException, UnauthorizedAccessException {
		UserDTO dto=new UserDTO();
		dto.setFirstName(name);
		dto.setEmail(email);
		
		return dto;
	}
	public static Boolean checkValidtime(Date d1, Date d2) {
		if (d1 == null && d2 == null) {
			return true;
		}
		Calendar fromtime = Calendar.getInstance();
		Calendar totime = Calendar.getInstance();
		Calendar currenttime = Calendar.getInstance();
		Calendar currentcal = Calendar.getInstance();
		currenttime.set(1970, Calendar.JANUARY, 01, currentcal.HOUR, currentcal.MINUTE, currentcal.SECOND);
		fromtime.setTime(d1);
		totime.setTime(d2);
		if (currenttime.compareTo(fromtime) >= 0 && currenttime.compareTo(totime) <= 0) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false   ");
			return false;
		}
	}

	public static Boolean checkValidDate(Date d1, Date d2) {
		if (d1 == null && d2 == null) {
			return true;
		}
		Calendar toDate = Calendar.getInstance();
		Calendar fromdate = Calendar.getInstance();
		Calendar currentDate = Calendar.getInstance();
		fromdate.setTime(d1);
		toDate.setTime(d2);
		if (currentDate.after(fromdate) && currentDate.before(toDate))
			return true;
		else
			return false;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public static MailMessageImp getMailMassage1(BaseDTO dto, UserContext userContext, String type) {
		UserDTO userDTO = (UserDTO) dto;
		/*
		 * MailMessageImp mailMessage = (MailMessageImp) ApplicationBeanContext
		 * .getBean("mailMessage");
		 */
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("title", "REGISTRATION");
		String password = new String(Base64.decodeBase64(userDTO.getPassword().getBytes()));
		String message = "Hello " + userDTO.getFirstName() + " " + userDTO.getLastName() + " you are " + type + "\n"
				+ "<br>LoginID:" + userDTO.getLoginId() + "<br>password:" + password;

		params.put("description", message);

		ArrayList<String> mailAddress = new ArrayList<String>();
		mailAddress.add(userDTO.getEmail());
		mailMessage.setTo(mailAddress);
		try {
			mailMessage.setMessage("akn.mail", params);
		} catch (Exception e) {
			mailMessage.setMessage("Unable to send massage some problem");
		}
		return mailMessage;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public MailMessageImp getMailMassage(BaseDTO dto, UserContext userContext, String type) {
		UserDTO userDTO = (UserDTO) dto;
		/*
		 * MailMessageImp mailMessage = (MailMessageImp) ApplicationBeanContext
		 * .getBean("mailMessage");
		 */
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("title", "REGISTRATION");
			String password = new String(Base64.decodeBase64(userDTO.getPassword().getBytes()));
			params.put("FirstName", userDTO.getFirstName());
			params.put("LastName", userDTO.getLastName());
			params.put("Name", userDTO.getFirstName());
			params.put("login", userDTO.getLoginId());
			params.put("password", password);
			ArrayList<String> mailAddress = new ArrayList<String>();
			mailAddress.add(userDTO.getEmail());
			mailMessage = new MailMessageImp();
			mailMessage.setTo(mailAddress);

			if ("Forget".equals(type)) {
				mailMessage.setMessage("forgot.mail", params);
				mailMessage.setSubject(userDTO.getFirstName() + " your password ");
			} else if ("create".equals(type)) {
				mailMessage.setMessage("register.mail", params);
				mailMessage.setSubject(userDTO.getFirstName() + " you have successfully registered.");
			} else if ("update".equals(type)) {
				mailMessage.setMessage("update.mail", params);

				mailMessage.setSubject(userDTO.getFirstName() + " your account is successfully updated.");
			} else {
				mailMessage.setMessage("akn.mail", params);
			}

		} catch (Exception e) {
			e.printStackTrace();
			mailMessage.setMessage("Unable to send massage some problem");
		}
		return mailMessage;
		/* return null; */
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void sendMailMassage(List l, UserContext userContext, String type) {
		Iterator iterator = l.iterator();
		while (iterator.hasNext()) {
			UserDTO userdto = (UserDTO) iterator.next();
			NCSMailUtil.sendmail(getMailMassage(userdto, userContext, "delete"));
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long addAndSendActiveMail(BaseDTO dto, UserContext userContext, String url) throws Exception {
		UserDTO userDTO = (UserDTO) dto;
		long pk = dao.add(dto, userContext);
		MailMessageImp mailMessage = (MailMessageImp) ApplicationBeanContext.getBean("mailMessage");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("title", "REGISTRATION");
		String password = new String(Base64.decodeBase64(userDTO.getPassword().getBytes()));
		params.put("FirstName", userDTO.getFirstName());
		params.put("LastName", userDTO.getLastName());
		params.put("Name", userDTO.getFirstName());
		params.put("login", userDTO.getLoginId());
		params.put("password", password);
		mailMessage.setSubject(userDTO.getFirstName() + " you have successfully registered");
		String queryString = userDTO.getLoginId() + "_" + pk + "_" + userDTO.getFirstName() + "_"
				+ userDTO.getLastName();
		String link = url + "?token=" + DataUtil.encodeString(queryString);
		params.put("link", link);
		ArrayList<String> mailAddress = new ArrayList<String>();
		mailAddress.add(userDTO.getEmail());
		mailMessage.setTo(mailAddress);
		mailMessage.setMessage("active.mail", params);
		NCSMailUtil.sendmail(mailMessage);
		return pk;
	}

	public Integer getUnSuccessLogin() {
		return unSuccessLogin;
	}

	public void setUnSuccessLogin(Integer unSuccessLogin) {
		this.unSuccessLogin = unSuccessLogin;

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changePassword(Long id, String oldPassword, String newPassword) throws Exception {

		boolean flag = false;
		UserDTO dto = null;

		dto = (UserDTO) dao.findByPK(id, null);
		if (dto != null && dto.getPassword().equals(oldPassword)) {
			dto.setPassword(newPassword);
			try {
				update(dto, null);
			} catch (DuplicateRecordException e) {

			}
			flag = true;
		} else {
		}

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("login", dto.getLoginId());
		map.put("password", dto.getPassword());
		map.put("firstName", dto.getFirstName());

		return flag;

	}
}
