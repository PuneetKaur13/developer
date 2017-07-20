package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl implements AdminServiceI {

	@Override
	@Autowired
	@Qualifier("adminDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}

}