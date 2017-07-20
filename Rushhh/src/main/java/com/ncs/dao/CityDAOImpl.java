package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CityDTO;
import com.ncs.dto.OrganizationDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("cityDAO")
public class CityDAOImpl extends BaseDAOImpl implements CityDAOI {
	
	public Class dtoClass() {
		return CityDTO.class;
	}

}
