package com.ncs.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.AdminProductDAOI;
import com.ncs.dao.CityDAOI;
import com.ncs.dao.StateDAOI;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;

@Service("sellerbiddingService")
public class SellerBiddingServiceImpl extends BaseServiceImpl implements SellerBiddingServiceI {
	

	@Override
	@Autowired
	@Qualifier("sellerbiddingDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;

	}

	@Autowired
	private NotificationServiceI notificationService;
	
	@Autowired
	private StateDAOI stateDAO;
	
	
	@Autowired
	private CityDAOI cityDAO;
	
	@Autowired
	private AdminProductDAOI adminProductDAO;
	@Autowired
	private AdminProductPackagingServiceI adminProductPackagingService;
	
	@Autowired
	private NotificationServiceI notificationServiceI;
	@Autowired
	private MessageServiceI messageService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(BaseDTO dto, UserContext userContext) throws Exception {

		SellerBiddingDTO sellerBiddingDTO = (SellerBiddingDTO) dto;
	
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(sellerBiddingDTO.getStateId(), userContext);
		sellerBiddingDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(sellerBiddingDTO.getCityId(), userContext);
		sellerBiddingDTO.setCityName(cityDTO.getCityName());
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(sellerBiddingDTO.getProductId(), userContext);
		sellerBiddingDTO.setProductName(adminProductDTO.getName());
		AdminProductPackagingDTO adminProductPackagingDTO = (AdminProductPackagingDTO) adminProductPackagingService.findByPK(sellerBiddingDTO.getPackagingId(), userContext);
		sellerBiddingDTO.setPackaging(adminProductPackagingDTO.getPackaging());
		
		// TODO Auto-generated method stub
	
	
		long pk = dao.add(sellerBiddingDTO, userContext);
		offerrefrence(sellerBiddingDTO, userContext);
		
		
	
		
		MessageDTO messageDTO = messageService.findByCode("S01", userContext);
		if (messageDTO != null) {
			String message = messageDTO.getMessage();
			message = message.replace("<user>", sellerBiddingDTO.getCreatedBy());
			message = message.replace("<quantity>", sellerBiddingDTO.getQuantity().toString());
			message = message.replace("<offerRefrenceNo>", sellerBiddingDTO.getOfferRefrenceNo());
			message = message.replace("<product>", sellerBiddingDTO.getProductName());
			message = message.replace("<state>", sellerBiddingDTO.getStateName());
			message = message.replace("<city>", sellerBiddingDTO.getCityName());
			message = message.replace("<packaging>", sellerBiddingDTO.getPackaging());
			message = message.replace("<site>", "www.frozenb2b.in");
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom("system");
			receiverNotification.setMessage(message);
			receiverNotification.setTo(dto.getCreatedBy());
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationServiceI.add(receiverNotification, userContext);
		}
		
		MessageDTO messageDTO1 = messageService.findByCode("SU10", userContext);
		if (messageDTO1 != null) {
			String message = messageDTO1.getMessage();
			message = message.replace("<user>", sellerBiddingDTO.getCreatedBy());
			message = message.replace("<quantity>", sellerBiddingDTO.getQuantity().toString());
			message = message.replace("<offerRefrenceNo>", sellerBiddingDTO.getOfferRefrenceNo());
			message = message.replace("<product>", sellerBiddingDTO.getProductName());
			message = message.replace("<state>", sellerBiddingDTO.getStateName());
			message = message.replace("<city>", sellerBiddingDTO.getCityName());
			message = message.replace("<packaging>", sellerBiddingDTO.getPackaging());
			message = message.replace("<site>", "www.frozenb2b.in");
			NotificationDTO receiverNotification = new NotificationDTO();
			receiverNotification.setSubject(messageDTO.getTitle());
			receiverNotification.setFrom(dto.getCreatedBy());
			receiverNotification.setMessage(message);
			receiverNotification.setTo("frozenb2b@mabl.in");
			receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
			receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
			notificationServiceI.add(receiverNotification, userContext);
		}
		
		
		
		return pk;
	
	}
	public int count = 0001;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void offerrefrence(SellerBiddingDTO bbdto, UserContext ctx) {
		try {

			Long value = bbdto.getId();
			String form = String.format("%03d", value);
			Calendar now = Calendar.getInstance();
			int month = now.get(Calendar.MONTH);
			DateFormat df = new SimpleDateFormat("yyMM"); // Just the year, with
			String formattedDate = df.format(Calendar.getInstance().getTime());
			String refrenceNumber = "SO" + formattedDate + form;
			bbdto.setOfferRefrenceNo(refrenceNumber);
			System.out.println("offer refrence invoked");
			count++;
			// add(bbdto, ctx);
			System.out.println("Here is Refrence Number: " + refrenceNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(BaseDTO dto, UserContext ctx) throws Exception {
	
		SellerBiddingDTO sellerBiddingDTO = (SellerBiddingDTO) dto;
		StateDTO stateDTO = (StateDTO) stateDAO.findByPK(sellerBiddingDTO.getStateId(), ctx);
		sellerBiddingDTO.setStateName(stateDTO.getStateName());
		CityDTO cityDTO = (CityDTO) cityDAO.findByPK(sellerBiddingDTO.getCityId(), ctx);
		sellerBiddingDTO.setCityName(cityDTO.getCityName());
		AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductDAO.findByPK(sellerBiddingDTO.getProductId(), ctx);
		sellerBiddingDTO.setProductName(adminProductDTO.getName());
		AdminProductPackagingDTO adminProductPackagingDTO = (AdminProductPackagingDTO) adminProductPackagingService.findByPK(sellerBiddingDTO.getPackagingId(), ctx);
		sellerBiddingDTO.setPackaging(adminProductPackagingDTO.getPackaging());
		
		
		// TODO Auto-generated method stub
		SellerBiddingDTO sdto = (SellerBiddingDTO) dto;
		offerrefrence(sdto, ctx);
		dao.update(dto, ctx);
	}
}
