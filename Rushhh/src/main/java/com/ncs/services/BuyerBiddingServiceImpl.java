package com.ncs.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.AdminProductDAOI;
import com.ncs.dao.BuyerBiddingDAOI;
import com.ncs.dao.CityDAOI;
import com.ncs.dao.StateDAOI;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.SystemSettingDTO;
import com.ncs.dto.UserDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;
import com.nenosystems.common.util.DataUtil;

@Service("buyerbiddingService")
public class BuyerBiddingServiceImpl extends BaseServiceImpl implements BuyerBiddingServiceI {
	int count = 0001;

	@Override
	@Autowired
	@Qualifier("buyerbiddingDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}

	@Autowired
	private SystemSettingServiceI systemSettingService;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private MakeQuotationServiceI makeQuotationService;
	
	
	@Autowired
	private UsersServiceI usersService;

	@Autowired
	private BuyerBiddingDAOI buyerBiddingDAOI = null;

	@Autowired
	private MessageServiceI messageService = null;

	@Autowired
	protected SessionFactory sessionFactory;

	@Autowired
	private StateDAOI stateDAO;

	@Autowired
	private CityDAOI cityDAO;

	@Autowired
	private AdminProductDAOI adminProductDAO;
	

	@Autowired
	private PreferredSupplierServiceI preferredSupplierService;
	
	
	@Autowired
	private AdminProductPackagingServiceI adminProductPackagingService;
	
	


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {
		// TODO Auto-generated method stub

		BuyerBiddingDTO buyerBiddingDTO = (BuyerBiddingDTO) dto;

		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(buyerBiddingDTO.getStateId(), userContext);
		buyerBiddingDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(buyerBiddingDTO.getCityId(), userContext);
		buyerBiddingDTO.setCityName(cityDTO.getCityName());
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(buyerBiddingDTO.getProductId(),
				userContext);
		buyerBiddingDTO.setProductName(adminProductDTO.getName());
		AdminProductPackagingDTO adminProductPackagingDTO = (AdminProductPackagingDTO) adminProductPackagingService
				.findByPK(buyerBiddingDTO.getPackagingId(), userContext);
		buyerBiddingDTO.setPackaging(adminProductPackagingDTO.getPackaging());
		long pk = dao.add(buyerBiddingDTO, userContext);
		refrence(buyerBiddingDTO, userContext);
		MessageDTO messageDTO = messageService.findByCode("B02", userContext);
		if (messageDTO != null) {
			String message = messageDTO.getMessage();
			message = message.replace("<user>", buyerBiddingDTO.getCreatedBy());
			message = message.replace("<product>", buyerBiddingDTO.getProductName());
			message = message.replace("<quantity>", buyerBiddingDTO.getQuantity().toString());
			message = message.replace("<packaging>", buyerBiddingDTO.getPackaging());
			message = message.replace("<state>", buyerBiddingDTO.getStateName());
			message = message.replace("<city>", buyerBiddingDTO.getCityName());
			message = message.replace("<bidRefrenceNo>", buyerBiddingDTO.getBidRefrenceNo());
			message = message.replace("<bidAmount>", buyerBiddingDTO.getBidAmount().toString());
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom("system");
			receiverNotification.setMessage(message);
			receiverNotification.setTo(dto.getCreatedBy());
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationService.add(receiverNotification, userContext);
		}
		
		MessageDTO messageDTO1 = messageService.findByCode("SU11", userContext);
		if (messageDTO1 != null) {
			String message = messageDTO1.getMessage();
			message = message.replace("<user>", buyerBiddingDTO.getCreatedBy());
			message = message.replace("<product>", buyerBiddingDTO.getProductName());
			message = message.replace("<quantity>", buyerBiddingDTO.getQuantity().toString());
			message = message.replace("<packaging>", buyerBiddingDTO.getPackaging());
			message = message.replace("<state>", buyerBiddingDTO.getStateName());
			message = message.replace("<city>", buyerBiddingDTO.getCityName());
			message = message.replace("<bidRefrenceNo>", buyerBiddingDTO.getBidRefrenceNo());
			message = message.replace("<bidAmount>", buyerBiddingDTO.getBidAmount().toString());
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom( buyerBiddingDTO.getCreatedBy());
			receiverNotification.setMessage(message);
			receiverNotification.setTo("frozenb2b@mabl.in");
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationService.add(receiverNotification, userContext);
		}
		
		
		// notificationService.newBidPosted(bdto, ctx);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String findbyStringSql(String sql, UserContext userContext) {
		return (String) sessionFactory.getCurrentSession().save(sql);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void findbyStringSqlUpdate(String sql, UserContext userContext) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.executeUpdate();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void refrence(BuyerBiddingDTO bbdto, UserContext ctx) {
		try {
			Long value = bbdto.getId();
			String form = String.format("%03d", value);
			Calendar now = Calendar.getInstance();
			int month = now.get(Calendar.MONTH);
			DateFormat df = new SimpleDateFormat("yyMM"); // Just the year, with
															// 2 digits
			String formattedDate = df.format(Calendar.getInstance().getTime());
			String refrenceNumber = "BR" + formattedDate + form;
			bbdto.setBidRefrenceNo(refrenceNumber);
			count++;
			// add(bbdto, ctx);
			System.out.println("Here is Refrence Number: " + refrenceNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext userContext) throws Exception {
	
	BuyerBiddingDTO buyerBiddingDTO = (BuyerBiddingDTO) dto;
		
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(buyerBiddingDTO.getStateId(), userContext);
		buyerBiddingDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(buyerBiddingDTO.getCityId(), userContext);
		buyerBiddingDTO.setCityName(cityDTO.getCityName());
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(buyerBiddingDTO.getProductId(), userContext);
		buyerBiddingDTO.setProductName(adminProductDTO.getName());
		AdminProductPackagingDTO adminProductPackagingDTO = (AdminProductPackagingDTO) adminProductPackagingService.findByPK(buyerBiddingDTO.getPackagingId(), userContext);
		buyerBiddingDTO.setPackaging(adminProductPackagingDTO.getPackaging());
		
		// TODO Auto-generated method stub
	
		refrence(buyerBiddingDTO, userContext);
		dao.update(dto, userContext);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BaseDTO delete(long id, UserContext userContext) throws Exception {
		SearchCriteria sc = null;
		BuyerBiddingDTO buyerBiddingDTO = (BuyerBiddingDTO) findByPK(id, userContext);
		BuyerBiddingDTO userdto = (BuyerBiddingDTO) super.delete(id, userContext);
		sc = new SearchCriteria(MakeQuotationDTO.class);
		sc.setAttribute("createdBy", userdto.getCreatedBy());
		sc.setAttribute("bidId",buyerBiddingDTO.getId());
		System.out.println(buyerBiddingDTO.getId());
		List<MakeQuotationDTO> makeQuotationDTOs = makeQuotationService.find(sc, userContext);
		
		for (MakeQuotationDTO makeQuotationDTO : makeQuotationDTOs) {
			makeQuotationService.delete(makeQuotationDTO.getId(), userContext);
		}
		
		sc = new SearchCriteria(PreferredSupplierDTO.class);
		sc.setAttribute("createdBy", userdto.getCreatedBy());
		sc.setAttribute("bidId",buyerBiddingDTO.getId());
		List<PreferredSupplierDTO> preferredSupplierDTOs = preferredSupplierService.find(sc, userContext);
		for (PreferredSupplierDTO preferredSupplierDTO : preferredSupplierDTOs) {
			System.out.println("innnnnnnnnnnnnnnnnnnnn");
			preferredSupplierService.delete(preferredSupplierDTO.getId(), userContext);
		}
	
		return buyerBiddingDTO;
	}
	
}
