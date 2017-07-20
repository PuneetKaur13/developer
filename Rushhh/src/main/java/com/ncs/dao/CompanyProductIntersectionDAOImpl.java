package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("companyProductIntersectionDao")

public class CompanyProductIntersectionDAOImpl extends BaseDAOImpl implements CompanyProductIntersectionDAOI {
	
	public Class dtoClass() {
	
		return CompanyProductIntersectionDTO.class;
	}

}
