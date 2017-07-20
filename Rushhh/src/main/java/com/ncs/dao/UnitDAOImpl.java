


package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.UnitDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("unitDAO")
public class UnitDAOImpl extends BaseDAOImpl implements UnitDAOI {
	

	public Class dtoClass() {
		return UnitDTO.class;
	}

}
