package com.ncs.action;

import java.math.BigDecimal;
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
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.SellerQuotationDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.BuyerQuotationForm;
import com.ncs.form.SellerBiddingForm;
import com.ncs.form.SellerQuotationForm;
import com.ncs.services.BuyerQuotationI;
import com.ncs.services.SellerBiddingServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/SellerQuotation")
public class SellerQuotationCtl extends BaseCtl<SellerQuotationForm> {

	@Override
	@Autowired
	@Qualifier("sellerquotationService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private SellerBiddingServiceI biddingService;
	@Autowired
	private BuyerQuotationI buyerQuotation;



	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData search(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerQuotationDTO.class);
		sc.setAttribute("=buyerId", userDTO.getId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/getHistory/{bidId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getHistory(@PathVariable Long bidId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerQuotationDTO.class);
		sc.setAttribute("=bidId", bidId);
		sc.setAttribute("=createdBy", userDTO.getCreatedBy());

		List list = buyerQuotation.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewCounter/{quotationId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewCounter(@PathVariable Long quotationId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CounterOfferDTO.class);
		sc.setAttribute("=quotationId", quotationId);
		sc.setAttribute("=type", "BUY");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewCounterHistory/{bidId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewCounterHistory(@PathVariable Long bidId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();

		List list = service.findBySql(
				"SELECT QUOTATION_AMOUNT,QUANTITY,UNIT,OFFER_BY,CREATED_DATE FROM BUYER_QUOTATION WHERE BID_ID= "
						+ bidId + " AND BUYER_ID =" + userDTO.getId()
						+ " UNION ALL SELECT QUOTATION_AMOUNT,QUANTITY,UNIT,OFFER_BY,CREATED_DATE FROM COUNTER_OFFER WHERE BID_ID="
						+ bidId + " AND BUYER_ID= " + userDTO.getId(),
				ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);

		List<CounterOfferDTO> dtoList = new ArrayList<CounterOfferDTO>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] data = (Object[]) it.next();
			CounterOfferDTO dto = new CounterOfferDTO();
			dto.setQuotationAmount((Double) data[0]);
			dto.setQuantity((Double) data[1]);
			dto.setUnit(data[2].toString());
			dto.setOfferBy(data[3].toString());
			dto.setCreatedDate(Timestamp.valueOf(data[4].toString()));
			dtoList.add(dto);
		}
		ncsResponseData.setList(dtoList);
		return ncsResponseData;

	}

	@RequestMapping(value = "/viewVisitor/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewVisitor(@PathVariable Long productId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerQuotationDTO.class);
		sc.setAttribute("=productId", productId);
		List list = service.find(sc, ctx);
		System.out.println(list);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewQoutation/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewQoutation(@PathVariable Long productId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		List list = service.findBySql(
				"SELECT MAX(s.ID) ID,s.COMPANY_ID,s.COMPANY_NAME,(SELECT m.QUANTITY FROM SELLER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.SELLER_ID=s.SELLER_ID ORDER BY m.ID DESC LIMIT 0,1) QUANTITY,s.IS_ACTIVE,s.PRODUCT_ID, "
						+ "s.PRODUCT_NAME,(SELECT m.QUOTATION_AMOUNT FROM SELLER_QUOTATION m WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.SELLER_ID=s.SELLER_ID ORDER BY m.ID DESC LIMIT 0,1) QUOTATION_AMOUNT, "
						+ "s.SELLER_COMPANY_ID,s.SELLER_COMPANY_NAME,s.SELLER_ID,s.SELLER_NAME,(SELECT m.STATUS FROM SELLER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.SELLER_ID=s.SELLER_ID ORDER BY m.ID DESC LIMIT 0,1) STATUS,(SELECT m.UNIT FROM SELLER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.SELLER_ID=s.SELLER_ID ORDER BY m.ID DESC LIMIT 0,1) UNIT,(SELECT m.TIMESTAMP FROM SELLER_QUOTATION m "
						+ "WHERE m.PRODUCT_ID=s.PRODUCT_ID AND m.SELLER_ID=s.SELLER_ID ORDER BY m.ID DESC LIMIT 0,1) TIMESTAMP FROM SELLER_QUOTATION s WHERE s.PRODUCT_ID="
						+ productId + " GROUP BY s.COMPANY_ID ORDER BY QUOTATION_AMOUNT DESC",
				ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);

		List<SellerQuotationDTO> dtoList = new ArrayList<SellerQuotationDTO>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] data = (Object[]) it.next();
			SellerQuotationDTO dto = new SellerQuotationDTO();
			dto.setId(DataUtil.getLongValue(data[0]));
			dto.setCompanyId(DataUtil.getLongValue(data[1]));
			dto.setCompanyName(data[2].toString());
			dto.setQuantity((Double) data[3]);
			dto.setUnit(data[13].toString());
			dto.setActive(Boolean.parseBoolean(data[4].toString()));
			dto.setProductId(DataUtil.getLongValue(data[5]));
			dto.setProductName(data[6].toString());
			dto.setQuotationAmount(((BigInteger) data[7]).doubleValue());
			dto.setQuotationAmount((Double) data[7]);
			dto.setSellerCompanyId(DataUtil.getLongValue(data[8]));
			dto.setSellerCompanyName(data[9].toString());
			dto.setSellerId(DataUtil.getLongValue(data[10]));
			dto.setSellerName(data[11].toString());
			dto.setStatus(data[12].toString());
			dto.setTimestamp(Timestamp.valueOf(data[14].toString()));
			dtoList.add(dto);
		}

		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/acceptBid", method = RequestMethod.POST)
	public NcsResponseData acceptBid(@RequestBody SellerBiddingForm form, HttpSession session) {
		SellerBiddingDTO dto = (SellerBiddingDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(SellerQuotationDTO.class);
			sc.setAttribute("=productId", dto.getProductId());
			sc.setAttribute("=sellerCompanyId", dto.getCompanyId());
			List<SellerQuotationDTO> list = service.find(sc, ctx);

			for (SellerQuotationDTO sellerQuotationDTO : list) {
				sellerQuotationDTO.setActive(false);
				sellerQuotationDTO.setStatus("LOST");
				service.update(sellerQuotationDTO, ctx);
			}
			SellerQuotationDTO dbDTO = (SellerQuotationDTO) service.findByPK(dto.getId(), ctx);
			dbDTO.setStatus("WON");

			service.update(dbDTO, ctx);

			sc = new SearchCriteria();
			sc.setDto(SellerBiddingDTO.class);
			sc.setAttribute("=productId", dto.getProductId());
			sc.setAttribute("=companyId", dto.getCompanyId());
			List<SellerBiddingDTO> biddingList = biddingService.find(sc, ctx);
			ctx = getUserContext(session);
			UserDTO userDTO = (UserDTO) ctx.getBaseDTO();

			for (SellerBiddingDTO sellerBiddingDTO : biddingList) {
				sellerBiddingDTO.setStatus("CLOSED");
				sellerBiddingDTO.setSellerCompanyId(dto.getSellerCompanyId());
				sellerBiddingDTO.setSellerCompanyName(dto.getSellerCompanyName());
				sellerBiddingDTO.setSellerId(dto.getSellerId());
				sellerBiddingDTO.setSellerName(dto.getSellerName());
				sellerBiddingDTO.setQuotationAmount(dto.getQuotationAmount());
				// sellerBiddingDTO.setDescription(dto.getDescription());
				sellerBiddingDTO.setQuantity(dto.getQuantity());
				sellerBiddingDTO.setDealDate(new Timestamp(new Date().getTime()));
				biddingService.update(sellerBiddingDTO, ctx);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Bid has been closed successfully.");
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			ncsResponseData.setMessage("Quotation is already exist.");
		} catch (Exception e) {
			e.printStackTrace();
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody SellerQuotationForm form, HttpSession session) {
		SellerQuotationDTO dto = (SellerQuotationDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			ctx = getUserContext(session);

			UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(CompanyDTO.class);
			sc.setAttribute("=userId", userDTO.getId());

			List list = service.find(sc, ctx);
			CompanyDTO companyDTO = new CompanyDTO();
			if (list != null && list.size() > 0) {
				companyDTO = (CompanyDTO) list.get(0);
			}
			System.out.println("Seller Quotation CTl Invoked");
			dto.setSellerId(userDTO.getId());
			dto.setSellerName(userDTO.getFirstName() + " " + userDTO.getLastName());
			dto.setCompanyId(companyDTO.getId());
			dto.setCompanyName(companyDTO.getCompanyName());
			dto.setTimestamp(new Timestamp(new Date().getTime()));
			dto.setCreatedBy(ctx.getCreatedBy());
			dto.setModifiedBy(ctx.getModifiedBy());
			dto.setActive(true);
			service.add(dto, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been added successfully.");
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Quotation is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

}
