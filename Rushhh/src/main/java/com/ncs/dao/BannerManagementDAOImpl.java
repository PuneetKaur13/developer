package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.BannerManagementDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("bannerManagementDAO")
public class BannerManagementDAOImpl extends BaseDAOImpl implements BannerManagementDAOI {
	public Class dtoClass() {
		return BannerManagementDTO.class;
	}

}
