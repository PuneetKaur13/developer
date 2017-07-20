package com.ncs.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.AdminProductDAOI;
import com.ncs.dao.CompanyProductIntersectionDAOI;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.SellSupplierDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("sellSupplierService")
public class SellSupplierServiceImpl extends BaseServiceImpl implements SellSupplierServiceI {

	@Override
	@Autowired
	@Qualifier("sellSupplierDao")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}
	@Autowired
	protected SessionFactory sessionFactory = null;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private CompanyProductIntersectionDAOI companyProductIntersectionDAO;
	
	@Autowired
	private AdminProductDAOI adminProductDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		SellSupplierDTO sellSupplierDTO = (SellSupplierDTO) dto;
		
		CompanyProductIntersectionDTO companyProductIntersectionDTO = (CompanyProductIntersectionDTO) companyProductIntersectionDAO.findByPK(sellSupplierDTO.getCompanyId(), userContext);
		sellSupplierDTO.setCompanyName(companyProductIntersectionDTO.getCompanyName());
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(sellSupplierDTO.getProductId(), userContext);
		sellSupplierDTO.setProductName(adminProductDTO.getName());
		
		long pk = dao.add(dto, userContext);
		return pk;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		SellSupplierDTO sellSupplierDTO = (SellSupplierDTO) dto;
		CompanyProductIntersectionDTO companyProductIntersectionDTO = (CompanyProductIntersectionDTO) companyProductIntersectionDAO.findByPK(sellSupplierDTO.getCompanyId(), userContext);
		sellSupplierDTO.setCompanyName(companyProductIntersectionDTO.getCompanyName());
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(sellSupplierDTO.getProductId(), userContext);
		sellSupplierDTO.setProductName(adminProductDTO.getName());;
		dao.update(dto, userContext);
	}

	
}
