package com.ncs.action;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BannerManagementDTO;
import com.ncs.dto.CampaignManagementDTO;
import com.ncs.dto.OrganizationDTO;
import com.ncs.form.BannerManagementForm;
import com.ncs.form.CampaignManagementForm;
import com.ncs.form.CompanyManagementForm;
import com.ncs.form.OrganizationForm;
import com.ncs.services.CampaignManagementServiceI;
import com.ncs.services.CompanyManagementServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.dto.UserDTO;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/BannerManagement")
public class BannerManagementCtl extends BaseCtl<BannerManagementForm> {
	 
	    private static Logger log = Logger.getLogger(BannerManagementDTO.class);

		@Override
		@Autowired
		@Qualifier("bannerManagementService")
		public void setService(BaseServiceI service) {
			 this.service = service;
		}
		
		@Autowired
		private CompanyManagementServiceI companyManagementService;
		
		@Autowired
		private CampaignManagementServiceI campaignManagementService;
		@Override
		public HashMap<String, Object> preload() throws Exception {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("companyManagementList", companyManagementService.find(ctx));
			map.put("campaignManagementList", campaignManagementService.find(ctx));
			return map;
		}
		public SearchCriteria getSearchCriteria(BannerManagementForm form) {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(BannerManagementDTO.class);
			sc.setPagging(true);
			sc.setPage(form.getPageNo());
			sc.setNoOfRecords(form.getPageSize());
			if (!DataValidator.isNull(form.getCompanyName())) {
				sc.setAttribute("companyName", form.getCompanyName());
			}
			if (!DataValidator.isNull(form.getCampaignName())) {
				sc.setAttribute("campaignName", form.getCampaignName());
			}
			if (!DataValidator.isNull(form.getBannerName())) {
				sc.setAttribute("bannerName", form.getBannerName());
			}
			
			return sc;
		}
}