package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.AdminDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("adminDAO")
public class AdminDAOImpl extends BaseDAOImpl implements AdminDAOI {

	public String getDtoName() {
		return "AdminDTO";
	}

	public Class dtoClass() {
		return AdminDTO.class;
	}

}
