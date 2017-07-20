package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;


@Service("organizationService")
public class OrganizationServiceImpl extends BaseServiceImpl implements OrganizationServiceI {

	@Override
	@Autowired
	@Qualifier("organizationDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}

}
