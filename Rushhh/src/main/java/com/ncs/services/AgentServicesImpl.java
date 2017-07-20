package com.ncs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("agentService")
public class AgentServicesImpl extends BaseServiceImpl implements AgentServicesI {

	@Override
	@Autowired
	@Qualifier("agentDAO")

	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}

}