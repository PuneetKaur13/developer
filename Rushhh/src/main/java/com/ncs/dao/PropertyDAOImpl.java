package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.PropertyDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("propertyDAO")
public class PropertyDAOImpl extends BaseDAOImpl implements PropertyDAOI {
	
	public Class dtoClass() {
		return PropertyDTO.class;
	}


}
