package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("stateDAO")
public class StateDAOImpl extends BaseDAOImpl implements StateDAOI {
	

	public Class dtoClass() {
		return StateDTO.class;
	}

}
