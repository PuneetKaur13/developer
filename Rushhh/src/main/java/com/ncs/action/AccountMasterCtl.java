package com.ncs.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AccountMasterDTO;
import com.ncs.form.AccountMasterForm;
import com.nenosystems.common.action.BaseCtl;

import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/AccountMaster")
public class AccountMasterCtl extends BaseCtl<AccountMasterForm> {

	private static Logger log = Logger.getLogger(AccountMasterCtl.class);

	@Override
	@Autowired
	@Qualifier("accountMasterService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	public SearchCriteria getSearchCriteria(AccountMasterForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AccountMasterDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getCompanyName())) {
			sc.setAttribute("companyName", form.getCompanyName());
		}
		if (!DataValidator.isNull(form.getBalance())) {
			sc.setAttribute("balance", form.getBalance());
		}
		return sc;
	}
}