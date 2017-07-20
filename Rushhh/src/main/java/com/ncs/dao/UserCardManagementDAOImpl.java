package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.UserCardManagementDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("userCardManagementDAO")
public class UserCardManagementDAOImpl extends BaseDAOImpl implements UserCardManagementDAOI{
	
	public Class dtoClass() {
		return UserCardManagementDTO.class;
	}

}
