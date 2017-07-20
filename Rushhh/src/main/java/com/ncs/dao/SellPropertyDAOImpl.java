package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CardTypeDTO;
import com.ncs.dto.SellPropertyDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("sellPropertyDAO")
public class SellPropertyDAOImpl extends BaseDAOImpl implements SellPropertyDAOI{
	public Class dtoClass() {
		return CardTypeDTO.class;
	}
}
