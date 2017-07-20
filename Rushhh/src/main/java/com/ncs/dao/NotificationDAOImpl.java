package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.NotificationDTO;
import com.nenosystems.common.dao.BaseDAOImpl;
import com.nenosystems.common.dto.UserContext;

@Repository("notificationDAO")
public class NotificationDAOImpl extends BaseDAOImpl implements NotificationDAOI {

	public Class dtoClass() {
		return NotificationDTO.class;
	}
	
	public void merge(NotificationDTO notificationDTO, UserContext
			paramUserContext) throws Exception {
		sessionFactory.getCurrentSession().merge(notificationDTO);
	}

	
}
