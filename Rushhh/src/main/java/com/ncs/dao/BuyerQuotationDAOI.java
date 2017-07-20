package com.ncs.dao;

import java.util.ArrayList;
import java.util.List;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.UserContext;

public interface BuyerQuotationDAOI extends BaseDAOI {
	
	public List<ArrayList> findbySql(String sql,UserContext userContext);

}
