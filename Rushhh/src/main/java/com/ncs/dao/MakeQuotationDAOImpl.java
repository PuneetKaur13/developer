package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.services.MakeQuotationServiceI;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("makeQuotationDao")
public class MakeQuotationDAOImpl extends BaseDAOImpl implements MakeQuotationDAOI{
	
	public Class dtoClass() {
		return  MakeQuotationDTO.class;
	}
}
