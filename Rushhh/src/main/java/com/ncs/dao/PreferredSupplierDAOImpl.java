package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.PreferredSupplierDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("preferredSupplierDAO")
public class PreferredSupplierDAOImpl extends BaseDAOImpl implements PreferredSupplierDAOI{
	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  PreferredSupplierDTO.class;
	}
}
