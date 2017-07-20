package com.ncs.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CounterOfferDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerQuotationDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CounterOfferForm;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.BuyerQuotationI;
import com.ncs.services.MakeQuotationServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.ncs.services.SellerQuotationI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/CounterOffer")
public class CounterOfferCtl extends BaseCtl<CounterOfferForm> {

	private static Logger log = Logger.getLogger(CounterOfferCtl.class);

	@Override
	@Autowired
	@Qualifier("counterOfferService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private BuyerQuotationI buyerQuotation;

	@Autowired
	private SellerQuotationI sellerQuotation;

	@Autowired
	private BuyerBiddingServiceI BuyerBiddingServiceI;
	@Autowired
	private MakeQuotationServiceI makeQuotationService;
	

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private NotificationServiceI notificationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody CounterOfferForm form, HttpSession session) {
		CounterOfferDTO dto = (CounterOfferDTO) form.makeDto();

		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			ctx = getUserContext(session);
			UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
			BuyerQuotationDTO buyerQuotationDTO = (BuyerQuotationDTO) buyerQuotation.findByPK(dto.getQuotationId(),
					ctx);
			if (dto.getType().equals("BUY")) {
			
				
				buyerQuotationDTO.setIsCounter(true);
				dto.setBidId(buyerQuotationDTO.getBidId());
				buyerQuotationDTO.setCounterAmount(dto.getCounterAmount());
				buyerQuotationDTO.setCounterQuantity(dto.getCounterQuantity());
				buyerQuotationDTO.setOfferByBuyer(userDTO.getFirstName() + " " + userDTO.getLastName());
				buyerQuotationDTO.setCounterDate(new Timestamp(new Date().getTime()));
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				dto.setCreatedBy(ctx.getCreatedBy());
				buyerQuotation.update(buyerQuotationDTO, ctx);
				
			}

			if (dto.getType().equals("SELL")) {
				SellerQuotationDTO sellerQuotationDTO = (SellerQuotationDTO) sellerQuotation
						.findByPK(dto.getQuotationId(), ctx);
				sellerQuotationDTO.setIsCounter(true);
				sellerQuotation.update(sellerQuotationDTO, ctx);
			}
		
			MessageDTO messageDTO3 = messageService.findByCode("CO01", ctx);
			if (messageDTO3 != null) {
				String message = messageDTO3.getMessage();
				message = message.replace("<user>", dto.getCreatedBy());
				message = message.replace("<bidRef>", buyerQuotationDTO.getBidRefrenceNo());
				message = message.replace("<quantity>", buyerQuotationDTO.getCounterQuantity().toString());
				message = message.replace("<unit>", dto.getUnit());
				message = message.replace("<user1>", buyerQuotationDTO.getCreatedBy());
				message = message.replace("<site>", "www.frozenB2B.in");
				NotificationDTO receiverNotification = new NotificationDTO();
				receiverNotification.setSubject(messageDTO3.getTitle());
				receiverNotification.setFrom("system");
				receiverNotification.setMessage(message);
				receiverNotification.setTo(dto.getCreatedBy());
				receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
				receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
				notificationService.add(receiverNotification, ctx);
			}
			MessageDTO messageDTO = messageService.findByCode("CO02", ctx);
			if (messageDTO != null) {
				String message = messageDTO.getMessage();
				message = message.replace("<user>", buyerQuotationDTO.getCreatedBy());
				message = message.replace("<bidRef>", buyerQuotationDTO.getBidRefrenceNo());
				message = message.replace("<quantity>", buyerQuotationDTO.getCounterQuantity().toString());
				message = message.replace("<unit>", dto.getUnit());
				message = message.replace("<user1>", dto.getCreatedBy());
				message = message.replace("<site>", "www.frozenB2B.in");
				NotificationDTO receiverNotification = new NotificationDTO();
				receiverNotification.setSubject(messageDTO.getTitle());
				receiverNotification.setFrom("system");
				receiverNotification.setMessage(message);
				receiverNotification.setTo(buyerQuotationDTO.getCreatedBy());
				receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
				receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
				notificationService.add(receiverNotification, ctx);
			}
			
			
			service.add(dto, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Counter Offer has been sent successfully.");
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Quotation is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}


}