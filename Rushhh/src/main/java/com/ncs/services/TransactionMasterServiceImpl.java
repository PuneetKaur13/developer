package com.ncs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.CompanyDAOI;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.TransactionMasterDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;


@Service("transactionMasterService")
public class TransactionMasterServiceImpl extends BaseServiceImpl implements TransactionMasterServiceI {

	@Override
	@Autowired
	@Qualifier("transactionMasterDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List l = super.find(searchCriteria, userContext);
		return l;
	}
	
	@Autowired
	private CompanyDAOI companyDAOI = null;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		TransactionMasterDTO transactionMasterDTO = (TransactionMasterDTO) dto;
		CompanyDTO companyDTO = (CompanyDTO) companyDAOI.findByPK(transactionMasterDTO.getCompanyId(), userContext);
		transactionMasterDTO.setCompanyName(companyDTO.getCompanyName());
		long pk = dao.add(dto, userContext);
		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		TransactionMasterDTO transactionMasterDTO = (TransactionMasterDTO) dto;
		CompanyDTO companyDTO = (CompanyDTO) companyDAOI.findByPK(transactionMasterDTO.getCompanyId(), userContext);
		transactionMasterDTO.setCompanyName(companyDTO.getCompanyName());
		dao.update(dto, userContext);
	}
}
