package com.ncs.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.NotificationForm;
import com.ncs.form.OrganizationForm;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.NotificationServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.UnauthorizedAccessException;
import com.nenosystems.common.exception.UserNotFoundException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Notification")
public class NotificationCtl extends BaseCtl<NotificationForm> {

	private static Logger log = Logger.getLogger(NotificationCtl.class);

	@Override
	@Autowired
	@Qualifier("notificationService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private NotificationServiceI notificationService;

	public SearchCriteria getSearchCriteria(NotificationForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(NotificationDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());

		if (!DataValidator.isNull(form.getTo())) {
			sc.setAttribute("to", form.getTo());
		}

		if (!DataValidator.isNull(form.getFrom())) {
			sc.setAttribute("from", form.getFrom());
		}

		if (!DataValidator.isNull(form.getMessage())) {
			sc.setAttribute("subject", form.getSubject());
		}
		if (ctx != null && ctx.getBaseDTO() != null) {
			UserDTO dto = (UserDTO) ctx.getBaseDTO();
				sc.setAttribute("to", dto.getLoginId());
		}
		
		

		return sc;

	};

	/*
	 * @RequestMapping(value = "/searchByUser", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public NcsResponseData search(HttpSession session)
	 * throws Exception { NcsResponseData ncsResponseData = new
	 * NcsResponseData(); UserContext ctx = getUserContext(session); UserDTO
	 * userDTO = (UserDTO) ctx.getBaseDTO(); SearchCriteria sc = new
	 * SearchCriteria(); sc.setDto(NotificationDTO.class);
	 * sc.setAttribute("=to", userDTO.getLoginId()); List list =
	 * service.find(sc, ctx); ncsResponseData.setForm(null);
	 * ncsResponseData.setSuccess(true); ncsResponseData.setList(list); return
	 * ncsResponseData; }
	 */
	@RequestMapping(value = "/getNotificationCount", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getNotificationCount(HttpSession session)
			throws UserNotFoundException, UnauthorizedAccessException {
		SearchCriteria sc = new SearchCriteria();
		ctx = getUserContext(session);
		sc.setDto(NotificationDTO.class);
		try {
			List<NotificationDTO> notificationList = new ArrayList<NotificationDTO>();
			ncsResponseData = new NcsResponseData();
			if (ctx != null && ctx.getBaseDTO() != null) {
				UserDTO dto = (UserDTO) ctx.getBaseDTO();
				sc.setAttribute("to", dto.getLoginId());
				sc.setAttribute("deleted", 0);
				notificationList = notificationService.findCount(sc, ctx);
			}
			ncsResponseData.setList(notificationList);
			ncsResponseData.setForm(null);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setPreload(null);
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	/*
	 * @RequestMapping(value = "/getCount", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public List getAdminStatiStics(HttpSession session)
	 * {
	 * 
	 * UserContext ctx = getUserContext(session); UserDTO userDTO = (UserDTO)
	 * ctx.getBaseDTO(); List statiStics = service.
	 * findBySql("SELECT COUNT(DELETED) FROM NOTIFICATION WHERE NOT_TO= '" +
	 * userDTO.getCreatedBy() + "' AND DELETED = '0'", ctx);
	 * 
	 * Iterator iterator = statiStics.iterator();
	 * 
	 * while (iterator.hasNext()) { Object[] statiSticsDto = (Object[])
	 * iterator.next(); }
	 * 
	 * return statiStics;
	 * 
	 * }
	 */

}
