package com.ncs.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.NotificationDAOI;
import com.ncs.dto.CityDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;
import com.nenosystems.common.util.NCSMailUtil;

@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl implements CompanyServiceI {

	@Override
	@Autowired
	@Qualifier("companyDAO")
	public void setDao(BaseDAOI dao) {
		// TODO Auto-generated method stub
		this.dao = dao;

	}

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private NotificationServiceI notificationService;
	
	@Autowired
	private NotificationDAOI notificationDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List l = super.find(searchCriteria, userContext);
		return l;
	}

	@Autowired
	private com.ncs.dao.StateDAOI stateDAO = null;
	@Autowired
	private com.ncs.dao.CityDAOI cityDAO = null;
	@Autowired
	private com.ncs.dao.UsersDAOI usersDAO = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		CompanyDTO companyDTO = (CompanyDTO) dto;
		if (!DataValidator.isNull(companyDTO.getId())) {
			StateDTO stateDTO = (StateDTO) stateDAO.findByPK(companyDTO.getStateId(), userContext);
			companyDTO.setStateName(stateDTO.getStateName());
			CityDTO cityDTO = (CityDTO) cityDAO.findByPK(companyDTO.getCityId(), userContext);
			companyDTO.setCityName(cityDTO.getCityName());
			UserDTO userDTO = (UserDTO) usersDAO.findByPK(companyDTO.getId(), userContext);
			companyDTO.setGroupIdString(userDTO.getGroupIdString());
			companyDTO.setGroupId(userDTO.getGroupId());
			userDTO.setUserCompany(companyDTO.getCompanyName());
			userDTO.setUserCompanyId(companyDTO.getId());
			System.out.println("inside message");
			
		}
		long pk = dao.add(dto, userContext);
		MessageDTO messageDTO1 = messageService.findByCode("SU03", userContext);
		if (messageDTO1 != null) {
	
			String message = messageDTO1.getMessage();
			message = message.replace("<loginId>",companyDTO.getCreatedBy());
			message = message.replace("<companyName>",companyDTO.getCompanyName());
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO1.getTitle());
			receiverNotification.setFrom("system");
			receiverNotification.setMessage(message);
			receiverNotification.setTo("frozenb2b@mabl.in");
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationDAO.add(receiverNotification, userContext);
		}
		
		
		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
		CompanyDTO companyDTO = (CompanyDTO) dto;
		if (!DataValidator.isNull(companyDTO.getStateId())) {
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(companyDTO.getStateId(), userContext);
		companyDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(companyDTO.getCityId(), userContext);
		companyDTO.setCityName(cityDTO.getCityName());
		UserDTO userDTO = (UserDTO) usersDAO.findByPK(companyDTO.getId(), userContext);
		companyDTO.setGroupIdString(userDTO.getGroupIdString());
		companyDTO.setGroupId(userDTO.getGroupId());
		userDTO.setUserCompany(companyDTO.getCompanyName());
		userDTO.setUserCompanyId(companyDTO.getId());
		}
		dao.update(dto, userContext);
	}

}
