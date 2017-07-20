package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.ProductDTO;
import com.nenosystems.common.dao.BaseDAOImpl;
@Repository("productDAO")
public class ProductDAOImpl  extends BaseDAOImpl{

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  ProductDTO.class;
	}
	
}
