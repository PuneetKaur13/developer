package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CounterOfferDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("counterOfferDAO")
public class CounterOfferDAOImpl extends BaseDAOImpl implements CounterOfferDAOI {


	public Class dtoClass() {
		return CounterOfferDTO.class;
	}

}
