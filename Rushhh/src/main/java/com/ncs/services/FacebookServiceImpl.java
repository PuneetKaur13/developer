package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.services.BaseServiceImpl;

public class FacebookServiceImpl extends BaseServiceImpl implements FacebookServiceI
{

	@Override
	@Autowired
	@Qualifier("facebookDAO")

	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}
 
}
