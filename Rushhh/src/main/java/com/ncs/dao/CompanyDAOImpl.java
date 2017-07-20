package com.ncs.dao;
import org.springframework.stereotype.Repository;

import com.ncs.dto.CompanyDTO;
import com.ncs.dto.OrganizationDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("companyDAO")
public class CompanyDAOImpl extends BaseDAOImpl implements CompanyDAOI  {


	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  CompanyDTO.class;
	}

}
