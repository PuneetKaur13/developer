package com.ncs.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AgentDTO;
import com.ncs.form.AgentForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Agent")
public class AgentCtl extends BaseCtl<AgentForm> {

	@Override
	@Autowired
	@Qualifier("agentService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	public SearchCriteria getSearchCriteria(AgentForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AgentDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getAgentName())) {
			sc.setAttribute("agentName", form.getAgentName());
		}
		return sc;
	};

}
