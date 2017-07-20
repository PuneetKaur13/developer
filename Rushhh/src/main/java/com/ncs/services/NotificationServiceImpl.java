package com.ncs.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.dao.NotificationDAOI;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.UserDTO;
import com.nenosystems.common.dao.BaseDAOI;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceImpl;
import com.nenosystems.common.util.DataUtil;

@Service("notificationService")
public class NotificationServiceImpl extends BaseServiceImpl implements NotificationServiceI {
	@Override
	@Autowired
	@Qualifier("notificationDAO")
	public void setDao(BaseDAOI dao) {
		this.dao = dao;
	}

	@Autowired
	private UsersServiceI userService;

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private BuyerBiddingServiceI biddingServiceI;
	
	@Autowired
	private NotificationDAOI notificationDAO;
	
	@Autowired
	private BuyerBiddingServiceI notificationService;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	 public String getCount() throws Exception{
	  String sql = "SELECT COUNT(DELETED) FROM NOTIFICATION ";
	  List getCount =notificationService.findBySql(sql, null);
	  return getCount.get(0).toString();
	 }


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List find(SearchCriteria searchCriteria, UserContext userContext) {
		List<NotificationDTO> notificationList = dao.find(searchCriteria, userContext);
		for (NotificationDTO notificationDTO : notificationList) {
			try {
				if (notificationDTO.getDeleted() != null && notificationDTO.getDeleted() == 0) {
					notificationDTO.setDeleted(1);
					dao.update(notificationDTO, userContext);
				
				}
			} catch (Exception e) {
			}
		}
		return notificationList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List findCount(SearchCriteria searchCriteria, UserContext userContext) {
		List<NotificationDTO> notificationList = dao.find(searchCriteria, userContext);
		System.out.println("find Count call");
		return notificationList;
	}
	
	
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List findCount(SearchCriteria searchCriteria, UserContext userContext) {
		List<NotificationDTO> notificationList = dao.find(searchCriteria, userContext);
		return notificationList;
	}*/

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void merge(NotificationDTO dto, UserContext userContext) throws Exception {
		notificationDAO.merge(dto, userContext);
	}
	
	
	
	private void notification(String code, HashMap<String, String> map, UserContext ctx) throws Exception {
		System.out.println("new bid called");
		MessageDTO mdto = null;
		mdto = (MessageDTO) messageService.findByCode(code, ctx);
		try {
			List l = userService.find(ctx);
			Iterator<UserDTO> itr = l.iterator();

			UserDTO udto = null;
			String from = "SYSTEM";
			String to = null;
			Date date = new Date();
			String subject = mdto.getTitle();
			String message = mdto.getMessage();
			Iterator<String> it = map.keySet().iterator();
			String key;
			String value;
			while (it.hasNext()) {
				key = it.next();
				value = map.get(key);
				message = message.replace(key, value);
			}

			NotificationDTO ndto = null;
			while (itr.hasNext()) {
				udto = itr.next();
				ndto = new NotificationDTO();
				to = udto.getLoginId();
				ndto.setTo(to);
				ndto.setCreatedDate(new Timestamp((date.getTime())));
				ndto.setMessage(message);
				ndto.setFrom(from);
				ndto.setSubject(subject);
				add(ndto, ctx);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void newBidPosted(HashMap<String, String> map, UserContext ctx) throws Exception {
		notification("B01", map, ctx);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void newBidPosted(BuyerBiddingDTO dto, UserContext ctx) throws Exception {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("<city>", dto.getCityName());
		params.put("<quantity>", dto.getQuantity().toString());
		params.put("<product>", dto.getProductName());
		notification("B01", params, ctx);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void newOfferPosted(HashMap<String, String> map, UserContext ctx) throws Exception {
		notification("B02", map, ctx);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void newOfferPosted(SellerBiddingDTO dto, UserContext ctx) throws Exception {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("$city$", dto.getCityName());
		params.put("$quantity$", dto.getQuantity().toString());
		params.put("$product$", dto.getProductName());
		System.out.println("new bid called");
		notification("B02", params, ctx);
	}

}
