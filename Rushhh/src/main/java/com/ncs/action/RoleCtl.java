package com.ncs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CityDTO;
import com.ncs.dto.RoleDTO;
import com.ncs.form.CityForm;
import com.ncs.form.RoleForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.RoleServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Role")
public class RoleCtl extends BaseCtl<RoleForm> {

	private static Logger log = Logger.getLogger(RoleCtl.class);

	@Override
	@Autowired
	@Qualifier("roleService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	@Autowired
	private RoleServiceI roleServiceI;

	public SearchCriteria getSearchCriteria(RoleForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(RoleDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getRoleName())) {
			sc.setAttribute("roleName", form.getRoleName());
		}
		return sc;
	};
}
