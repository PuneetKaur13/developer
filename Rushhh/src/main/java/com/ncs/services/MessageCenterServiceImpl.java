package com.ncs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.AdminProductDAOI;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.MessageCenterDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;
@Service("messageCenterService")
public class MessageCenterServiceImpl extends BaseServiceImpl implements MessageCenterServiceI {
	
	@Override
	@Autowired
	@Qualifier("messageCenterDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
	@Autowired
	private AdminProductDAOI adminProductDAO;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		MessageCenterDTO messageCenterDTO = (MessageCenterDTO) dto;
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(messageCenterDTO.getProductId(), userContext);
		messageCenterDTO.setProductName(adminProductDTO.getName());
		long pk = dao.add(dto, userContext);
		return pk;
	}

}
