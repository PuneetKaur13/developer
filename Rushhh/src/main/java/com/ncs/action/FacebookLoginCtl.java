package com.ncs.action;

import com.ncs.dto.AgentDTO;
import com.ncs.dto.FacebookDTO;
import com.ncs.form.AgentForm;
import com.ncs.form.FacebookForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

public class FacebookLoginCtl extends BaseCtl<FacebookForm>
{

	@Override
	public void setService(BaseServiceI service) 
	{
		
		this.service = service;
	}
	
	public SearchCriteria getSearchCriteria(FacebookForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(FacebookDTO.class);
		sc.setPagging(true);
		//sc.setPage(form.getPageNo());
		//sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getName())) {
			sc.setAttribute("name", form.getName());
		}
		return sc;
	};


}
