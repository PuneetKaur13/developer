package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.OrganizationDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("organizationDAO")
public class OrganizationDAOImpl extends BaseDAOImpl implements OrganizationDAOI {


	public Class dtoClass() {
		return OrganizationDTO.class;
	}

}
