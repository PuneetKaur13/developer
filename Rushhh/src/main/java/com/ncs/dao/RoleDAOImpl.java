package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.RoleDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("roleDAO")
public class RoleDAOImpl extends BaseDAOImpl implements RoleDAOI{
	public String getDtoName() {
		return "RoleDTO";
	}

	public Class dtoClass() {
		return RoleDTO.class;
	}
	
}
