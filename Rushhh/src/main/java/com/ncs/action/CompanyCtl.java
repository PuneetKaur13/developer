package com.ncs.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.PlantInformationDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.CompanyForm;
import com.ncs.form.UserForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.CompanyProductIntersectionI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.ncs.services.PlantInformationServiceI;
import com.ncs.services.StateServiceI;
import com.ncs.utill.PropertyReader;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Company")
public class CompanyCtl extends BaseCtl<CompanyForm> {

	private static Logger log = Logger.getLogger(CompanyCtl.class);

	@Override
	@Autowired
	@Qualifier("companyService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private CompanyServiceI companyService;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private MessageServiceI messageService;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public NcsResponseData displayAdd() {
		return new NcsResponseData();
	}

	@Autowired
	CompanyProductIntersectionI companyProductIntersection;
	@Autowired
	PlantInformationServiceI plantInformationService;

	@RequestMapping(value = "/companyUnderUser/{bidId}/{groupId}", method = { RequestMethod.GET, RequestMethod.POST })
	public List viewInformation(@PathVariable Long bidId, @PathVariable Long groupId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();

		List list = service.findBySql(
				"SELECT U.USER_COMPANY,U.USER_COMPANY_ID,U.FIRST_NAME,U.LAST_NAME,U.GROUPS_ID_STRING,U.MOBILE,U.LOGIN_ID,M.BID_ID,U.STATUS,M.IS_QUOTE,U.ID,M.APPROVE_USER_ID FROM USER U , MAKE_QUOTATION M WHERE U.GROUP_ID=M.INVITE_GROUPID  AND M.BID_ID="
						+ bidId + " AND U.ROLE_NAME='Existing Company' AND U.STATUS='APPROVED' AND M.INVITE_GROUPID="
						+ groupId,
				ctx);

		return list;
	}

