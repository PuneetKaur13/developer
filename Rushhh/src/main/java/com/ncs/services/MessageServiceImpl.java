package com.ncs.services;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.MessageDAOI;
import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;
import com.nenosystems.common.services.UserServiceI;

@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl implements MessageServiceI {
	@Override
	@Autowired
	@Qualifier("messageDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}
	
	@Autowired
	private BuyerBiddingServiceI buyerbiddinService;
	@Autowired
	private SellerBiddingServiceI sellerBiddingService;
	@Autowired
	private AdminProductServiceI adminProductService;
	@Autowired
	private UsersServiceI userService;
	
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public MessageDTO findByCode(String code, UserContext userContext) throws Exception {
		SearchCriteria sc = new SearchCriteria(MessageDTO.class);
		sc.setAttribute("=code", code);
		List<MessageDTO> messageDTOs = find(sc,userContext);
		MessageDTO dto = null;
		if (messageDTOs.size() == 1) {
			dto = messageDTOs.get(0);
		}
		return dto;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	 public String getSellerCount() throws Exception{
	  String sql = "SELECT COUNT(*) FROM SELLER_BID WHERE STATUS='ACTIVE' ";
	  List sellerCountList =sellerBiddingService.findBySql(sql, null);
	  return sellerCountList.get(0).toString();
	 }
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	 public String getBuyerCountList() throws Exception{
	  String sql = "SELECT COUNT(*) FROM BUYER_BID WHERE STATUS='ABOUT TO OPEN' || 'ACTIVE'";
	  List buyerCountList =buyerbiddinService.findBySql(sql, null);
	 
	  return buyerCountList.get(0).toString();
	 }
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	 public String getProductCount() throws Exception{
	  String sql = "SELECT COUNT(*) FROM ADMIN_PRODUCT";
	  List adminProductList =adminProductService.findBySql(sql, null);
	  return adminProductList.get(0).toString();
	 }
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	 public String getUserCount() throws Exception{
	  String sql = "SELECT COUNT(*) FROM `USER`";
	  List adminProductList =userService.findBySql(sql, null);
	  return adminProductList.get(0).toString();
	 }
/*
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public MessageDTO findByCode(String code, UserContext ctx) {
		System.out.println("Message Service Impl find by Code invoked ");
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(MessageDTO.class);
		sc.setAttribute("=code", code);
		List l = null;
		try {
			l = find(sc, ctx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(l);
		if (l.size() > 0) {
			return (MessageDTO) l.get(0);

		} 
			return findByCode(code, ctx);
	}*/
	
	
	
}
