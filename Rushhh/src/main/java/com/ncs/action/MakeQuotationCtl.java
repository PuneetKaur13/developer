package com.ncs.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.MakeQuotationForm;
import com.ncs.form.PreferredSupplierForm;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.MakeQuotationServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.ncs.services.PreferredSupplierServiceI;
import com.ncs.services.UsersServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/MakeQuotation")
public class MakeQuotationCtl extends BaseCtl<MakeQuotationForm> {
	private static Logger log = Logger.getLogger(MakeQuotationCtl.class);

	@Override
	@Autowired
	@Qualifier("makeQuotationService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private MakeQuotationServiceI makeQuotationServiceI;

	@Autowired
	private PreferredSupplierServiceI preferredSupplierServiceI;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private UsersServiceI usersService;


	
	@Autowired
	private MessageServiceI messageService;
	
	public SearchCriteria getSearchCriteria(MakeQuotationForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(MakeQuotationDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
		}
		if (!DataValidator.isNull(form.getBidRefrenceNo())) {
			sc.setAttribute("bidRefNo", form.getBidRefrenceNo());
		}
		if (!DataValidator.isNull(form.getProductName())) {
			sc.setAttribute("productName", form.getProductName());
		}
		if (!DataValidator.isNull(form.getPackaging())) {
			sc.setAttribute("packaging", form.getPackaging());
		}
		if (!DataValidator.isNull(form.getStatus())) {
			sc.setAttribute("status", form.getStatus());
		}

		if (ctx != null && ctx.getBaseDTO() != null) {
			UserDTO dto = (UserDTO) ctx.getBaseDTO();
			System.out.println(dto.getGroupId());
			sc.setAttribute("-createdBy", dto.getCreatedBy());
			sc.setAttribute("=invitedUserCompanyId", dto.getUserCompanyId());
			List<MakeQuotationDTO> list=makeQuotationServiceI.find(sc,ctx);
			
			for(MakeQuotationDTO buyerBiddingDTO : list)
			{
				if(buyerBiddingDTO.getStatus().equals("ACTIVE")){
					sc.setAttribute("=inviteStatus","Accept");
				}
				
			}
		
			
			
		}
		return sc;
	};

	@RequestMapping(value = "/acceptInvitation", method = RequestMethod.POST)
	public NcsResponseData acceptInvitation(@RequestBody MakeQuotationForm form, HttpSession session) {
		MakeQuotationDTO dto = (MakeQuotationDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(MakeQuotationDTO.class);
			sc.setAttribute("bidId", dto.getBidId());
			sc.setAttribute("invitedUserId", dto.getInvitedUserId());
			List<MakeQuotationDTO> list = makeQuotationServiceI.find(sc, ctx);
			System.out.println("inside try");
			for (MakeQuotationDTO makeQuotationDTO : list) {

				makeQuotationDTO.setInviteStatus("Accept");
				makeQuotationDTO.setIsAccept(true);

				MessageDTO messageDTO = messageService.findByCode("S02", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", userDTO.getCreatedBy());
					message = message.replace("<bidRef>", makeQuotationDTO.getBidRefrenceNo());
					message = message.replace("<site>", "www.frozenB2B.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(userDTO.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
					System.out.println("inside invited user");
				}
				MessageDTO messageDTO1 = messageService.findByCode("B05", ctx);
				if (messageDTO1 != null) {
					String message = messageDTO1.getMessage();
					message = message.replace("<user>", makeQuotationDTO.getInvitedUserName());
					message = message.replace("<bidRef>", makeQuotationDTO.getBidRefrenceNo());
					message = message.replace("<site>", "www.frozenB2B.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO1.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(makeQuotationDTO.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}
				MessageDTO messageDTO2 = messageService.findByCode("SU12", ctx);
				if (messageDTO2 != null) {
					String message = messageDTO2.getMessage();
					message = message.replace("<user>", makeQuotationDTO.getInvitedUserName());
					message = message.replace("<bidRef>", makeQuotationDTO.getBidRefrenceNo());
					message = message.replace("<site>", "www.frozenB2B.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO1.getTitle());
					receiverNotification.setFrom(makeQuotationDTO.getCreatedBy());
					receiverNotification.setMessage(message);
					receiverNotification.setTo("frozenb2b@mabl.in");
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}
				makeQuotationServiceI.update(makeQuotationDTO, ctx);
			}
			PreferredSupplierDTO preferredSupplierDTO = (PreferredSupplierDTO) preferredSupplierServiceI
					.findByPK(dto.getBidId(), ctx);
			preferredSupplierDTO.setStatus("Accept");
			preferredSupplierServiceI.update(preferredSupplierDTO, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/rejectInvitation", method = RequestMethod.POST)
	public NcsResponseData rejectInvitation(@RequestBody MakeQuotationForm form, HttpSession session) {
		MakeQuotationDTO dto = (MakeQuotationDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(MakeQuotationDTO.class);
			sc.setAttribute("bidId", dto.getBidId());
			sc.setAttribute("invitedUserId", dto.getInvitedUserId());
			List<MakeQuotationDTO> list = makeQuotationServiceI.find(sc, ctx);

			for (MakeQuotationDTO makeQuotationDTO : list) {
				makeQuotationDTO.setInviteStatus("Reject");
				makeQuotationDTO.setIsReject(true);
				MessageDTO messageDTO = messageService.findByCode("S03", ctx);
				if (messageDTO != null) {
					String message = messageDTO.getMessage();
					message = message.replace("<user>", userDTO.getCreatedBy());
					message = message.replace("<bidRef>", makeQuotationDTO.getBidRefrenceNo());
					message = message.replace("<site>", "www.frozenB2B.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(userDTO.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}

				MessageDTO messageDTO1 = messageService.findByCode("B06", ctx);
				if (messageDTO1 != null) {
					String message = messageDTO1.getMessage();
					message = message.replace("<user>", makeQuotationDTO.getInvitedUserName());
					message = message.replace("<bidRef>", makeQuotationDTO.getBidRefrenceNo());
					message = message.replace("<site>", "www.frozenB2B.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO1.getTitle());
					receiverNotification.setFrom("system");
					receiverNotification.setMessage(message);
					receiverNotification.setTo(makeQuotationDTO.getCreatedBy());
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}
				MessageDTO messageDTO2 = messageService.findByCode("SU13", ctx);
				if (messageDTO2 != null) {
					String message = messageDTO2.getMessage();
					message = message.replace("<user>",makeQuotationDTO.getInvitedUserName());
					message = message.replace("<bidRef>", makeQuotationDTO.getBidRefrenceNo());
					message = message.replace("<site>", "www.frozenB2B.in");
					NotificationDTO receiverNotification = new NotificationDTO();
					receiverNotification.setSubject(messageDTO1.getTitle());
					receiverNotification.setFrom(makeQuotationDTO.getCreatedBy());
					receiverNotification.setMessage(message);
					receiverNotification.setTo("frozenb2b@mabl.in");
					receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
					receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
					notificationService.add(receiverNotification, ctx);
				}

				makeQuotationServiceI.update(makeQuotationDTO, ctx);
			}
			PreferredSupplierDTO preferredSupplierDTO = (PreferredSupplierDTO) preferredSupplierServiceI
					.findByPK(dto.getBidId(), ctx);
			preferredSupplierDTO.setStatus("Reject");
			preferredSupplierServiceI.update(preferredSupplierDTO, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	// Approved

	@RequestMapping(value = "/approveQuote", method = RequestMethod.POST)
	public NcsResponseData approveQuote(@RequestBody MakeQuotationForm form, HttpSession session) {
		MakeQuotationDTO dto = (MakeQuotationDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(MakeQuotationDTO.class);
			sc.setAttribute("=inviteGroupId", dto.getInviteGroupId());
			sc.setAttribute("=bidId", dto.getBidId());

			List<MakeQuotationDTO> list = makeQuotationServiceI.find(sc, ctx);
			List<UserDTO> list1 = usersService.find(sc, ctx);

			for (MakeQuotationDTO makeQuotationDTO : list) {

				if (dto.getIsQuote() == null) {
					makeQuotationDTO.setApproveUserId(dto.getApproveUserId());
					makeQuotationDTO.setIsQuote(true);
					service.update(makeQuotationDTO, ctx);
					ncsResponseData.setForm(form);
					ncsResponseData.setSuccess(true);
					ncsResponseData.setMessage("You have successfully allocate this user");
				} else {
					makeQuotationDTO.setApproveUserId(null);
					makeQuotationDTO.setIsQuote(null);
					service.update(makeQuotationDTO, ctx);
					ncsResponseData.setForm(form);
					ncsResponseData.setSuccess(false);
					ncsResponseData.setMessage("You have successfully deallocate this user");
				}
			}

		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}



}