	@RequestMapping(value = "/searchCompanyUnderUser/{groupId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchCompanyUnderUser(@PathVariable long groupId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UserDTO.class);
		sc.setAttribute("=groupId", groupId);
		sc.setAttribute("=roleName", "Existing Company");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchPlantInformation/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchPlantInformation(@PathVariable long id, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PlantInformationDTO.class);
		sc.setAttribute("=id", id);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@Autowired
	private StateServiceI stateService;

	@Autowired
	private CityServiceI cityService;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stateList", stateService.find(ctx));
		map.put("cityList", cityService.find(ctx));
		map.put("companyList", companyService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(CompanyForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getCompanyName())) {
			sc.setAttribute("companyName", form.getCompanyName());
		}
		if (!DataValidator.isNull(form.getPhoneNo())) {
			sc.setAttribute("phoneNo", form.getPhoneNo());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
		}
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getPrimaryEmail())) {
			sc.setAttribute("email", form.getPrimaryEmail());
		}
		return sc;
	};

	@RequestMapping(value = "/searchNotNull", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchNotNull(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		CompanyForm form = new CompanyForm();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyDTO.class);
		sc.setAttribute("=companyRole", "Company");
		List list = service.find(sc, ctx);
		CompanyDTO dto = new CompanyDTO();
		if (list != null && list.size() > 0) {
			dto = (CompanyDTO) list.get(0);

		}
		form.populate(dto);
		ncsResponseData.setForm(form);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByUser(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		CompanyForm form = new CompanyForm();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyDTO.class);
		sc.setAttribute("=userId", userDTO.getId());
		List list = service.find(sc, ctx);
		CompanyDTO dto = new CompanyDTO();
		if (list != null && list.size() > 0) {
			dto = (CompanyDTO) list.get(0);
		}
		form.populate(dto);
		ncsResponseData.setForm(form);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public NcsResponseData updateCompany(@RequestBody CompanyForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			CompanyDTO dto = (CompanyDTO) form.makeDto();
			dto.setUserId(userDTO.getId());
			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				MessageDTO messageDTO = messageService.findByCode("C02", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", dto.getFirstName() + " " + dto.getLastName());
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(dto.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}

				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				PlantInformationDTO plantInformationDTO = new PlantInformationDTO();
				plantInformationDTO.setCreatedBy(ctx.getCreatedBy());
				plantInformationDTO.setModifiedBy(ctx.getModifiedBy());
				plantInformationDTO.setGroupId(userDTO.getGroupId());
				plantInformationDTO.setGroupIdString(userDTO.getGroupIdString());
				plantInformationDTO.setUserId(userDTO.getId());
				plantInformationService.add(plantInformationDTO, ctx);

				service.update(dto, null);
				MessageDTO messageDTO1 = messageService.findByCode("SU04", ctx);
				if (messageDTO1 != null) {
					String message = messageDTO1.getMessage();
					message = message.replace("<loginId>", dto.getCreatedBy());
					message = message.replace("<companyName>", dto.getCompanyName());
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
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				MessageDTO messageDTO = messageService.findByCode("C01", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", dto.getFirstName() + " " + dto.getLastName());
					message = message.replace("<site>", "www.frozenb2b.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(dto.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}

				service.add(dto, null);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage(
					"Congrats!...Your company has been registred.You are the Admin  of this company and all other user of this company will be under you...");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody CompanyForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			CompanyDTO dto = (CompanyDTO) form.makeDto();
			dto.setUserId(userDTO.getId());
			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				System.out.println("inside CompanyUpdate");
				MessageDTO messageDTO = messageService.findByCode("C02", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", dto.getFirstName() + " " + dto.getLastName());
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(dto.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}

				System.out.println("inside CompanyUpdate");
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				dto.setUserId(dto.getId());
				service.update(dto, ctx);

			} else {
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setUserId(dto.getId());
				MessageDTO messageDTO = messageService.findByCode("C01", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", dto.getFirstName() + " " + dto.getLastName());
					message = message.replace("<site>", "www.frozenb2b.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(dto.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}

				service.add(dto, ctx);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);

			ncsResponseData.setMessage(
					"Congrats!...Your company has been registred.You are the Admin  of this company and all other user of this company will be under you...");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/addMultiple/{ids}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData addMultiple(@PathVariable String ids, @RequestBody CompanyForm form) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		if (ids != null) {
			String[] arr = ids.split(",");
			for (int j = 0; j < arr.length; j++) {
				long id = Long.parseLong(arr[j]);
				CompanyDTO dto = (CompanyDTO) form.makeDto();
				companyService.add(ctx, null);
			}
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been Deleted successfully.");
		} else {
			ncsResponseData.setMessage("ID is not valid");
			ncsResponseData.setSuccess(false);
		}
		return ncsResponseData;
	}

	/*
	 * @RequestMapping(value = "edits/{id}", method = RequestMethod.GET) public
	 * NcsResponseData displayEdit(@PathVariable long id, CompanyForm form,
	 * HttpSession session) throws Exception {
	 * 
	 * NcsResponseData ncsResponseData = new NcsResponseData(); ctx =
	 * getUserContext(session); if (id > 0) { BaseDTO dto = service.findByPK(id,
	 * null); if (dto != null) { form.populate(dto);
	 * ncsResponseData.setForm(form); ncsResponseData.setSuccess(true); } else {
	 * ncsResponseData.setSuccess(false); ncsResponseData.setMessage(
	 * "Record Not found."); } } else { ncsResponseData.setMessage(
	 * "ID is not valid"); ncsResponseData.setSuccess(false); } return
	 * ncsResponseData; }
	 * 
	 * @Override
	 * 
	 * @RequestMapping(value = "edit", method = RequestMethod.POST) public
	 * NcsResponseData submitEdit(@RequestBody CompanyForm form, HttpSession
	 * session) throws Exception { try { NcsResponseData ncsResponseData = new
	 * NcsResponseData(); ctx = getUserContext(session); UserContext ctx =
	 * getUserContext(session); UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
	 * CompanyDTO dto = (CompanyDTO) form.makeDto(); if (dto.getId() != null &&
	 * dto.getId() > 0) { SearchCriteria sc = new SearchCriteria();
	 * sc.setDto(CompanyDTO.class); sc.setAttribute("=id", dto.getId());
	 * List<CompanyDTO> list = companyService.find(sc, ctx); for(CompanyDTO
	 * companyDTO: list) {
	 * 
	 * System.out.println(dto.getGroupIdString());
	 * 
	 * companyDTO.setGroupId(dto.getGroupId());
	 * companyDTO.setGroupIdString(dto.getGroupIdString());
	 * companyDTO.setModifiedBy(dto.getCreatedBy()); service.update(companyDTO,
	 * null); }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * System.out.println("Update"); service.update(dto, null);
	 * 
	 * ncsResponseData.setSuccess(true); ncsResponseData.setMessage(
	 * "Record has been updated successfully.");
	 * 
	 * 
	 * } catch (Exception e) { ncsResponseData.setMessage(e.getMessage()); }
	 * 
	 * return ncsResponseData; }
	 */

}
