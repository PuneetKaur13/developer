package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.NonPreferredSupplierDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("nonPreferredSupplierDAO")
public class NonPreferredSupplierDAOImpl extends BaseDAOImpl implements NonPreferredSupplierDAOI{
	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  NonPreferredSupplierDTO.class;
	}
}
