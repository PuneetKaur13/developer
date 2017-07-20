package com.ncs.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.MessageForm;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.SellerBiddingServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Message")
public class MessageCtl extends BaseCtl<MessageForm> {
	private static Logger log = Logger.getLogger(MessageCtl.class);

	@Override
	@Autowired
	@Qualifier("messageService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private BuyerBiddingServiceI buyerbiddingservice;

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private SellerBiddingServiceI sellerbiddingservice;

	public SearchCriteria getSearchCriteria(MessageForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(MessageDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());

		if (!DataValidator.isNull(form.getType())) {
			sc.setAttribute("type", form.getType());
		}

		if (!DataValidator.isNull(form.getTitle())) {
			sc.setAttribute("title", form.getTitle());
		}

		if (!DataValidator.isNull(form.getMessage())) {
			sc.setAttribute("message", form.getMessage());
		}

		if (!DataValidator.isNull(form.getCode())) {
			sc.setAttribute("code", form.getCode());
		}
		return sc;
	}

	@RequestMapping(value = "/getSellerCountList", method = RequestMethod.GET)
	public String getSellerCountList() throws Exception {
		System.out.println("controller alarm live data");
		String ht = messageService.getSellerCount();
		System.out.println("value" + ht);
		return ht;
	}

	@RequestMapping(value = "/getBuyerCountList", method = RequestMethod.GET)
	public String getBuyerCountList() throws Exception {
		String ht = messageService.getBuyerCountList();
		System.out.println("value" + ht);
		return ht;

	}

	@RequestMapping(value = "/getProductCountList", method = RequestMethod.GET)
	public String getProductCountList() throws Exception {
		String ht = messageService.getProductCount();
		return ht;

	}

	@RequestMapping(value = "/getUserCountList", method = RequestMethod.GET)
	public String getUserCountList() throws Exception {
		String ht = messageService.getUserCount();
		return ht;
	}

	@RequestMapping(value = "/offersList", method = { RequestMethod.GET, RequestMethod.POST })
	public List offersList(HttpSession session) throws Exception {
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		List allSellerData = buyerbiddingservice.findBySql("SELECT * FROM SELLER_BID WHERE STATUS='ACTIVE'", ctx);
		Iterator iterator = allSellerData.iterator();
		while (iterator.hasNext()) {
			Object[] statiSticsDto = (Object[]) iterator.next();
		}
		return allSellerData;
	}

	@RequestMapping(value = "/requirementList", method = { RequestMethod.GET, RequestMethod.POST })
	public List getAllBuyerData(HttpSession session) throws Exception {
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		List allSellerData = sellerbiddingservice.findBySql("SELECT * FROM BUYER_BID", ctx);
		Iterator iterator = allSellerData.iterator();
		while (iterator.hasNext()) {
			Object[] statiSticsDto = (Object[]) iterator.next();
		}
		return allSellerData;
	}

}
