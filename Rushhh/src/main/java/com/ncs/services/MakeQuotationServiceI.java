package com.ncs.services;

import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

public interface MakeQuotationServiceI  extends BaseServiceI  {
	public String  findbyStringSql(String sql,UserContext userContext);
	public void  findbyStringSqlUpdate(String sql,UserContext userContext);
}
