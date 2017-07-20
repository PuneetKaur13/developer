package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.PropertySearchDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("propertySearchDAO")
public class PropertySearchDAOImpl extends BaseDAOImpl implements PropertySearchDAOI {

	public Class dtoClass() {

		return PropertySearchDTO.class;
	}

}
