package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dto.BannerManagementDTO;
import com.ncs.dto.CampaignManagementDTO;
import com.ncs.dto.CompanyManagementDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;


@Service("bannerManagementService")
public class BannerManagementServiceImpl extends BaseServiceImpl implements BannerManagementServiceI {

	@Override
	@Autowired
	@Qualifier("bannerManagementDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
	@Autowired
	CompanyManagementServiceI companyMangementService;
	
	@Autowired
	CampaignManagementServiceI campaignManagementService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		BannerManagementDTO cmDTO = (BannerManagementDTO) dto;
		CompanyManagementDTO companyManagementDTO = (CompanyManagementDTO) companyMangementService.findByPK(cmDTO.getCompanyId(), userContext);
		cmDTO.setCompanyName(companyManagementDTO.getCompanyName());
		CampaignManagementDTO campaignManagementDTO=(CampaignManagementDTO) campaignManagementService.findByPK(cmDTO.getCampaignId(),userContext);
		cmDTO.setCampaignName(campaignManagementDTO.getCampaignName());
		return dao.add(cmDTO, userContext);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		// TODO Auto-generated method stub
		BannerManagementDTO cmDTO = (BannerManagementDTO) dto;
		CompanyManagementDTO companyManagementDTO = (CompanyManagementDTO) companyMangementService.findByPK(cmDTO.getCompanyId(), userContext);
		cmDTO.setCompanyName(companyManagementDTO.getCompanyName());
		CampaignManagementDTO campaignManagementDTO=(CampaignManagementDTO) campaignManagementService.findByPK(cmDTO.getCampaignId(),userContext);
		cmDTO.setCampaignName(campaignManagementDTO.getCampaignName());
		dao.update(dto, userContext);;
	}
	
	
}