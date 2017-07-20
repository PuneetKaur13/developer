package com.ncs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ncs.dto.BuyerQuotationDTO;
import com.nenosystems.common.dao.BaseDAOImpl;
import com.nenosystems.common.dto.UserContext;

@Repository("buyerquotationDAO")
public class BuyerQuotationDAOImpl extends BaseDAOImpl implements BuyerQuotationDAOI {

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return BuyerQuotationDTO.class;
	}
	
	
	public List findbySql(String sql, UserContext userContext) {
		List l = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return l;

	}

}
