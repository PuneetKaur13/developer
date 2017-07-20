package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CardTypeDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("cardTypeDAO")
public class CardTypeDAOImpl extends BaseDAOImpl implements CardTypeDAOI{
	public Class dtoClass() {
		return CardTypeDTO.class;
	}
}
