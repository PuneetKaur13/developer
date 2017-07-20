package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.CampaignManagementDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("campaignManagementDAO")
public class CampaignManagementDAOImpl extends BaseDAOImpl implements CampaignManagementDAOI {
	public Class dtoClass() {
		return CampaignManagementDTO.class;
	}

}
