package com.ncs.services;

import java.util.HashMap;
import java.util.Hashtable;

import com.ncs.dto.BuyerBiddingDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

public interface BuyerBiddingServiceI extends BaseServiceI{
	
	public void refrence(BuyerBiddingDTO dto,UserContext ctx) throws Exception;
	public String  findbyStringSql(String sql,UserContext userContext);
	public void  findbyStringSqlUpdate(String sql,UserContext userContext);
	
	

}
