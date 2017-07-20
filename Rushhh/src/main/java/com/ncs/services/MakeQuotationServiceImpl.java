package com.ncs.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("makeQuotationService")
public class MakeQuotationServiceImpl extends BaseServiceImpl implements MakeQuotationServiceI {

	@Override
	@Autowired
	@Qualifier("makeQuotationDao")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}

	@Autowired
	protected SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String findbyStringSql(String sql, UserContext userContext) {
		return (String) sessionFactory.getCurrentSession().save(sql);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void findbyStringSqlUpdate(String sql, UserContext userContext) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.executeUpdate();
	}
}
