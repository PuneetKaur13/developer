package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CompanyManagementDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("companyManagementDAO")
public class CompanyManagementDAOImpl extends BaseDAOImpl implements CompanyManagementDAOI {
	public Class dtoClass() {
		return CompanyManagementDTO.class;
	}

}
