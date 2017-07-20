package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.AdminProductPackagingDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("adminProductPackagingDAO")
public class AdminProductPackagingDAOImpl extends BaseDAOImpl implements AdminProductDAOI{
	
	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  AdminProductPackagingDTO.class;
	}
}
