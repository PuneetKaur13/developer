package com.ncs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.AdminProductDAOI;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;
@Service("adminProductPackagingService")
public class AdminProductPackagingServiceImpl extends BaseServiceImpl implements AdminProductPackagingServiceI {
	@Override
	@Autowired
	@Qualifier("adminProductPackagingDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
		
		
	}
	@Autowired
	private AdminProductServiceI adminProductService;
	@Autowired
	private AdminProductDAOI adminProductDAO;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List l = super.find(searchCriteria, userContext);
		return l;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		AdminProductPackagingDTO cityDTO = (AdminProductPackagingDTO) dto;
		AdminProductDTO stateDTO = (AdminProductDTO) adminProductDAO.findByPK(cityDTO.getAdminProductId(), userContext);
		cityDTO.setAdminProductName(stateDTO.getName());
		long pk = dao.add(dto, userContext);
		return pk;
	}

}
