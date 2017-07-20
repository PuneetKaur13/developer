package com.ncs.services;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

public interface MessageServiceI extends BaseServiceI {
	// public MessageDTO findByCode(String code, UserContext context);

	public MessageDTO findByCode(String code, UserContext userContext) throws Exception;

	public String getSellerCount() throws Exception;

	 public String getBuyerCountList() throws Exception;
	 public String getProductCount() throws Exception;
	 public String getUserCount() throws Exception;

	}
