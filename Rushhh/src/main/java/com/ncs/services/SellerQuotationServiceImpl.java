package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;
@Service("sellerquotationService")
public class SellerQuotationServiceImpl extends BaseServiceImpl implements SellerQuotationI   {

	@Override
	@Autowired
	@Qualifier("sellerquotationDAO")
	public void setDao(BaseDAOI dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
		
	}

}
