package com.ncs.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.services.BaseServiceImpl;


@Service("buySupplierService")
public class BuySupplierServiceImpl extends BaseServiceImpl implements BuySupplierServiceI {

	
	@Override
	@Autowired
	@Qualifier("buySupplierDao")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}
}
