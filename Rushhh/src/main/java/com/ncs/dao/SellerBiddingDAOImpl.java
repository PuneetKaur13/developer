package com.ncs.dao;
import org.springframework.stereotype.Repository;

import com.ncs.dto.SellerBiddingDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("sellerbiddingDAO")
public class SellerBiddingDAOImpl extends BaseDAOImpl implements SellerBiddingDAOI{

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  SellerBiddingDTO.class;
	}


}
