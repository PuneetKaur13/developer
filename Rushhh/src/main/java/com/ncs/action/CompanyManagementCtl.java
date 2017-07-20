package com.ncs.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CompanyManagementDTO;
import com.ncs.dto.OrganizationDTO;
import com.ncs.dto.StateDTO;
import com.ncs.form.CompanyManagementForm;
import com.ncs.form.OrganizationForm;
import com.ncs.form.StateForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.dto.UserDTO;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/CompanyManagement")
public class CompanyManagementCtl extends BaseCtl<CompanyManagementForm> {

	private static Logger log = Logger.getLogger(CompanyManagementCtl.class);

	@Override
	@Autowired
	@Qualifier("companyManagementService")
	public void setService(BaseServiceI service) {
		this.service = service;

	}

	public SearchCriteria getSearchCriteria(CompanyManagementForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyManagementDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getCompanyName())) {
			sc.setAttribute("companyName", form.getCompanyName());
		}
		if (!DataValidator.isNull(form.getStatus())) {
			sc.setAttribute("status", form.getStatus());
		}
		return sc;
	}

}