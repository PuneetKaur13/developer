package com.ncs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.CityDAOI;
import com.ncs.dao.StateDAOI;
import com.ncs.dto.CityDTO;
import com.ncs.dto.PropertyDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("propertySearchService")
public class PropertySearchServicesImpl extends BaseServiceImpl implements PropertySearchServicesI {

	@Override
	@Autowired
	@Qualifier("propertySearchDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}
	

	@Autowired
	private StateDAOI stateDAO;

	@Autowired
	private CityDAOI cityDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List l = super.find(searchCriteria, userContext);
		return l;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		PropertyDTO propertyDTO = (PropertyDTO) dto;
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(propertyDTO.getStateId(), userContext);
		propertyDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(propertyDTO.getCityId(), userContext);
		propertyDTO.setCityName(cityDTO.getCityName());

		long pk = dao.add(dto, userContext);
		return pk;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		PropertyDTO propertyDTO = (PropertyDTO) dto;
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(propertyDTO.getStateId(), userContext);
		propertyDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(propertyDTO.getCityId(), userContext);
		propertyDTO.setCityName(cityDTO.getCityName());
		dao.update(dto, userContext);
	}
}