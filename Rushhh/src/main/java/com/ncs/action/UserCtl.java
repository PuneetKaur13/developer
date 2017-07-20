package com.ncs.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellSupplierDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CompanyForm;
import com.ncs.form.RoleForm;
import com.ncs.form.UserForm;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.CardTypeServiceI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.ncs.services.RoleServiceI;
import com.ncs.services.UsersServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.exception.ForgetPassWordException;
import com.nenosystems.common.exception.NcsMailException;
import com.nenosystems.common.exception.UnauthorizedAccessException;
import com.nenosystems.common.exception.UserNotFoundException;
import com.nenosystems.common.mail.MailManager;
import com.nenosystems.common.mail.MailMessage;
import com.nenosystems.common.mail.MailSenderI;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Users")
public class UserCtl extends BaseCtl<UserForm> {
	private static Logger log = Logger.getLogger(UserCtl.class);

	@Override
	@Autowired
	@Qualifier("usersService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private UsersServiceI userservice;
	@Autowired
	private CompanyServiceI companyService;

	@Autowired
	private RoleServiceI roleService;

	@Autowired
	private AdminProductServiceI adminProductService;

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private CardTypeServiceI cardTypeService;

	private MailSenderI mailSenderI;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userList", userservice.find(ctx));
		map.put("roleList", roleService.find(ctx));
		map.put("cardTypeList", cardTypeService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(UserForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UserDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());

		if (!DataValidator.isNull(form.getLoginId())) {
			sc.setAttribute("loginId", form.getLoginId());
		}
		if (!DataValidator.isNull(form.getFirstName())) {
			sc.setAttribute("firstName", form.getFirstName());
		}
		if (!DataValidator.isNull(form.getStatus())) {
			sc.setAttribute("status", form.getStatus());
		}
		return sc;
	}

	@RequestMapping(value = "/setUserType/{type}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData setSessionProduct(@PathVariable String type, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		session.setAttribute("userType", type);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(null);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchForBuySupplier", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchForBuySupplier(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyDTO.class);
		sc.setAttribute("-type", "seller");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchForSellSupplier", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchForSellSupplier(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellSupplierDTO.class);
		// sc.setAttribute("deleted", 0);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByAdmin", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByAdmin(@RequestBody(required = false) UserForm form, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(userDTO.getClass());
		sc.setAttribute("-roleName", "Super Admin");
		sc.setAttribute("=groupId", userDTO.getGroupId());
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody UserForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		try {

			UserDTO dto = (UserDTO) form.makeDto();
			if (form.getConfirmEmail() != null && !form.getLoginId().equals(form.getConfirmEmail())) {
				ncsResponseData.setMessage("Email and Confirm Email did not match.");
				return ncsResponseData;
			}
			if (form.getConfirmPassword() != null && !form.getPassword().equals(form.getConfirmPassword())) {
				ncsResponseData.setMessage("Password and Confirm Password did not match.");
				return ncsResponseData;
			}

			if (dto.getId() == null) {
				SearchCriteria sc = new SearchCriteria();
				sc.setDto(UserDTO.class);
				sc.setAttribute("=loginId", dto.getLoginId());
				List list = service.find(sc, ctx);
				if (list.size() > 0) {
					ncsResponseData.setMessage("Email is alredy in use, Please enter different one.");
					return ncsResponseData;
				}
				sc = new SearchCriteria();
				sc.setDto(UserDTO.class);
				sc.setAttribute("=mobile", dto.getMobile());
				list = service.find(sc, ctx);

				if (list.size() > 0) {
					ncsResponseData.setMessage("Mobile No. is already in use, Please enter different one.");
					return ncsResponseData;
				}
				if (dto.getId() != null && dto.getId() > 0) {
					dto.setModifiedBy(ctx.getModifiedBy());
					dto.setGroupIdString(dto.getUserCompany());
					service.update(dto, null);
				} else {
					dto.setRoleId(RoleForm.USER_ROLE_ID);
					dto.setRoleName(RoleForm.USER_ROLE);
					dto.setStatus(UserDTO.DEACTIVE);
					dto.setCreatedBy(dto.getLoginId());
					dto.setModifiedBy(dto.getLoginId());
					long pk = service.add(dto, null);
					session.setAttribute("tempUserId", pk);
					session.setAttribute("tempOTP", dto.getOtp());
					CompanyDTO companyDTO = new CompanyDTO();
					companyDTO.setUserId(pk);
					companyDTO.setFirstName(dto.getFirstName());
					companyDTO.setLastName(dto.getLastName());
					companyDTO.setPhoneNo(dto.getMobile());
					companyDTO.setPrimaryEmail(dto.getEmail());
					companyDTO.setUniqueAttributes(null);
					companyDTO.setCreatedBy(dto.getCreatedBy());
					companyDTO.setModifiedBy(dto.getModifiedBy());
					companyDTO.setCreatedDate(new Timestamp(new Date().getTime()));
					companyDTO.setModifiedDate(new Timestamp(new Date().getTime()));
					// companyService.add(companyDTO, ctx);
				}
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Record has been saved successfully.");
			}

			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setGroupIdString(dto.getUserCompany());
				service.update(dto, null);
			} else {
				dto.setRoleId(RoleForm.USER_ROLE_ID);
				dto.setRoleName(RoleForm.USER_ROLE);
				dto.setStatus(UserDTO.DEACTIVE);
				dto.setCreatedBy(dto.getLoginId());
				dto.setModifiedBy(dto.getLoginId());
				long pk = service.add(dto, null);
				session.setAttribute("tempUserId", pk);
				session.setAttribute("tempOTP", dto.getOtp());
				CompanyDTO companyDTO = new CompanyDTO();
				companyDTO.setUserId(pk);
				companyDTO.setFirstName(dto.getFirstName());
				companyDTO.setLastName(dto.getLastName());
				companyDTO.setPhoneNo(dto.getMobile());
				companyDTO.setPrimaryEmail(dto.getEmail());
				companyDTO.setUniqueAttributes(null);
				companyDTO.setCreatedBy(dto.getCreatedBy());
				companyDTO.setModifiedBy(dto.getModifiedBy());
				companyDTO.setCreatedDate(new Timestamp(new Date().getTime()));
				companyDTO.setModifiedDate(new Timestamp(new Date().getTime()));
				// companyService.add(companyDTO, ctx);
			}

			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been saved successfully.");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());

		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public NcsResponseData authentication(@RequestBody UserForm form, HttpServletRequest request, HttpSession session)
			throws UserNotFoundException, UnauthorizedAccessException {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserDTO dto = (UserDTO) form.makeDto();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(UserDTO.class);
			sc.setAttribute("=loginId", dto.getLoginId());

			List list = service.find(sc, ctx);
			if (list.size() > 0) {
				UserDTO userDTO = (UserDTO) list.get(0);
				session.setAttribute("tempUserId", userDTO.getId());
				session.setAttribute("tempOTP", userDTO.getOtp());
			}

			dto = userservice.authenticate(dto, null);

			ctx = new UserContext();
			ctx.setCreatedBy(dto.getLoginId());
			ctx.setModifiedBy(dto.getLoginId());
			ctx.setBaseDTO(dto);
			session.setAttribute("ctx", ctx);
			session.setAttribute("type", "Buyer");
			form.populate(dto);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
		} catch (Exception e) {

			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	// Google Login
	@RequestMapping(value = "/authenticationGoogle", method = RequestMethod.POST)
	public NcsResponseData authenticationGoogle(@RequestBody UserForm form, HttpSession session)
			throws UserNotFoundException, UnauthorizedAccessException {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserDTO dto = (UserDTO) form.makeDto();
		System.out.println("in dto " + dto);
		try {
			ctx = new UserContext();
			ctx.setCreatedBy(dto.getLoginId());
			ctx.setModifiedBy(dto.getLoginId());
			ctx.setBaseDTO(dto);
			session.setAttribute("ctx", ctx);
			session.setAttribute("type", "Buyer");
			form.populate(dto);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/submitOTP", method = RequestMethod.POST)
	public NcsResponseData submitOTP(@RequestBody UserForm form, HttpSession session)
			throws UserNotFoundException, UnauthorizedAccessException {
		Long pk = (Long) session.getAttribute("tempUserId");
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		// UserDTO dto = (UserDTO) ctx.getBaseDTO();
		try {
			if (pk != null && pk > 0) {
				String otp = (String) session.getAttribute("tempOTP");
				if (otp.equals(form.getOtp())) {
					UserDTO dto = (UserDTO) service.findByPK(pk, ctx);
					dto.setStatus(UserDTO.ACTIVE);
					service.update(dto, ctx);
					ctx = new UserContext();
					ctx.setCreatedBy(dto.getLoginId());
					ctx.setModifiedBy(dto.getLoginId());
					ctx.setBaseDTO(dto);
					session.setAttribute("ctx", ctx);
					session.setAttribute("type", "Buyer");
					ncsResponseData.setSuccess(true);
					ncsResponseData.setMessage("You have been activated.");
					MessageDTO messageDTO1 = messageService.findByCode("SU02", ctx);
					if (messageDTO1 != null) {
						String message = messageDTO1.getMessage();
						message = message.replace("<loginId>", ctx.getCreatedBy());
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO1.getTitle());
						receiverNotification.setFrom("system");
						receiverNotification.setMessage(message);
						receiverNotification.setTo("frozenb2b@mabl.in");
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
				} else {
					ncsResponseData.setMessage("Invalid OTP , please enter correct OTP.");
				}

			} else {
				ncsResponseData.setMessage("Session has been Destroyed.");
			}
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/submitCompany", method = RequestMethod.POST)
	public NcsResponseData submitCompany(@RequestBody UserForm form, HttpSession session)
			throws UserNotFoundException, UnauthorizedAccessException {
		Long pk = (Long) session.getAttribute("tempUserId");
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		try {
			if (pk != null && pk > 0) {
				UserDTO dto = (UserDTO) service.findByPK(pk, ctx);
				CompanyForm companyForm = form.getCompany();

				if (companyForm != null && companyForm.getId() != null) {
					dto.setGroupId(companyForm.getId());
					dto.setGroupIdString(companyForm.getCompanyName());
					// dto.setRoleId(RoleForm.EXISTING_COMPANY_ROLE_ID);
					// dto.setRoleName(RoleForm.EXISTING_COMPANY_ROLE);
					System.out.println(companyForm.getId());
					System.out.println(dto.getGroupId());
					// service.update(dto, ctx);
					CompanyDTO companyDTO = (CompanyDTO) companyService.findByPK(dto.getGroupId(), ctx);
					if (dto.getGroupId() == companyDTO.getId()) {
						companyDTO.setUserId(pk);
						companyDTO.setFirstName(dto.getFirstName());
						companyDTO.setLastName(dto.getLastName());
						companyDTO.setPrimaryEmail(dto.getLoginId());
						companyDTO.setPhoneNo(dto.getMobile());
						companyDTO.setGroupId(dto.getGroupId());
						companyDTO.setGroupIdString(dto.getGroupIdString());
						companyDTO.setCompanyRole(dto.getRoleName());
						dto.setUserCompany(companyDTO.getCompanyName());
						dto.setUserCompanyId(companyDTO.getId());
						dto.setStatus(UserDTO.DISAPPROVED);
						service.update(dto, ctx);
					}
				} /*
					 * else { CompanyDTO companyDTO = (CompanyDTO)
					 * companyForm.makeDto(); companyDTO.setUserId(pk);
					 * companyDTO.setFirstName(dto.getFirstName());
					 * companyDTO.setLastName(dto.getLastName());
					 * companyDTO.setPrimaryEmail(dto.getLoginId());
					 * companyDTO.setCreatedBy(dto.getLoginId());
					 * companyDTO.setPhoneNo(dto.getMobile());
					 * companyDTO.setCompanyRole(dto.getRoleName());
					 * dto.setStatus(UserDTO.APPROVED); Long groupId =
					 * companyService.add(companyDTO, ctx);
					 * dto.setGroupId(groupId);
					 * dto.setGroupIdString(companyForm.getCompanyName());
					 * dto.setUserCompany(companyForm.getCompanyName());
					 * dto.setUserCompanyId(companyDTO.getId());
					 * dto.setCompanyType(companyDTO.getType());
					 * companyDTO.setGroupId(dto.getGroupId());
					 * companyDTO.setGroupIdString(dto.getGroupIdString());
					 * companyService.update(companyDTO, ctx);
					 * service.update(dto, ctx); }
					 */

				ctx = new UserContext();
				ctx.setCreatedBy(dto.getLoginId());
				ctx.setModifiedBy(dto.getLoginId());
				ctx.setBaseDTO(dto);
				session.setAttribute("ctx", ctx);
				session.setAttribute("type", "Buyer");

				AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductService.findByPK(1, ctx);
				session.setAttribute("sessionProduct", adminProductDTO);

				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Company has been registered successfully.");
			} else {
				ncsResponseData.setMessage("Session has been destroyed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/resendOTP", method = RequestMethod.POST)
	public NcsResponseData resendOTP(HttpSession session) throws UserNotFoundException, UnauthorizedAccessException {
		Long pk = (Long) session.getAttribute("tempUserId");
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		try {
			if (pk != null && pk > 0) {
				UserDTO dto = new UserDTO();
				dto.setId(pk);
				userservice.resendOTP(dto, ctx);
				session.setAttribute("tempOTP", dto.getOtp());

				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("New OTP has been sent.");
			} else {
				ncsResponseData.setMessage("Session has been destroyed.");
			}
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/editMyProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData editMyProfile(HttpSession session)
			throws UserNotFoundException, UnauthorizedAccessException {
		ctx = getUserContext(session);
		ncsResponseData = new NcsResponseData();
		try {
			UserDTO user = (UserDTO) ctx.getBaseDTO();
			UserForm form = new UserForm();
			form.populate(user);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setPreload(preload());
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public NcsResponseData updateProfile(@RequestBody UserForm form, HttpSession session) throws Exception {
		ctx = getUserContext(session);
		ncsResponseData = new NcsResponseData(preload());
		UserDTO dto = (UserDTO) form.makeDto();
		try {
			if ((dto.getId() != null) && (dto.getId().longValue() > 0L)) {
				dto.setModifiedBy(ctx.getModifiedBy());
				service.update(dto, ctx);
				ctx.setBaseDTO(dto);
				session.setAttribute("ctx", ctx);
				ncsResponseData.setSuccess(Boolean.valueOf(true));
				ncsResponseData.setMessage("Record has been updated successfully.");
			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is Already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	/*
	 * @RequestMapping(value = "/changeType/{type}", method = RequestMethod.GET)
	 * public NcsResponseData changeType(@PathVariable(value = "type") String
	 * type, HttpSession session) throws UserNotFoundException,
	 * UnauthorizedAccessException { log.debug("UserCtl changeType() Start");
	 * NcsResponseData ncsResponseData = new NcsResponseData();
	 * session.setAttribute("type", type); ncsResponseData.setForm(null);
	 * ncsResponseData.setSuccess(true); ncsResponseData.setMessage(
	 * "Type has been changed."); return ncsResponseData; }
	 * 
	 * @RequestMapping(value = "/checkSession", method = RequestMethod.GET)
	 * public NcsResponseData checkSession(HttpSession session) { log.debug(
	 * "UserCtl checkSession() Start"); ctx = (UserContext)
	 * session.getAttribute("ctx"); String userType = (String)
	 * session.getAttribute("userType");
	 * 
	 * NcsResponseData ncsResponseData = new NcsResponseData(); boolean flag =
	 * true; String msg = ""; if (userType != null) { flag = false; msg =
	 * userType; } else if (ctx == null) { flag = false; msg = "CTX NULL"; }
	 * ncsResponseData.setSuccess(flag); ncsResponseData.setForm(null);
	 * ncsResponseData.setMessage(msg); return ncsResponseData; }
	 */

	@RequestMapping(value = "/checkSession", method = RequestMethod.POST)
	public NcsResponseData checkSession(HttpSession session) {
		ctx = getUserContext(session);
		NcsResponseData ncsResponseData = new NcsResponseData();
		boolean flag = true;
		String msg = "";
		System.out.println(ctx.getBaseDTO());
		if (ctx == null || ctx.getBaseDTO() == null) {
			flag = false;
			msg = "OOPS! Your Session has been expired, Please Re-Login.";
		} else {
			System.out.println("in else checksession");
		}
		ncsResponseData.setSuccess(flag);
		ncsResponseData.setForm(null);
		ncsResponseData.setMessage(msg);
		return ncsResponseData;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public NcsResponseData logout(HttpSession session) {
		log.debug("UserCtl logout() Start");
		session.invalidate();
		NcsResponseData ncsResponseData = new NcsResponseData();
		ncsResponseData.setSuccess(true);
		ncsResponseData.setForm(null);
		ncsResponseData.setMessage("You are Loged-Out successfully.");
		return ncsResponseData;
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public NcsResponseData forgetPassword(@RequestBody UserForm form) throws NcsMailException, ForgetPassWordException {
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(UserDTO.class);
			sc.setAttribute("=loginId", form.getLoginId());
			List dtos = service.find(sc, ctx);
			UserDTO userDTO = new UserDTO();
			if (dtos != null && dtos.size() > 0) {
				userDTO = (UserDTO) dtos.get(0);

				MessageDTO messageDTO = messageService.findByCode("F001", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", userDTO.getFirstName() + " " + userDTO.getLastName());
					message = message.replace("<pwd>", DataUtil.decodeString(userDTO.getPassword() + ""));
					try {
						MailMessage mailMessage = new MailMessage();
						mailMessage.addTo(userDTO.getLoginId() + "");
						mailMessage.setSubject(messageDTO.getTitle());
						mailMessage.setMessage(message);
						MailManager.getInstance().send(mailMessage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Hello " + userDTO.getFirstName() + " " + userDTO.getLastName()
						+ " ! Your password has been sent on your email.");
				System.out.println(userDTO.getUserCompany());
			}

			else {
				ncsResponseData.setSuccess(false);
				ncsResponseData.setMessage("LoginId / Email not found.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByBoxUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByBoxUser(@RequestBody UserForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		sc.setDto(UserDTO.class);
		if (!DataValidator.isNull(form.getRoleName())) {
			sc.setAttribute("=roleName", form.getRoleName());
		}
		if (!DataValidator.isNull(form.getLoginId())) {
			sc.setAttribute("=loginId", form.getLoginId());
		}
		if (!DataValidator.isNull(form.getFirstName())) {
			sc.setAttribute("=firstName", form.getFirstName());
		}
		if (!DataValidator.isNull(form.getLastName())) {
			sc.setAttribute("=lastName", form.getLastName());
		}
		if (!DataValidator.isNull(form.getStatus())) {
			sc.setAttribute("=status", form.getStatus());
		}
		List list = userservice.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByBox", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByBox(@RequestBody UserForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UserDTO.class);
		if (!DataValidator.isNull(form.getRoleName())) {
			sc.setAttribute("=roleName", form.getRoleName());
		}
		if (!DataValidator.isNull(form.getLoginId())) {
			sc.setAttribute("=loginId", form.getLoginId());
		}
		if (!DataValidator.isNull(form.getFirstName())) {
			sc.setAttribute("=firstName", form.getFirstName());
		}
		if (!DataValidator.isNull(form.getLastName())) {
			sc.setAttribute("=lastName", form.getLastName());
		}
		List list = userservice.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/userProfile", method = RequestMethod.POST)
	public NcsResponseData userProfile(@RequestBody UserForm form, UserContext uc, HttpServletRequest request)
			throws UserNotFoundException, UnauthorizedAccessException {
		log.debug("UserCtl profile() Start");
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserDTO dto = (UserDTO) form.makeDto();
		dto.setLoginId(form.getLoginId());
		/* dto.setMobile(form.getMobile()); */
		try {
			form.populate(userservice.authenticate(dto, null));
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			if (ncsResponseData.getSuccess() == true) {
				UserDTO dto1 = new UserDTO();
				long id = form.getId();
				dto1 = (UserDTO) userservice.findByPK(id, uc);
				dto1.setId(form.getId());
				request.getSession().setAttribute("name", dto1);
			}
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/changeMyPassword", method = RequestMethod.POST)
	public NcsResponseData changeMyPassword(@RequestBody UserForm form, HttpSession session) throws Exception {
		ctx = getUserContext(session);
		ncsResponseData = new NcsResponseData();
		try {
			if (ctx != null) {
				UserDTO sessionDTO = (UserDTO) ctx.getBaseDTO();
				if (!form.getNewPassword().equals(form.getConfirmPassword())) {
					ncsResponseData.setSuccess(false);
					ncsResponseData.setMessage("New Password and Confirm Password did not match.");
					return ncsResponseData;
				}
				if (!sessionDTO.getPassword().equals(DataUtil.encodeString(form.getPassword()))) {
					ncsResponseData.setSuccess(false);
					ncsResponseData.setMessage("Current Password is incorrect.");
					return ncsResponseData;
				}

				sessionDTO.setPassword(DataUtil.encodeString(form.getNewPassword()));
				sessionDTO.setModifiedDate(new Timestamp(new Date().getTime()));
				service.update(sessionDTO, ctx);
				ctx.setBaseDTO(sessionDTO);
				session.setAttribute("ctx", ctx);

				MessageDTO messageDTO = messageService.findByCode("1005", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", sessionDTO.userName());
					message = message.replace("<newpassword>", form.getNewPassword());
					try {
						MailMessage mailMessage = new MailMessage();
						mailMessage.addTo(sessionDTO.getLoginId());
						mailMessage.setSubject(messageDTO.getTitle());
						mailMessage.setMessage(message);
						MailManager.getInstance().send(mailMessage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				ncsResponseData.setSuccess(Boolean.valueOf(true));
				ncsResponseData.setMessage("Password has been changed successfully.");
			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is Already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

}
