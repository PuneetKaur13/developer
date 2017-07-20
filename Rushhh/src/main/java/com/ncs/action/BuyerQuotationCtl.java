package com.ncs.action;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CounterOfferDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerQuotationDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.BuyerQuotationForm;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.BuyerQuotationI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MakeQuotationServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;

@RestController
@RequestMapping(value = "rest/BuyerQuotation")
public class BuyerQuotationCtl extends BaseCtl<BuyerQuotationForm> {

	@Override
	@Autowired
	@Qualifier("buyerquotationService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private MakeQuotationServiceI makeQuotationServiceI;

	@Autowired
	private BuyerBiddingServiceI biddingService;

	@Autowired
	private MakeQuotationServiceI makeQuotationService;

	@Autowired
	private BuyerQuotationI buyerQuotationService;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private CompanyServiceI companyService;

	public SearchCriteria getSearchCriteria(BuyerQuotationForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerQuotationDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (ctx != null && ctx.getBaseDTO() != null) {
			UserDTO dto = (UserDTO) ctx.getBaseDTO();
			System.out.println("insidei i");
			sc.setAttribute("buyerId", dto.getId());
		}

		return sc;
	};

	@RequestMapping(value = "/getHistory/{productId}/{buyerId}/{packagingId}/{stateId}/{cityId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getHistory(@PathVariable Long productId, @PathVariable Long buyerId,
			@PathVariable Long packagingId, @PathVariable Long stateId, @PathVariable Long cityId, HttpSession session)
					throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerQuotationDTO.class);
		sc.setAttribute("=productId", productId);
		sc.setAttribute("=buyerId", buyerId);
		sc.setAttribute("=packagingId", packagingId);
		sc.setAttribute("=stateId", stateId);
		sc.setAttribute("=cityId", cityId);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData search(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerQuotationDTO.class);
		sc.setAttribute("=sellerId", userDTO.getId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewUserQoutation/{productId}/{cityId}/{stateId}/{packagingId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewUserQoutation(@PathVariable Long productId, @PathVariable Long cityId,
			@PathVariable Long stateId, @PathVariable Long packagingId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		List list = service.findBySql(
				"SELECT MAX(s.ID) ID,s.COMPANY_ID,s.COMPANY_NAME,s.CITY_ID,STATE_ID,PACKAGING_ID,(SELECT m.RANK FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND "
						+ "m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID  ORDER BY m.ID DESC LIMIT 0,1) RANK,(SELECT m.QUANTITY FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID  ORDER BY m.ID DESC LIMIT 0,1) QUANTITY,(SELECT m.IS_ACTIVE FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID  ORDER BY m.ID DESC LIMIT 0,1) IS_ACTIVE,s.PRODUCT_ID, "
						+ "s.PRODUCT_NAME,(SELECT m.QUOTATION_AMOUNT FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) QUOTATION_AMOUNT, "
						+ "s.BUYER_COMPANY_ID,s.BUYER_COMPANY_NAME,s.BUYER_ID,s.BUYER_NAME,(SELECT m.STATUS FROM BUYER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) STATUS,(SELECT m.UNIT FROM BUYER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) UNIT,(SELECT m.TIMESTAMP FROM BUYER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) TIMESTAMP FROM BUYER_QUOTATION s WHERE s.PRODUCT_ID="
						+ productId + " AND s.CITY_ID= " + cityId + " AND s.STATE_ID= " + stateId
						+ " AND s.PACKAGING_ID= " + packagingId
						+ " GROUP BY s.COMPANY_ID ORDER BY QUOTATION_AMOUNT DESC",
				ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		List<BuyerQuotationDTO> dtoList = new ArrayList<BuyerQuotationDTO>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] data = (Object[]) it.next();
			BuyerQuotationDTO dto = new BuyerQuotationDTO();
			dto.setId(DataUtil.getLongValue(data[0]));
			dto.setCompanyId(DataUtil.getLongValue(data[1]));
			dto.setCompanyName(data[2].toString());
			dto.setCityId(DataUtil.getLongValue(data[3]));
			dto.setStateId(DataUtil.getLongValue(data[4]));
			dto.setPackagingId(DataUtil.getLongValue(data[5]));
			dto.setRank(((BigInteger) (data[6])).intValue());
			dto.setQuantity((Double) data[7]);
			boolean active = (Integer.parseInt(data[8].toString()) == 1) ? true : false;
			dto.setActive(active);
			dto.setProductId(DataUtil.getLongValue(data[9]));
			dto.setProductName(data[10].toString());
			dto.setQuotationAmount((Double) data[11]);
			dto.setBuyerCompanyId(DataUtil.getLongValue(data[12]));
			dto.setBuyerCompanyName(data[13].toString());
			dto.setBuyerId(DataUtil.getLongValue(data[14]));
			dto.setBuyerName(data[15].toString());
			dto.setStatus(data[16].toString());
			dto.setUnit(data[17].toString());
			dto.setTimestamp(Timestamp.valueOf(data[18].toString()));
			dtoList.add(dto);
		}
		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewQoutation/{productId}/{cityId}/{stateId}/{packagingId}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public NcsResponseData viewQoutation(@PathVariable Long productId, @PathVariable Long cityId,
			@PathVariable Long stateId, @PathVariable Long packagingId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		List list = service.findBySql(
				"SELECT MAX(s.ID) ID,s.COMPANY_ID,s.COMPANY_NAME,(SELECT m.RANK FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID  ORDER BY m.ID DESC LIMIT 0,1) RANK,(SELECT m.QUANTITY FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID  ORDER BY m.ID DESC LIMIT 0,1) QUANTITY,s.IS_ACTIVE,s.PRODUCT_ID, "
						+ "s.PRODUCT_NAME,(SELECT m.QUOTATION_AMOUNT FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) QUOTATION_AMOUNT, "
						+ "s.BUYER_COMPANY_ID,s.BUYER_COMPANY_NAME,s.BUYER_ID,s.BUYER_NAME,(SELECT m.STATUS FROM BUYER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) STATUS,(SELECT m.UNIT FROM BUYER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) UNIT,(SELECT m.TIMESTAMP FROM BUYER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1) TIMESTAMP,(SELECT COUNT(DISTINCT(CREATED_BY)) CT FROM BUYER_QUOTATION WHERE BID_ID=((SELECT m.BID_ID FROM BUYER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.BUYER_ID=s.BUYER_ID AND m.CITY_ID=s.CITY_ID AND m.STATE_ID=s.STATE_ID AND m.PACKAGING_ID=s.PACKAGING_ID ORDER BY m.ID DESC LIMIT 0,1))) TOTAL_USER FROM BUYER_QUOTATION s WHERE s.PRODUCT_ID="
						+ productId + " AND s.CITY_ID= " + cityId + " AND s.STATE_ID= " + stateId
						+ " AND s.PACKAGING_ID= " + packagingId + " AND GROUP_ID= " + userDTO.getGroupId()
						+ " GROUP BY s.COMPANY_ID ORDER BY QUOTATION_AMOUNT DESC",
				ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);

		List<BuyerQuotationDTO> dtoList = new ArrayList<BuyerQuotationDTO>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] data = (Object[]) it.next();
			BuyerQuotationDTO dto = new BuyerQuotationDTO();
			dto.setId(DataUtil.getLongValue(data[0]));
			dto.setCompanyId(DataUtil.getLongValue(data[1]));
			dto.setCompanyName(data[2].toString());
			dto.setQuantity((Double) data[4]);
			dto.setActive(Boolean.parseBoolean(data[5].toString()));
			// dto.setBidId(DataUtil.getLongValue(data[5]));
			dto.setProductId(DataUtil.getLongValue(data[6]));
			dto.setProductName(data[7].toString());
			dto.setQuotationAmount((Double) data[8]);
			dto.setBuyerCompanyId(DataUtil.getLongValue(data[9]));
			dto.setBuyerCompanyName(data[10].toString());
			dto.setBuyerId(DataUtil.getLongValue(data[11]));
			dto.setBuyerName(data[12].toString());
			dto.setStatus(data[13].toString());
			dto.setUnit(data[14].toString());
			dto.setTimestamp(Timestamp.valueOf(data[15].toString()));
			dto.setRank(((BigInteger) (data[3])).intValue());
			dto.setCounter(((BigInteger) (data[16])).intValue());

			System.out.println(data[16].getClass());
			System.out.println(data[16]);
			dtoList.add(dto);
		}

		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewRank/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewRank(@PathVariable Long productId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		List list = service
				.findBySql("SELECT BUYER_ID, BUYER_NAME,QUOTATION_AMOUNT FROM BUYER_QUOTATION P WHERE PRODUCT_ID= "
						+ productId + " AND BUYER_ID= " + userDTO.getId() + " ORDER BY QUOTATION_AMOUNT", ctx);

		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		List<BuyerQuotationDTO> dtoList = new ArrayList<BuyerQuotationDTO>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] data = (Object[]) it.next();
			BuyerQuotationDTO dto = new BuyerQuotationDTO();
			dto.setBuyerId(DataUtil.getLongValue(data[0]));
			dto.setBuyerName(data[1].toString());
			dto.setQuotationAmount((Double) data[2]);
			dtoList.add(dto);
		}
		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/acceptBid", method = RequestMethod.POST)
	public NcsResponseData acceptBid(@RequestBody BuyerBiddingForm form, HttpSession session) {
		BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		Double wonQty = 0.0;
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(BuyerQuotationDTO.class);
			sc.setAttribute("=productId", dto.getProductId());
			sc.setAttribute("=cityId", dto.getCityId());
			sc.setAttribute("=stateId", dto.getStateId());
			sc.setAttribute("=packagingId", dto.getPackagingId());
			sc.setAttribute("=status", "WON");

			List<BuyerQuotationDTO> list = service.find(sc, ctx);
			for (BuyerQuotationDTO buyerQuotationDTO : list) {
				buyerQuotationDTO.setActive(false);
				wonQty += buyerQuotationDTO.getQuantity();
			}
			sc = new SearchCriteria();
			sc.setDto(BuyerBiddingDTO.class);
			sc.setAttribute("=productId", dto.getProductId());
			sc.setAttribute("=cityId", dto.getCityId());
			sc.setAttribute("=stateId", dto.getStateId());
			sc.setAttribute("=packagingId", dto.getPackagingId());

			List<BuyerBiddingDTO> biddingList = biddingService.find(sc, ctx);

			BuyerQuotationDTO dbDTO = (BuyerQuotationDTO) service.findByPK(dto.getId(), ctx);
			dbDTO.setStatus("WON");
			dbDTO.setActive(false);
			for (BuyerBiddingDTO buyerBiddingDTO : biddingList) {
				if (buyerBiddingDTO.getQuantity() > dto.getQuantity()) {
					Double remainedQty = buyerBiddingDTO.getQuantity() - dto.getQuantity();
					buyerBiddingDTO.setWonQuantity(wonQty + dto.getQuantity());
					buyerBiddingDTO.setQuantity(remainedQty);
					buyerBiddingDTO.setStatus("ACTIVE");
					buyerBiddingDTO.setBuyerId(dto.getBuyerId());
					buyerBiddingDTO.setBuyerName(dto.getBuyerName());
					buyerBiddingDTO.setQuotationAmount(dto.getQuotationAmount());
					buyerBiddingDTO.setIsRemainQuantity(true);
					buyerBiddingDTO.setDealDate(new Timestamp(new Date().getTime()));

					MessageDTO messageDTO3 = messageService.findByCode("A01", ctx);
					if (messageDTO3 != null) {
						String message = messageDTO3.getMessage();
						message = message.replace("<user>", buyerBiddingDTO.getCreatedBy());
						message = message.replace("<bidRef>", buyerBiddingDTO.getBidRefrenceNo());
						message = message.replace("<quantity>", buyerBiddingDTO.getWonQuantity().toString());
						message = message.replace("<avlQuantity>", buyerBiddingDTO.getQuantity().toString());
						message = message.replace("<unit>", buyerBiddingDTO.getUnit());
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO3.getTitle());
						receiverNotification.setFrom("system");
						receiverNotification.setMessage(message);
						receiverNotification.setTo(buyerBiddingDTO.getCreatedBy());
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
					System.out.println(dbDTO.getCreatedBy());
					System.out.println(buyerBiddingDTO.getQuantity());
					

				MessageDTO messageDTO = messageService.findByCode("A02", ctx);
					if (messageDTO != null) {
						String message = messageDTO.getMessage();
						message = message.replace("<user>", dbDTO.getCreatedBy());
						message = message.replace("<bidRef>", buyerBiddingDTO.getBidRefrenceNo());
						message = message.replace("<quantity>", dbDTO.getQuantity().toString());
						message = message.replace("<avlQuantity>", buyerBiddingDTO.getQuantity().toString());
						message = message.replace("<unit>", buyerBiddingDTO.getUnit());
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO.getTitle());
						receiverNotification.setFrom("system");
						receiverNotification.setMessage(message);
						receiverNotification.setTo(dbDTO.getCreatedBy());
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
					biddingService.update(buyerBiddingDTO, ctx);
					service.update(dbDTO, ctx);
					ncsResponseData.setMessage("Bid has been accepted successfully.");

				} else {
					if (buyerBiddingDTO.getQuantity().equals(dto.getQuantity())) {
						buyerBiddingDTO.setStatus("CLOSED");
						buyerBiddingDTO.setBuyerCompanyId(dto.getBuyerCompanyId());
						buyerBiddingDTO.setBuyerCompanyName(dto.getBuyerCompanyName());
						buyerBiddingDTO.setBuyerId(dto.getBuyerId());
						buyerBiddingDTO.setBuyerName(dto.getBuyerName());
						buyerBiddingDTO.setQuantity(0.0);
						buyerBiddingDTO.setWonQuantity(wonQty + dto.getQuantity());
						buyerBiddingDTO.setDealDate(new Timestamp(new Date().getTime()));
						
						MessageDTO messageDTO = messageService.findByCode("A03", ctx);
						if (messageDTO != null) {
							String message = messageDTO.getMessage();
							message = message.replace("<user>", buyerBiddingDTO.getCreatedBy());
							message = message.replace("<bidRef>", buyerBiddingDTO.getBidRefrenceNo());
							message = message.replace("<quantity>", dbDTO.getQuantity().toString());
							message = message.replace("<avlQuantity>", buyerBiddingDTO.getQuantity().toString());
							message = message.replace("<unit>", buyerBiddingDTO.getUnit());
							NotificationDTO receiverNotification = new NotificationDTO();
							receiverNotification.setSubject(messageDTO.getTitle());
							receiverNotification.setFrom("system");
							receiverNotification.setMessage(message);
							receiverNotification.setTo(buyerBiddingDTO.getCreatedBy());
							receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
							receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
							notificationService.add(receiverNotification, ctx);
						}
						
						MessageDTO messageDTO1 = messageService.findByCode("A04", ctx);
						if (messageDTO1 != null) {
							String message = messageDTO1.getMessage();
							message = message.replace("<user>", buyerBiddingDTO.getCreatedBy());
							message = message.replace("<bidRef>", buyerBiddingDTO.getBidRefrenceNo());
							message = message.replace("<quantity1>", dbDTO.getQuantity().toString());
							message = message.replace("<unit>", buyerBiddingDTO.getUnit());
							message = message.replace("<user1>", dbDTO.getCreatedBy());
							NotificationDTO receiverNotification = new NotificationDTO();
							receiverNotification.setSubject(messageDTO1.getTitle());
							receiverNotification.setFrom("system");
							receiverNotification.setMessage(message);
							receiverNotification.setTo("frozenb2b@mabl.in");
							receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
							receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
							notificationService.add(receiverNotification, ctx);
						}
						
						
						MessageDTO messageDTO4 = messageService.findByCode("A05", ctx);
						if (messageDTO4 != null) {
							String message = messageDTO4.getMessage();
							message = message.replace("<user>", dbDTO.getCreatedBy());
							message = message.replace("<bidRef>", buyerBiddingDTO.getBidRefrenceNo());
							message = message.replace("<quantity>", dbDTO.getQuantity().toString());
							message = message.replace("<unit>", dbDTO.getUnit());
							message = message.replace("<user1>", buyerBiddingDTO.getCreatedBy());
							NotificationDTO receiverNotification = new NotificationDTO();
							receiverNotification.setSubject(messageDTO4.getTitle());
							receiverNotification.setFrom("system");
							receiverNotification.setMessage(message);
							receiverNotification.setTo(dbDTO.getCreatedBy());
							receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
							receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
							notificationService.add(receiverNotification, ctx);
						}
						
						
						biddingService.update(buyerBiddingDTO, ctx);
						service.update(dbDTO, ctx);
						System.out.println("AcceptBiddddddd3");

					} else {
						System.out.println("AcceptBiddddddd4");
						ncsResponseData.setSuccess(false);
						ncsResponseData.setMessage("Can't accept bid, Quantity is bigger than available quantity.");
						return ncsResponseData;
					}
				}
			}
			sc = new SearchCriteria();
			sc.setDto(MakeQuotationDTO.class);
			sc.setAttribute("=productId", dto.getProductId());
			sc.setAttribute("=cityId", dto.getCityId());
			sc.setAttribute("=stateId", dto.getStateId());
			sc.setAttribute("=packagingId", dto.getPackagingId());

			List<MakeQuotationDTO> makeList = makeQuotationService.find(sc, ctx);

			BuyerQuotationDTO dbDTO1 = (BuyerQuotationDTO) service.findByPK(dto.getId(), ctx);
			dbDTO.setStatus("WON");
			dbDTO.setActive(false);
			for (MakeQuotationDTO makeQuotationDTO : makeList) {
				if (makeQuotationDTO.getQuantity() > dto.getQuantity()) {
					Double remainedQty = makeQuotationDTO.getQuantity() - dto.getQuantity();
					makeQuotationDTO.setWonQuantity(wonQty + dto.getQuantity());
					makeQuotationDTO.setQuantity(remainedQty);
					makeQuotationDTO.setStatus("ACTIVE");
					makeQuotationDTO.setBuyerId(dto.getBuyerId());
					makeQuotationDTO.setBuyerName(dto.getBuyerName());
					makeQuotationDTO.setQuotationAmount(dto.getQuotationAmount());
					makeQuotationDTO.setIsRemainQuantity(true);
					makeQuotationDTO.setDealDate(new Timestamp(new Date().getTime()));
					makeQuotationService.update(makeQuotationDTO, ctx);
					service.update(dbDTO1, ctx);
					ncsResponseData.setMessage("Bid has been accepted successfully.");
				} else {
					if (makeQuotationDTO.getQuantity().equals(dto.getQuantity())) {
						makeQuotationDTO.setStatus("CLOSED");
						makeQuotationDTO.setBuyerCompanyId(dto.getBuyerCompanyId());
						makeQuotationDTO.setBuyerCompanyName(dto.getBuyerCompanyName());
						makeQuotationDTO.setBuyerId(dto.getBuyerId());
						makeQuotationDTO.setBuyerName(dto.getBuyerName());
						makeQuotationDTO.setQuantity(0.0);
						makeQuotationDTO.setWonQuantity(wonQty + dto.getQuantity());
						makeQuotationDTO.setDealDate(new Timestamp(new Date().getTime()));
						makeQuotationService.update(makeQuotationDTO, ctx);
						service.update(dbDTO1, ctx);
						System.out.println("AcceptBiddddddd2");
						ncsResponseData.setMessage("Bid has been accepted	 successfully.");
					}
				}
			}

			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Quotation is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());

		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody BuyerQuotationForm form, HttpSession session) {
		BuyerQuotationDTO dto = (BuyerQuotationDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		NcsResponseData ncsResponseData = new NcsResponseData();
		List<Object[]> uniqueAttributes = new ArrayList<Object[]>();
	/*	uniqueAttributes.add(new Object[] { "quotationAmount", dto.getQuotationAmount() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "quantity", dto.getQuantity() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "createdBy", userDTO.getLoginId() });*/
		dto.setUniqueAttributes(uniqueAttributes);
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(CompanyDTO.class);
			sc.setAttribute("=groudId", userDTO.getGroupId());
			List list = companyService.find(sc, ctx);
			CompanyDTO companyDTO = new CompanyDTO();
			if (list != null && list.size() > 0) {
				companyDTO = (CompanyDTO) list.get(0);
			}
			dto.setBuyerId(userDTO.getId());
			dto.setBuyerName(userDTO.getFirstName() + " " + userDTO.getLastName());
			dto.setCompanyId(userDTO.getGroupId());
			dto.setCompanyName(userDTO.getUserCompany());
			dto.setTimestamp(new Timestamp(new Date().getTime()));
			dto.setCreatedBy(ctx.getCreatedBy());
			dto.setModifiedBy(ctx.getModifiedBy());
			dto.setActive(true);
			dto.setOfferBy(userDTO.getFirstName() + " " + userDTO.getLastName());
			dto.setGroupIdString(userDTO.getGroupIdString());

			sc = new SearchCriteria();
			sc.setDto(BuyerBiddingDTO.class);
			List<BuyerBiddingDTO> list1 = biddingService.find(sc, ctx);
			BuyerBiddingDTO buyerBiddingDTO = new BuyerBiddingDTO();
			if (list1 != null && list1.size() > 0) {
				buyerBiddingDTO = (BuyerBiddingDTO) list1.get(0);
			}
			BuyerBiddingDTO bd = (BuyerBiddingDTO) biddingService.findByPK(dto.getBidId(), ctx);
			dto.setBidRefrenceNo(bd.getBidRefrenceNo());

			if (bd.getQuantity() >= dto.getQuantity()) {
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Your Offer SuccessFully Sent");
				service.add(dto, ctx);

			} else {
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(false);
				ncsResponseData.setMessage("Enter Quantity Must Be Less Than " + bd.getQuantity() + " " + bd.getUnit());
			}

			MessageDTO messageDTO = messageService.findByCode("Q02", ctx);
			if (messageDTO != null) {
				String message = messageDTO.getMessage();
				message = message.replace("<user>", userDTO.getCreatedBy());
				message = message.replace("<bidRef>", bd.getBidRefrenceNo());
				message = message.replace("<site>", "www.frozenB2B.in");
				NotificationDTO receiverNotification = new NotificationDTO();
				receiverNotification.setSubject(messageDTO.getTitle());
				receiverNotification.setFrom("system");
				receiverNotification.setMessage(message);
				receiverNotification.setTo(userDTO.getCreatedBy());
				receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
				receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
				notificationService.add(receiverNotification, ctx);
			}
			List list2 = service.findBySql("SELECT MAX(ID) ID FROM BUYER_QUOTATION WHERE BID_ID=" + dto.getBidId()
					+ " GROUP BY CREATED_BY ORDER BY MIN(QUOTATION_AMOUNT) ASC", ctx);
			Iterator iterator = list2.iterator();
			for (int i = 0; iterator.hasNext(); i++) {
				Long id = ((BigInteger) iterator.next()).longValue();
				BuyerQuotationDTO buyerQuotationDTO = (BuyerQuotationDTO) buyerQuotationService.findByPK(id, ctx);
				buyerQuotationDTO.setRank(i + 1);
				buyerQuotationService.update(buyerQuotationDTO, ctx);
			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage("Quotation is already exist.");
		} catch (Exception e) {
			e.printStackTrace();
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

}
