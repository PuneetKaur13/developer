package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.MessageCenterDTO;
import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("messageCenterDAO")
public class MessageCenterDAOImpl extends BaseDAOImpl implements MessageCenterDAOI {
	
	public Class dtoClass() {
		return MessageCenterDTO.class;
	}

}
