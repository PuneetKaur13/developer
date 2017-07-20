package com.ncs.services;

import com.ncs.dto.SellerBiddingDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

public interface SellerBiddingServiceI extends BaseServiceI{
	public void offerrefrence(SellerBiddingDTO bbdto,UserContext ctx) throws Exception;
}
