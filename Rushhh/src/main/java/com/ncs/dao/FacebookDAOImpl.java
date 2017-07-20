package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CounterOfferDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("FacebookDAO")
public class FacebookDAOImpl extends BaseDAOImpl implements FacebookDAOI {


	public Class dtoClass() {
		return CounterOfferDTO.class;
	}

}
