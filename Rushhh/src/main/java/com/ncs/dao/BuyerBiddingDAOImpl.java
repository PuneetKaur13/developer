package com.ncs.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.nenosystems.common.dao.BaseDAOImpl;
import com.nenosystems.common.dto.UserContext;

@Repository("buyerbiddingDAO")
public class BuyerBiddingDAOImpl extends BaseDAOImpl implements BuyerBiddingDAOI{

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  BuyerBiddingDTO.class;
	}
	public List findbySql(String sql, UserContext userContext) {
		List l = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		return l;
	}

}
