package com.ncs.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.SystemSettingDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AdminProductForm;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.CompanyForm;
import com.ncs.form.SellerBiddingForm;
import com.ncs.form.searchForm;
import com.ncs.services.AdminProductPackagingServiceI;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.CityServiceI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.ncs.services.SellerBiddingServiceI;
import com.ncs.services.StateServiceI;
import com.ncs.services.SystemSettingServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/SellerBidding")
public class SellerBiddingCtl extends BaseCtl<SellerBiddingForm> {
	private static Logger log = Logger.getLogger(SellerBiddingCtl.class);

	@Override
	@Autowired
	@Qualifier("sellerbiddingService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private AdminProductServiceI adminProductService;
	@Autowired
	private BuyerBiddingServiceI buyerBiddingService;
	@Autowired
	private SystemSettingServiceI systemSettingService;


	@Autowired
	private CompanyServiceI companyService;

	@Autowired
	private SellerBiddingServiceI sellerBiddingService;

	@Autowired
	private StateServiceI stateService;

	@Autowired
	private CityServiceI cityService;
	@Autowired
	private AdminProductPackagingServiceI adminProductPackagingService;
	

	@Autowired
	private NotificationServiceI notificationServiceI;
	@Autowired
	private MessageServiceI messageService;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stateList", stateService.find(ctx));
		map.put("cityList", cityService.find(ctx));
		map.put("productList", adminProductService.find(ctx));
		map.put("packagingList", adminProductPackagingService.find(ctx));
		map.put("companyList", companyService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(SellerBiddingForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
		}
		if (!DataValidator.isNull(form.getOfferRefrenceNo())) {
			sc.setAttribute("offerRefrenceNo", form.getOfferRefrenceNo());
		}
		if (!DataValidator.isNull(form.getProductName())) {
			sc.setAttribute("productName", form.getProductName());
		}
		if (!DataValidator.isNull(form.getPackaging())) {
			sc.setAttribute("packaging", form.getPackaging());
		}
		if (!DataValidator.isNull(form.getStatus())) {
			sc.setAttribute("status", form.getStatus());
		}
		if (!DataValidator.isNull(form.getUnit())) {
			sc.setAttribute("unit", form.getUnit());
		}
		if (!DataValidator.isNull(form.getQuantity())) {
			sc.setAttribute("quantity", form.getQuantity());
		}
		if (!DataValidator.isNull(form.getCompanyName())) {
			sc.setAttribute("companyName", form.getCompanyName());
		}
		if (!DataValidator.isNull(form.getStartDate())) {
			sc.setAttribute(">=startDate", form.getStartDate());
		}
		if (!DataValidator.isNull(form.getEnddate())) {
			sc.setAttribute("<=enddate", form.getEnddate());
		}
		UserDTO dto = (UserDTO) ctx.getBaseDTO();
		if (!DataValidator.isNull(form!=null)) {
		if (dto.getRoleId() != 1L) {
			sc.setAttribute("createdBy", dto.getCreatedBy());
			System.out.println("Inside Loop");

		} else if (dto.getRoleId() == 1L) {
			if (dto.getRoleId() == 1L) {
				sc.setAttribute("-createdBy", dto.getCreatedBy());

			}
		}
		}
		return sc;
	};

	@RequestMapping(value = "/getSellerInfo/{type}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getSellerInfo(@PathVariable("type") String type,
			@RequestBody(required = false) SellerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		// sc.setAttribute("=type", type);
		if (form != null) {
			SellerBiddingDTO dto = (SellerBiddingDTO) form.makeDto();
			if (dto.getProductId() != null && dto.getProductId() > 0) {
				sc.setAttribute("=productId", dto.getProductId());
				AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductService.findByPK(dto.getProductId(),
						ctx);
				session.setAttribute("sessionProduct", adminProductDTO);
			}
			if (dto.getStatus() != null && dto.getStatus() != "") {
				sc.setAttribute("=status", dto.getStatus());
			} else {
				sc.setAttribute("=status", "ACTIVE");
			}
		} else {
			AdminProductDTO adminProductDTO = (AdminProductDTO) session.getAttribute("sessionProduct");
			sc.setAttribute("=productId", adminProductDTO.getId());
			sc.setAttribute("=status", "ACTIVE");
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByBox", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByBox(@RequestBody SellerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("=stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("=cityName", form.getCityName());
		}
		if (!DataValidator.isNull(form.getProductName())) {
			sc.setAttribute("=productName", form.getProductName());
		}
		if (!DataValidator.isNull(form.getStatus())) {
			sc.setAttribute("=status", form.getStatus());
		}
		if (!DataValidator.isNull(form.getStartDate())) {
			sc.setAttribute("=startDate", form.getStartDate());
		}
		if (!DataValidator.isNull(form.getEnddate())) {
			sc.setAttribute("=endDate", form.getEnddate());
		}
		if (!DataValidator.isNull(form.getBidRefrenceNo())) {
			sc.setAttribute("=offerRefrenceNo", form.getOfferRefrenceNo());
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/getSellerTab/{type}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getSellerTab(@PathVariable("type") String type,
			@RequestBody(required = false) SellerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("-createdBy", userDTO.getLoginId());
		sc.setAttribute("=type", type);
		if (form != null) {
			SellerBiddingDTO dto = (SellerBiddingDTO) form.makeDto();
			if (dto.getProductId() != null && dto.getProductId() > 0) {
				sc.setAttribute("=productId", dto.getProductId());
				AdminProductDTO adminProductDTO = (AdminProductDTO) adminProductService.findByPK(dto.getProductId(),
						ctx);
				session.setAttribute("sessionProduct", adminProductDTO);
			}
			if (dto.getStatus() != null && dto.getStatus() != "") {
				sc.setAttribute("=status", dto.getStatus());
			} else {
				sc.setAttribute("=status", "ACTIVE");
			}
		} else {
			AdminProductDTO adminProductDTO = (AdminProductDTO) session.getAttribute("sessionProduct");
			sc.setAttribute("=productId", adminProductDTO.getId());
			sc.setAttribute("=status", "ACTIVE");
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchforMap", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchforMap(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("-status", "CLOSED");
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
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchUserSellerReport", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchUserSellerReport(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewInformation/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewInformation(@PathVariable Long id, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("=id", id);
		// sc.setAttribute("=packagingId",packagingId);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;

	}

	@RequestMapping(value = "/searchByCity/{city}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByCity(@PathVariable("city") String city, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("=cityName", city);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/sellerDeals", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData sellerDeals(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerQuotationDTO.class);
		// sc.setAttribute("=createdBy", userDTO.getLoginId());
		sc.setAttribute("=groupId", userDTO.getGroupId());
		sc.setAttribute("=status", "WON");
		List dbList = service.find(sc, ctx);

		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(dbList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchOfferDashBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchOfferDashBoard(SellerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("=status","ACTIVE");
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(form);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/makeQuotation", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData makeQuotation(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("-createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/getStateChart/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getCount(@PathVariable Long productId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		List dtoList = new ArrayList();
		List stateList = service.findBySql("SELECT STATE_ID,STATE_NAME FROM SELLER_BID WHERE PRODUCT_ID=" + productId+" AND STATUS='ACTIVE'"
				+ " UNION SELECT STATE_ID,STATE_NAME FROM SELLER_BID WHERE PRODUCT_ID=" + productId+" AND STATUS='ACTIVE'", ctx);

		Iterator iterator = stateList.iterator();
		while (iterator.hasNext()) {
			Object[] states = (Object[]) iterator.next();
			Long stateId = DataUtil.getLongValue(states[0]);
			String sql = "SELECT  " + stateId + " AS STATE_ID,(SELECT STATE_NAME FROM STATE WHERE ID=" + stateId
					+ ") STATE_NAME" + ",(SELECT COUNT(ID) FROM SELLER_BID WHERE PRODUCT_ID=" + productId
					+ " AND STATE_ID=" + stateId + ") TOTAL_SELLER, "
					+ "(SELECT SUM(QUANTITY) FROM SELLER_BID WHERE PRODUCT_ID=" + productId + " AND STATE_ID=" + stateId
					+ ") SELLER_QUANTITY, " + "(SELECT MAX(EXPECTED_AMOUNT) FROM SELLER_BID WHERE PRODUCT_ID="
					+ productId + " AND STATE_ID=" + stateId
					+ ") MAXIMUM, (SELECT MIN(EXPECTED_AMOUNT) FROM SELLER_BID WHERE  PRODUCT_ID= " + productId
					+ " AND STATE_ID= " + stateId + ") MINIMUM  ";
			List dataList = service.findBySql(sql, ctx);
			dtoList.addAll(dataList);
		}
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/getAdminStatiStics", method = { RequestMethod.GET, RequestMethod.POST })
	public List getAdminStatiStics(HttpSession session) throws Exception {
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		List statiStics = service.findBySql(
				"SELECT BID_REFRENCE,COMPANY_NAME,PRODUCT_NAME,PACKAGING,STATE_NAME,CITY_NAME,QUANTITY,`STATUS`,UNIT,START_DATE,END_DATE FROM BUYER_BID UNION SELECT OFFER_REFRENCE_NO,COMPANY_NAME,PRODUCT_NAME,PACKAGING,STATE_NAME,CITY_NAME,QUANTITY,`STATUS`,UNIT,START_DATE,END_DATE FROM SELLER_BID",
				ctx);

		Iterator iterator = statiStics.iterator();
		while (iterator.hasNext()) {
			Object[] statiSticsDto = (Object[]) iterator.next();
		}
		return statiStics;
	}

	@RequestMapping(value = "/getCityChart/{productId}/{stateId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getCityCount(@PathVariable Long productId, @PathVariable Long stateId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		List dtoList = new ArrayList();
		List stateList = service.findBySql("SELECT CITY_ID,CITY_NAME FROM BUYER_BID WHERE PRODUCT_ID=" + productId
				+ " AND STATE_ID=" + stateId + " UNION SELECT CITY_ID,CITY_NAME FROM SELLER_BID WHERE PRODUCT_ID="
				+ productId + " AND STATE_ID=" + stateId, ctx);
		Iterator iterator = stateList.iterator();
		while (iterator.hasNext()) {
			Object[] cities = (Object[]) iterator.next();
			Long cityId = DataUtil.getLongValue(cities[0]);
			String sql = "SELECT (SELECT PRODUCT_NAME FROM ADMIN_PRODUCT WHERE ID=" + productId + ") PRODUCT_NAME,"
					+ "(SELECT STATE_NAME FROM CITY WHERE ID=" + cityId + ") STATE_NAME,"
					+ "(SELECT CITY_NAME FROM CITY WHERE ID=" + cityId + ") CITY_NAME,"
					+ "(SELECT COUNT(ID) FROM SELLER_BID WHERE PRODUCT_ID=" + productId + " AND CITY_ID=" + cityId
					+ ") TOTAL_SELLER, " + "(SELECT SUM(QUANTITY) FROM SELLER_BID WHERE PRODUCT_Id=" + productId
					+ " AND CITY_ID=" + cityId + ") SELLER_QUANTITY, "
					+ "(SELECT COUNT(ID) FROM BUYER_BID WHERE PRODUCT_ID=" + productId + " AND CITY_ID=" + cityId
					+ ") TOTAL_BUYER, " + "(SELECT SUM(QUANTITY) FROM BUYER_BID WHERE PRODUCT_ID=" + productId
					+ " AND CITY_ID=" + cityId + ") BUYER_QUANTITY,"
					+ "(SELECT SUM(EXPECTED_AMOUNT) FROM SELLER_BID WHERE PRODUCT_ID=" + productId + " AND CITY_ID="
					+ cityId + ") TOTAL_AMOUNT_SELLERS";
			List dataList = service.findBySql(sql, ctx);
			dtoList.addAll(dataList);
		}
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody SellerBiddingForm form, HttpSession session) {
		SellerBiddingDTO dto = (SellerBiddingDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		List<Object[]> uniqueAttributes = new ArrayList<Object[]>();
		uniqueAttributes.add(new Object[] { "packagingId", dto.getPackagingId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "createdBy", userDTO.getLoginId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "stateId", dto.getStateId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "cityId", dto.getCityId() });
		dto.setUniqueAttributes(uniqueAttributes);
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(CompanyDTO.class);
			sc.setAttribute("=id", userDTO.getGroupId());
			List list = service.find(sc, ctx);

			CompanyDTO companyDTO = new CompanyDTO();
			if (list != null && list.size() > 0) {
				companyDTO = (CompanyDTO) list.get(0);
			}
			sc = new SearchCriteria();
			sc.setDto(SystemSettingDTO.class);
			List list2 = systemSettingService.find(sc, ctx);
			SystemSettingDTO systemSettingDTO = new SystemSettingDTO();
			if (list2 != null && list2.size() > 0) {
				systemSettingDTO = (SystemSettingDTO) list2.get(0);
			}
			
			if (dto.getQuantity() >= systemSettingDTO.getQuantity()) {
				dto.setCompanyId(companyDTO.getId());
				dto.setCompanyName(companyDTO.getCompanyName());
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				service.add(dto, ctx);
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Record has been added successfully.");
			} else {
				ncsResponseData.setSuccess(false);
				ncsResponseData
						.setMessage("Quantity must be greater than MOQ Quantity " + systemSettingDTO.getQuantity());

			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
			System.out.println(ncsResponseData.getMessage() + " me 2");
		}
		return ncsResponseData;
	}

}
