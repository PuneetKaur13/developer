package com.ncs.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AdminDTO;
import com.ncs.form.AdminForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Admin")
public class AdminCtl extends BaseCtl<AdminForm> {

	private static Logger log = Logger.getLogger(AdminCtl.class);

	@Override
	@Autowired
	@Qualifier("adminService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	public SearchCriteria getSearchCriteria(AdminForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getAdminName())) {
			sc.setAttribute("adminName", form.getAdminName());
		}
		return sc;
	};

}
