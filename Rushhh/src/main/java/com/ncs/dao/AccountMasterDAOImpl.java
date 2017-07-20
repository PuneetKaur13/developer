package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.AccountMasterDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("accountMasterDAO")
public class AccountMasterDAOImpl extends BaseDAOImpl implements AccountMasterDAOI {

	public String getDtoName() {
		return "AccountMasterDTO";
	}

	public Class dtoClass() {
		return AccountMasterDTO.class;
	}

}
