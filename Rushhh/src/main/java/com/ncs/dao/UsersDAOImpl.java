package com.ncs.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ncs.dto.OrganizationDTO;
import com.ncs.dto.UserDTO;
import com.nenosystems.common.dao.BaseDAOImpl;
import com.nenosystems.common.dao.UserDAOImpl;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;

@Repository("usersDAO")
public class UsersDAOImpl extends BaseDAOImpl implements UsersDAOI {

	public Class dtoClass() {
		return UserDTO.class;
	}
}
