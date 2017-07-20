package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.SellerQuotationDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("sellerquotationDAO")
public class SellerQuotationDAOImpl extends BaseDAOImpl implements SellerQuotationDAOI {

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return SellerQuotationDTO.class;
	}

}
