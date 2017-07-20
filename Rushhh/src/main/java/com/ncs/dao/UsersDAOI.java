package com.ncs.dao;

import java.util.List;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dao.UserDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;

public interface UsersDAOI extends BaseDAOI{
	public List findbyHql(String hql, UserContext userContext);
	public BaseDTO delete(long id, boolean logicalDelete, UserContext userContext) throws Exception;
	
}
