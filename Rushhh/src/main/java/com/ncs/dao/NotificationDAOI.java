package com.ncs.dao;

import com.ncs.dto.NotificationDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.UserContext;

public interface NotificationDAOI extends BaseDAOI {
	public void merge(NotificationDTO notificationDTO, UserContext paramUserContext) throws Exception;

}
