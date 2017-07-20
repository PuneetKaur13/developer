package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.AdminProductDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("adminProductDAO")
public class AdminProductDAOImpl extends BaseDAOImpl implements AdminProductDAOI{
	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  AdminProductDTO.class;
	}


}
