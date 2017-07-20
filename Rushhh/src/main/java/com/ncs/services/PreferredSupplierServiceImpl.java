package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("preferredSupplierService")
public class PreferredSupplierServiceImpl extends BaseServiceImpl implements PreferredSupplierServiceI {

	@Override
	@Autowired
	@Qualifier("preferredSupplierDAO")
	public void setDao(BaseDAOI dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
}
