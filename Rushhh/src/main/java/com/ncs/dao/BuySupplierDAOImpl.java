package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.BuySupplierDTO;
import com.nenosystems.common.dao.BaseDAOImpl;


@Repository("buySupplierDao")
public class BuySupplierDAOImpl  extends BaseDAOImpl implements BuySupplierDAOI{

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return BuySupplierDTO.class;
	}

}
