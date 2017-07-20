package com.ncs.action;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CampaignManagementDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.OrganizationDTO;
import com.ncs.form.CampaignManagementForm;
import com.ncs.form.CityForm;
import com.ncs.form.CompanyManagementForm;
import com.ncs.form.OrganizationForm;
import com.ncs.services.CompanyManagementServiceI;
import com.ncs.services.StateServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.dto.UserDTO;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/CampaignManagement")
public class CampaignManagementCtl extends BaseCtl<CampaignManagementForm> {

	private static Logger log = Logger.getLogger(CampaignManagementDTO.class);

	@Override
	@Autowired
	@Qualifier("campaignManagementService")
	public void setService(BaseServiceI service) {
		this.service = service;

	}

	@Autowired
	private CompanyManagementServiceI companyManagementService;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("companyManagementList", companyManagementService.find(ctx));
		return map;
	}
	public SearchCriteria getSearchCriteria(CampaignManagementForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CampaignManagementDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getCompanyName())) {
			sc.setAttribute("companyName", form.getCompanyName());
		}
		if (!DataValidator.isNull(form.getCampaignName())) {
			sc.setAttribute("campaignName", form.getCampaignName());
		}
		return sc;
	}

}