package com.ncs.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.UserCardManagementDTO;
import com.ncs.form.UserCardManagementForm;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/UserCardManagement")
public class UserCardManagementCtl extends BaseCtl<UserCardManagementForm> {
	@Override
	@Autowired
	@Qualifier("userCardManagementService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	public SearchCriteria getSearchCriteria(UserCardManagementForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UserCardManagementDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getCardType())) {
			sc.setAttribute("cardType", form.getCardType());
		}
		if (!DataValidator.isNull(form.getCardReferenceNo())) {
			sc.setAttribute("cardReferenceNo", form.getCardReferenceNo());
		}
		return sc;
	};

}
