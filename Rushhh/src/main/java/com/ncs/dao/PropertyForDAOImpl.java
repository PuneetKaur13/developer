
 




package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.PropertyForDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("propertyForDAO")
public class PropertyForDAOImpl extends BaseDAOImpl implements PropertyForDAOI {
	

	public Class dtoClass() {
		return PropertyForDTO.class;
	}

}
