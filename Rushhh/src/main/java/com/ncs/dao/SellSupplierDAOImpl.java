package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.SellSupplierDTO;
import com.nenosystems.common.dao.BaseDAOImpl;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;


@Repository("sellSupplierDao")
public class SellSupplierDAOImpl  extends BaseDAOImpl implements SellSupplierDAOI{

	public Class dtoClass() {
		// TODO Auto-generated method stub
		return SellSupplierDTO.class;
	}
	
	public BaseDTO selectAll(long id, Class className, UserContext userContext)
			throws Exception {
		BaseDTO dto = findByPK(id, className, userContext);
		sessionFactory.getCurrentSession().delete(dto);
		return dto;
	}

}