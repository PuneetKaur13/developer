package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl implements
		ProductServiceI {

	@Override
	@Autowired
	@Qualifier("productDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}

}
