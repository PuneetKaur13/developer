
package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.PropertyTypeDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("propertyTypeDAO")
public class PropertyTypeDAOImpl extends BaseDAOImpl implements PropertyTypeDAOI {
	

	public Class dtoClass() {
		return PropertyTypeDTO.class;
	}

}
