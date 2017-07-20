package com.ncs.services;

import java.util.HashMap;
import java.util.List;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

public interface NotificationServiceI extends BaseServiceI {

	public void newBidPosted(HashMap<String, String> map, UserContext ctx) throws Exception;

	public void newOfferPosted(SellerBiddingDTO dto, UserContext ctx) throws Exception;

	public void newBidPosted(BuyerBiddingDTO dto, UserContext ctx) throws Exception;

	public void newOfferPosted(HashMap<String, String> map, UserContext ctx) throws Exception;

	//public List findCount(SearchCriteria searchCriteria, UserContext userContext);
	
	public void merge(NotificationDTO dto, UserContext userContext) throws Exception;

	public List findCount(SearchCriteria searchCriteria, UserContext userContext);

}
