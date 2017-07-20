package com.ncs.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CardTypeDTO;
import com.ncs.form.CardTypeForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/CardType")
public class CardTypeCtl extends BaseCtl<CardTypeForm>{
	@Override
	@Autowired
	@Qualifier("cardTypeService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	
	public SearchCriteria getSearchCriteria(CardTypeForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CardTypeDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getName())) {
			sc.setAttribute("name", form.getName());
		}
		return sc;
	};
}
