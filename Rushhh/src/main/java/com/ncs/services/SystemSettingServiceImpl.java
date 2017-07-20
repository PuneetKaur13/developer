package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("systemSettingService")
public class SystemSettingServiceImpl extends BaseServiceImpl implements SystemSettingServiceI {
	@Override
	@Autowired
	@Qualifier("systemSettingDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
}
