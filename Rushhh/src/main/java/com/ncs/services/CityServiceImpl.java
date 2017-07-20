package com.ncs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dto.CityDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;



@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl implements CityServiceI {

	@Override
	@Autowired
	@Qualifier("cityDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List l = super.find(searchCriteria, userContext);
		return l;
	}
	@Autowired
	private com.ncs.dao.StateDAOI stateDAO = null;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		CityDTO cityDTO = (CityDTO) dto;
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(cityDTO.getStateId(), userContext);
		cityDTO.setStateName(stateDTO.getStateName());
		long pk = dao.add(dto, userContext);
		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		CityDTO cityDTO = (CityDTO) dto;
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(cityDTO.getStateId(), userContext);
		cityDTO.setStateName(stateDTO.getStateName());
		dao.update(dto, userContext);
	}
}
