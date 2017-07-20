package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("messageDAO")
public class MessageDAOImpl extends BaseDAOImpl implements MessageDAOI {

	public Class dtoClass() {
		return MessageDTO.class;
	}
}
