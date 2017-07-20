package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.AgentDTO;
import com.ncs.dto.BannerManagementDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("agentDAO")
public class AgentDAOImpl extends BaseDAOImpl implements AgentDAOI {
	public Class dtoClass() {
		return AgentDTO.class;
	}
}


