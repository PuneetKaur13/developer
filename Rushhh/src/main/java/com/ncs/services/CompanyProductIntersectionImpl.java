package com.ncs.services;

import java.sql.Timestamp;
import java.util.Date;

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
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("companyProductIntersectionService")
public class CompanyProductIntersectionImpl extends BaseServiceImpl implements CompanyProductIntersectionI {
	
	@Override
	@Autowired
	@Qualifier("companyProductIntersectionDao")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
	
	
	@Autowired
	private AdminProductDAOI adminProductDAO = null;
	@Autowired
	private MessageServiceI messageService;
	@Autowired
	private NotificationServiceI notificationService;
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		CompanyProductIntersectionDTO companyProductIntersectionDTO = (CompanyProductIntersectionDTO) dto;
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(companyProductIntersectionDTO.getProductId(), userContext);
		companyProductIntersectionDTO.setProductName(adminProductDTO.getName());
		long pk = dao.add(dto, userContext);
		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		CompanyProductIntersectionDTO companyProductIntersectionDTO = (CompanyProductIntersectionDTO) dto;
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(companyProductIntersectionDTO.getProductId(), userContext);
		companyProductIntersectionDTO.setProductName(adminProductDTO.getName());
		
		
		MessageDTO messageDTO = messageService.findByCode("SU09", userContext);
		if (messageDTO != null) {
			String message = messageDTO.getMessage();
			message = message.replace("<loginId>", companyProductIntersectionDTO.getCreatedBy());
			message = message.replace("<product>", companyProductIntersectionDTO.getProductName());
			message = message.replace("<type>", companyProductIntersectionDTO.getProductType());
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom("system");
			receiverNotification.setMessage(message);
			receiverNotification.setTo(dto.getCreatedBy());
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationService.add(receiverNotification, userContext);
		}
		
		MessageDTO messageDTO1= messageService.findByCode("SU05", userContext);
		if (messageDTO1 != null) {
			String message = messageDTO1.getMessage();
			message = message.replace("<loginId>", companyProductIntersectionDTO.getCreatedBy());
			message = message.replace("<product>", companyProductIntersectionDTO.getProductName());
			message = message.replace("<type>", companyProductIntersectionDTO.getProductType());
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom(companyProductIntersectionDTO.getCreatedBy());
			receiverNotification.setMessage(message);
			receiverNotification.setTo("frozenb2b@mabl.in");
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationService.add(receiverNotification, userContext);
		}
		
		
		
		dao.update(dto, userContext);
	}
}
		