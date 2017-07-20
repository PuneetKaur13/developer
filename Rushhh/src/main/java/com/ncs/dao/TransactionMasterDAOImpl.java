package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.TransactionMasterDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("transactionMasterDAO")
public class TransactionMasterDAOImpl extends BaseDAOImpl implements TransactionMasterDAOI {

	public String getDtoName() {
		return "TransactionMasterDTO";
	}

	public Class dtoClass() {
		return TransactionMasterDTO.class;
	}

}
