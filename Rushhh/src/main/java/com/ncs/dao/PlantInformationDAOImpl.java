package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.PlantInformationDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("PlantInformationDAO")
public class PlantInformationDAOImpl extends BaseDAOImpl implements PlantInformationDAOI {
	
	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  PlantInformationDTO.class;
	}
	

}
