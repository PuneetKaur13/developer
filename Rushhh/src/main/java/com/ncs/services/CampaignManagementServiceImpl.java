package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dto.CampaignManagementDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.CompanyManagementDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;


@Service("campaignManagementService")
public class CampaignManagementServiceImpl extends BaseServiceImpl implements CampaignManagementServiceI {

	@Override
	@Autowired
	@Qualifier("campaignManagementDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
	@Autowired
	CompanyManagementServiceI companyMangementService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		CampaignManagementDTO cityDTO = (CampaignManagementDTO) dto;
		CompanyManagementDTO stateDTO = (CompanyManagementDTO) companyMangementService.findByPK(cityDTO.getCompanyId(), userContext);
		cityDTO.setCompanyName(stateDTO.getCompanyName());
		return dao.add(cityDTO, userContext);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		// TODO Auto-generated method stub
		CampaignManagementDTO campaignManagementDTO = (CampaignManagementDTO) dto;
		CompanyManagementDTO companyManagementDTO = (CompanyManagementDTO) companyMangementService.findByPK(campaignManagementDTO.getCompanyId(), userContext);
		campaignManagementDTO.setCompanyName(companyManagementDTO.getCompanyName());
		dao.update(dto, userContext);;
	}
	
	
}