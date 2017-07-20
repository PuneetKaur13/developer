package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("PlantInformationService")
public class PlantInformationServiceImpl extends BaseServiceImpl implements PlantInformationServiceI {
	
	@Override
	@Autowired
	@Qualifier("PlantInformationDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
}
