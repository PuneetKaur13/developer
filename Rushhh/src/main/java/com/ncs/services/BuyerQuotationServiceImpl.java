package com.ncs.services;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.BuyerBiddingDAOI;
import com.ncs.dao.BuyerQuotationDAOI;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("buyerquotationService")
public class BuyerQuotationServiceImpl extends BaseServiceImpl implements BuyerQuotationI {

	@Override
	@Autowired
	@Qualifier("buyerquotationDAO")
	public void setDao(BaseDAOI dao) {
		// TODO Auto-generated method stub
		this.dao = dao;

	}
}
