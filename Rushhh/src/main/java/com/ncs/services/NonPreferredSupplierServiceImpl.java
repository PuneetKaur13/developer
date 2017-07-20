package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("nonPreferredSupplierService")
public class NonPreferredSupplierServiceImpl extends BaseServiceImpl implements NonPreferredSupplierServiceI {

	@Override
	@Autowired
	@Qualifier("nonPreferredSupplierDAO")
	public void setDao(BaseDAOI dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
}
