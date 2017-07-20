package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.SystemSettingDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("systemSettingDAO")
public class SystemSettingDAOImpl  extends BaseDAOImpl implements SystemSettingDAOI {
	
	public Class dtoClass() {
		// TODO Auto-generated method stub
		return  SystemSettingDTO.class;
	}
}


