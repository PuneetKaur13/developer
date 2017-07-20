package com.ncs.action;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.MakeQuotationDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.ncs.dto.SellSupplierDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.SellerQuotationDTO;
import com.ncs.dto.SystemSettingDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AdminProductForm;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.MakeQuotationForm;
import com.ncs.form.PreferredSupplierForm;
import com.ncs.form.SellerBiddingForm;
import com.ncs.services.AdminProductPackagingServiceI;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.CityServiceI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.MakeQuotationServiceI;
import com.ncs.services.MessageServiceI;
import com.ncs.services.NotificationServiceI;
import com.ncs.services.PreferredSupplierServiceI;
import com.ncs.services.SellSupplierServiceI;
import com.ncs.services.SellerBiddingServiceI;
import com.ncs.services.SellerQuotationI;
import com.ncs.services.StateServiceI;
import com.ncs.services.SystemSettingServiceI;
import com.ncs.services.UsersServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.services.UserServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/BuyerBidding")
public class BuyerBiddingCtl extends BaseCtl<BuyerBiddingForm> {
	private static Logger log = Logger.getLogger(BuyerBiddingCtl.class);

	@Override
	@Autowired
	@Qualifier("buyerbiddingService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private AdminProductServiceI adminProductService;
	@Autowired
	private SystemSettingServiceI systemSettingService;

	@Autowired
	private BuyerBiddingServiceI buyerBiddingService;

	@Autowired
	private SellerQuotationI sellerQuotationService;

	@Autowired
	private NotificationServiceI notificationService;

	@Autowired
	private SellSupplierServiceI sellSupplierService;

	@Autowired
	private PreferredSupplierServiceI preferredSupplierServiceI;

	@Autowired
	private UsersServiceI usersServiceI;

	@Autowired
	private MakeQuotationServiceI makeQuotationService;

	@Autowired
	private CompanyServiceI companyService;

	@Autowired
	private MessageServiceI messageService;

	@Autowired
	private NotificationServiceI notificationServiceI;

	@Autowired
	private CompanyServiceI companyServiceI;

	@Autowired
	private SellerBiddingServiceI sellerBiddingService;

	@Autowired
	private StateServiceI stateService;

	@Autowired
	private CityServiceI cityService;
	@Autowired
	private AdminProductPackagingServiceI adminProductPackagingService;

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

	public SearchCriteria getSearchCriteria(BuyerBiddingForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());

		if (!DataValidator.isNull(form.getBidRefrenceNo())) {
			sc.setAttribute("bidRefrenceNo", form.getBidRefrenceNo());
		}
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
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
		UserDTO dto = (UserDTO) ctx.getBaseDTO();
		if (dto.getRoleId() != 1L) {
			sc.setAttribute("createdBy", dto.getCreatedBy());
			System.out.println("Inside Loop");

		} else if (dto.getRoleId() == 1L) {
			if (dto.getRoleId() == 1L) {
				sc.setAttribute("-createdBy", dto.getCreatedBy());

			}
		}
		return sc;
	};

	// Report

	@RequestMapping(value = "/searchByValue", method = { RequestMethod.GET, RequestMethod.POST })
	public BuyerBiddingForm getReport(@RequestBody BuyerBiddingForm form, HttpSession session, UserContext ctx)
			throws Exception {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		// sc.setAttribute("=category",1);
		if (!DataValidator.isNull(form.getProductName())) {
			sc.setAttribute("=productName", form.getProductName());
		}
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("=stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("=cityName", form.getCityName());
		}
		if (!DataValidator.isNull(form.getStartDate())) {
			sc.setAttribute(">=startDate", form.getStartDate());
		}
		if (!DataValidator.isNull(form.getEnddate())) {
			sc.setAttribute("<=enddate", form.getEnddate());
		}

		List list = buyerBiddingService.find(sc, ctx);
		ncsResponseData.setForm(form);
		return form;
	}

	@RequestMapping(value = "/getBuyerInfo/{type}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getBuyerInfo(@PathVariable("type") String type,
			@RequestBody(required = false) BuyerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		AdminProductDTO adminProductDTO = null;
		PreferredSupplierDTO preferredSupplierDTO = null;
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=type", type);
		if (form != null) {
			BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
			if (dto.getProductId() != null && dto.getProductId() > 0) {
				sc.setAttribute("=productId", dto.getProductId());
				adminProductDTO = (AdminProductDTO) adminProductService.findByPK(dto.getProductId(), ctx);
				session.setAttribute("sessionProduct", adminProductDTO);
			}
			if (dto.getStatus() != null && dto.getStatus() != "") {
				sc.setAttribute("=status", dto.getStatus());
			} else {
				sc.setAttribute("=status", "ACTIVE");
			}
		} else {
			adminProductDTO = (AdminProductDTO) session.getAttribute("sessionProduct");
			sc.setAttribute("=productId", adminProductDTO.getId());
			sc.setAttribute("=status", "ACTIVE");
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setDto(adminProductDTO);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchUserBuyReport", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchUserSellerReport(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchBuyerDashBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchBuyerDashBoard(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=status", "ACTIVE");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchBuyerDashBoardActive", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchBuyerDashBoardActive(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);

		sc.setAttribute("=status", "ABOUT TO OPEN");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByBox", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByBox(@RequestBody BuyerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
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
			sc.setAttribute(">=startDate", form.getStartDate());
		}
		if (!DataValidator.isNull(form.getEnddate())) {
			sc.setAttribute("<=enddate", form.getEnddate());
		}
		if (!DataValidator.isNull(form.getBidRefrenceNo())) {
			sc.setAttribute("=bidRefrenceNo", form.getBidRefrenceNo());
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	public List findInvitedSeller() {
		List list = preferredSupplierServiceI.findBySql("select * from preferred_supplier", null);
		return list;
	}

	@RequestMapping(value = "/getBuyerTab/{type}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getBuyerTab(@PathVariable("type") String type,

			@RequestBody(required = false) BuyerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(MakeQuotationDTO.class);
		System.out.println("Buyerbid Tab Call" + userDTO.getUserCompanyId());
		sc.setAttribute("-createdBy", userDTO.getLoginId());
		// sc.setAttribute("=type", type);
		sc.setAttribute("=invitedUserCompanyId", userDTO.getUserCompanyId());
		if (form != null) {
			BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
			if (dto.getStatus() != null && dto.getStatus() != "") {
				sc.setAttribute("=status", dto.getStatus());
				if (dto.getStatus().equals("ACTIVE")) {
					sc.setAttribute("=inviteStatus", "Accept");
				}
			} else {

				ncsResponseData.setSuccess(false);
			}
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/getBuyerInfoOpen/{type}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getBuyerInfoOpen(@PathVariable("type") String type,
			@RequestBody(required = false) BuyerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		AdminProductDTO adminProductDTO = null;
		SearchCriteria sc = new SearchCriteria();

		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=type", type);
		if (form != null) {
			BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
			if (dto.getProductId() != null && dto.getProductId() > 0) {
				sc.setAttribute("=productId", dto.getProductId());
				adminProductDTO = (AdminProductDTO) adminProductService.findByPK(dto.getProductId(), ctx);
				session.setAttribute("sessionProduct", adminProductDTO);
			}
			if (dto.getStatus() != null && dto.getStatus() != "") {
				sc.setAttribute("=status", dto.getStatus());
			} else {
				sc.setAttribute("=status", "ABOUT TO OPEN");
			}
		} else {
			adminProductDTO = (AdminProductDTO) session.getAttribute("sessionProduct");
			sc.setAttribute("=productId", adminProductDTO.getId());
			sc.setAttribute("=status", "ABOUT TO OPEN");
		}
		List list = service.find(sc, ctx);
		ncsResponseData.setDto(adminProductDTO);
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
		sc.setDto(BuyerBiddingDTO.class);
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
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchLive", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchLive(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		System.out.println("login id: " + userDTO.getLoginId());
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		sc.setAttribute("=status", "ACTIVE");
		List<BuyerBiddingDTO> list = service.find(sc, ctx);
		for (BuyerBiddingDTO buyerBiddingDTO : list) {
			List qoutaionCount = service.findBySql("SELECT MAX(s.ID) ID FROM BUYER_QUOTATION s WHERE s.PRODUCT_ID="
					+ buyerBiddingDTO.getProductId() + " AND s.CITY_ID= " + buyerBiddingDTO.getCityId()
					+ " AND s.STATE_ID=" + buyerBiddingDTO.getStateId() + " AND s.PACKAGING_ID= "
					+ buyerBiddingDTO.getPackagingId() + " GROUP BY s.COMPANY_ID ORDER BY QUOTATION_AMOUNT DESC", ctx);
			buyerBiddingDTO.setCounter(qoutaionCount.size());
		}
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/homeLive", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData homeLive(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=status", "ACTIVE");
		List<BuyerBiddingDTO> list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByCity/{city}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByCity(@PathVariable("city") String city, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=cityName", city);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/buyerDeals", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData buyerDeals(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List dbList = new ArrayList();
		List<BuyerBiddingDTO> list = service.find(sc, ctx);
		for (BuyerBiddingDTO sellerBiddingDTO : list) {
			sc = new SearchCriteria();
			sc.setDto(BuyerQuotationDTO.class);
			sc.setAttribute("=bidId", sellerBiddingDTO.getId());
			sc.setAttribute("=status", "WON");
			List quotationList = service.find(sc, ctx);
			dbList.addAll(quotationList);
		}
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(dbList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/makeQuotation", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData makeQuotation(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("-createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(false);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/seeSellerOffers", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData seeSellerOffers(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("-createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);

		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(false);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/findByProductUserProcut/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByProductUserProcut(@PathVariable("productId") Long productId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setAttribute("=productId", productId);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/visitor", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData visitor(@RequestBody SellerBiddingForm form, HttpSession session) throws Exception {
		SellerBiddingDTO dto = (SellerBiddingDTO) form.makeDto();
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellerBiddingDTO.class);
		sc.setAttribute("-createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			SellerBiddingDTO sbdto = (SellerBiddingDTO) itr.next();
			sc = new SearchCriteria();
			sc.setDto(SellerQuotationDTO.class);
			sc.setAttribute("=bidId", sbdto.getId());
			sc.setAttribute("=productId", sbdto.getProductId());
			sc.setAttribute("=sellerId", userDTO.getId());
			List qtnList = sellerQuotationService.find(sc, ctx);
			if (qtnList.size() == 0) {
				SellerQuotationDTO sellerQuotationDTO = new SellerQuotationDTO();
				SearchCriteria compSc = new SearchCriteria();
				compSc.setDto(CompanyDTO.class);
				compSc.setAttribute("=userId", userDTO.getId());
				List compList = service.find(compSc, ctx);
				CompanyDTO companyDTO = new CompanyDTO();
				if (compList != null && compList.size() > 0) {
					companyDTO = (CompanyDTO) compList.get(0);
				}
				Date date = new Date();
				sellerQuotationDTO.setBidId(sbdto.getId());
				sellerQuotationDTO.setSellerId(userDTO.getId());
				sellerQuotationDTO.setSellerName(userDTO.getFirstName() + " " + userDTO.getLastName());
				sellerQuotationDTO.setProductId(sbdto.getProductId());
				sellerQuotationDTO.setProductName(sbdto.getProductName());
				sellerQuotationDTO.setPackaging(sbdto.getPackaging());
				sellerQuotationDTO.setQuantity(sbdto.getQuantity());
				sellerQuotationDTO.setUnit(sbdto.getUnit());
				sellerQuotationDTO.setStatus("OPEN");
				sellerQuotationDTO.setCityName(sbdto.getCityName());
				sellerQuotationDTO.setStateName(sbdto.getStateName());
				sellerQuotationDTO.setCreatedDate(new Timestamp((date.getTime())));
				sellerQuotationDTO.setQuotationAmount(0.0);
				sellerQuotationDTO.setCompanyId(companyDTO.getId());
				sellerQuotationDTO.setCompanyName(companyDTO.getCompanyName());
				sellerQuotationDTO.setActive(true);
				sellerQuotationDTO.setTimestamp(new Timestamp(new Date().getTime()));
				sellerQuotationDTO.setCreatedBy(ctx.getCreatedBy());
				sellerQuotationDTO.setModifiedBy(ctx.getModifiedBy());
				sellerQuotationDTO.setStatus("Visited");
				sellerQuotationDTO.setActive(true);
				sellerQuotationService.add(sellerQuotationDTO, ctx);
				int visitors = sbdto.getVisitor();
				sbdto.setVisitor(visitors + 1);
				service.update(sbdto, ctx);
			}
		}
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(false);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody BuyerBiddingForm form, HttpSession session) {
		BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		NotificationDTO notificationDTO = new NotificationDTO();
		List<Object[]> uniqueAttributes = new ArrayList<Object[]>();
		uniqueAttributes.add(new Object[] { "packaging", dto.getPackaging() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "createdBy", userDTO.getLoginId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "stateName", dto.getStateName() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "cityName", dto.getCityName() });
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
			dto.setCompanyId(companyDTO.getId());
			dto.setCompanyName(companyDTO.getCompanyName());
			dto.setCreatedBy(ctx.getCreatedBy());
			dto.setModifiedBy(ctx.getModifiedBy());
			dto.setGroupId(companyDTO.getGroupId());
			dto.setGroupIdString(companyDTO.getGroupIdString());
			sc = new SearchCriteria();
			sc.setDto(AdminProductDTO.class);
			List<AdminProductDTO> list3 = adminProductService.find(sc, ctx);
			for (AdminProductDTO adminProductDTO : list3) {
				if (adminProductDTO.getId() == dto.getProductId()) {
					Double secuirityAmount = adminProductDTO.getSecuirityAmount();
					System.out.println(secuirityAmount + " amount of product");
					dto.setBidAmount(dto.getQuantity() * secuirityAmount * 1000);
				}
			}

			sc = new SearchCriteria();
			sc.setDto(BuyerBiddingDTO.class);
			List list1 = buyerBiddingService.find(sc, ctx);
			BuyerBiddingDTO buyerBiddingDTO = new BuyerBiddingDTO();
			if (list1 != null && list1.size() > 0) {
				buyerBiddingDTO = (BuyerBiddingDTO) list1.get(0);
			}
			sc = new SearchCriteria();
			sc.setDto(SystemSettingDTO.class);
			List list2 = systemSettingService.find(sc, ctx);
			SystemSettingDTO systemSettingDTO = new SystemSettingDTO();
			if (list2 != null && list2.size() > 0) {
				systemSettingDTO = (SystemSettingDTO) list2.get(0);
			}

			Double a = systemSettingDTO.getSecuirityAmount();
			if (dto.getQuantity() >= systemSettingDTO.getQuantity()) {
				service.add(dto, ctx);
				if (dto.getCheckValueAllSellers().equals("all")) {
					System.out.println("all seller " + dto.getCheckValueAllSellers());
					if (dto.getAllSellerId() != null) {
						String array[] = dto.getAllSellerId().split(",");
						for (String string : array) {
							Long id = Long.parseLong(string);
							CompanyDTO com = (CompanyDTO) companyService.findByPK(id, ctx);
							PreferredSupplierDTO pdto = new PreferredSupplierDTO();
							pdto.setCompanyId(com.getGroupId());
							pdto.setCompanyName(com.getCompanyName());
							pdto.setUserId(com.getUserId());
							pdto.setGroupId(userDTO.getGroupId());
							pdto.setGroupIdString(userDTO.getGroupIdString());
							pdto.setUserName(com.getCreatedBy());
							pdto.setCreatedBy(ctx.getCreatedBy());
							pdto.setModifiedBy(ctx.getModifiedBy());
							pdto.setBidId(dto.getId());
							pdto.setStatus("No Reply");

							preferredSupplierServiceI.add(pdto, ctx);
							MakeQuotationDTO makeQuotationDTO = new MakeQuotationDTO();
							makeQuotationDTO.setProductId(dto.getProductId());
							makeQuotationDTO.setProductName(dto.getProductName());
							makeQuotationDTO.setPackagingId(dto.getPackagingId());
							makeQuotationDTO.setPackaging(dto.getPackaging());
							makeQuotationDTO.setQuantity(dto.getQuantity());
							makeQuotationDTO.setRemainingQuantity(dto.getRemainingQuantity());
							makeQuotationDTO.setStartDate(dto.getStartDate());
							makeQuotationDTO.setEnddate(dto.getEnddate());
							makeQuotationDTO.setCreatedBy(ctx.getCreatedBy());
							makeQuotationDTO.setModifiedBy(ctx.getModifiedBy());
							makeQuotationDTO.setInvitedUserId(com.getUserId());
							makeQuotationDTO.setInvitedUserName(com.getCreatedBy());
							makeQuotationDTO.setStatus(dto.getStatus());
							makeQuotationDTO.setInviteStatus(pdto.getStatus());
							makeQuotationDTO.setBidRefrenceNo(dto.getBidRefrenceNo());
							makeQuotationDTO.setType(dto.getType());
							makeQuotationDTO.setCompanyId(dto.getCompanyId());
							makeQuotationDTO.setCompanyName(dto.getCompanyName());
							makeQuotationDTO.setUnit(dto.getUnit());
							makeQuotationDTO.setTransportation(dto.getTransportation());
							makeQuotationDTO.setInsurance(dto.getInsurance());
							makeQuotationDTO.setThirdPartyInspection(dto.getThirdPartyInspection());
							makeQuotationDTO.setCityId(dto.getCityId());
							makeQuotationDTO.setCityName(dto.getCityName());
							makeQuotationDTO.setStateId(dto.getStateId());
							makeQuotationDTO.setStateName(dto.getStateName());
							makeQuotationDTO.setFreezingType(dto.getFreezingType());
							makeQuotationDTO.setInvitedUserCompanyId(com.getId());
							makeQuotationDTO.setInvitedUserCompanyName(com.getCompanyName());
							makeQuotationDTO.setInviteGroupId(com.getGroupId());
							makeQuotationDTO.setGroupId(companyDTO.getGroupId());
							makeQuotationDTO.setGroupIdString(companyDTO.getGroupIdString());
							makeQuotationDTO.setIsAccept(false);
							makeQuotationDTO.setIsReject(false);
							makeQuotationDTO.setBidAmount(dto.getBidAmount());
							makeQuotationDTO.setBidId(dto.getId());
							makeQuotationService.add(makeQuotationDTO, ctx);
							MessageDTO messageDTO = messageService.findByCode("B03", ctx);
							if (messageDTO != null) {
								String message = messageDTO.getMessage();
								message = message.replace("<user>", com.getCreatedBy());
								message = message.replace("<site>", "www.frozenB2B.in");
								NotificationDTO receiverNotification = new NotificationDTO();
								receiverNotification.setSubject(messageDTO.getTitle());
								receiverNotification.setFrom("system");
								receiverNotification.setMessage(message);
								receiverNotification.setTo(com.getCreatedBy());
								receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
								receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
								notificationService.add(receiverNotification, ctx);
							}
						}
					}
				} else if (dto.getCheckValue().equals("YES")) {
					sc = new SearchCriteria();
					sc.setDto(SellSupplierDTO.class);
					sc.setAttribute("=createdBy", userDTO.getLoginId());
					sc.setAttribute("=productId", dto.getProductId());
					List<SellSupplierDTO> ll = sellSupplierService.find(sc, ctx);

					for (SellSupplierDTO sellSupplierDTO : ll) {
						PreferredSupplierDTO pdto = new PreferredSupplierDTO();
						pdto.setCompanyId(sellSupplierDTO.getFavGroupId());
						pdto.setCompanyName(sellSupplierDTO.getFavGroupIdString());
						pdto.setUserId(sellSupplierDTO.getUserId());
						pdto.setUserName(sellSupplierDTO.getCreatedBy());
						pdto.setCreatedBy(ctx.getCreatedBy());
						pdto.setModifiedBy(ctx.getModifiedBy());
						pdto.setBidId(dto.getId());
						pdto.setStatus("No Reply");
						pdto.setGroupId(userDTO.getGroupId());
						pdto.setGroupIdString(userDTO.getGroupIdString());

						preferredSupplierServiceI.add(pdto, ctx);
						MakeQuotationDTO makeQuotationDTO = new MakeQuotationDTO();
						makeQuotationDTO.setId(dto.getId());
						makeQuotationDTO.setProductId(dto.getProductId());
						makeQuotationDTO.setProductName(dto.getProductName());
						makeQuotationDTO.setPackagingId(dto.getPackagingId());
						makeQuotationDTO.setPackaging(dto.getPackaging());
						makeQuotationDTO.setQuantity(dto.getQuantity());
						makeQuotationDTO.setRemainingQuantity(dto.getRemainingQuantity());
						makeQuotationDTO.setStartDate(dto.getStartDate());
						makeQuotationDTO.setEnddate(dto.getEnddate());
						makeQuotationDTO.setBidId(dto.getId());
						makeQuotationDTO.setCreatedBy(ctx.getCreatedBy());
						makeQuotationDTO.setModifiedBy(ctx.getModifiedBy());
						makeQuotationDTO.setInvitedUserId(sellSupplierDTO.getUserId());
						makeQuotationDTO.setInvitedUserName(sellSupplierDTO.getUserName());
						makeQuotationDTO.setInviteGroupId(sellSupplierDTO.getCompanyId());
						makeQuotationDTO.setStatus(dto.getStatus());
						makeQuotationDTO.setInviteStatus(pdto.getStatus());
						makeQuotationDTO.setBidRefrenceNo(dto.getBidRefrenceNo());
						makeQuotationDTO.setType(dto.getType());
						makeQuotationDTO.setCompanyId(dto.getCompanyId());
						makeQuotationDTO.setCompanyName(dto.getCompanyName());
						makeQuotationDTO.setUnit(dto.getUnit());
						makeQuotationDTO.setTransportation(dto.getTransportation());
						makeQuotationDTO.setInsurance(dto.getInsurance());
						makeQuotationDTO.setThirdPartyInspection(dto.getThirdPartyInspection());
						makeQuotationDTO.setCityId(dto.getCityId());
						makeQuotationDTO.setCityName(dto.getCityName());
						makeQuotationDTO.setStateId(dto.getStateId());
						makeQuotationDTO.setStateName(dto.getStateName());
						makeQuotationDTO.setFreezingType(dto.getFreezingType());
						makeQuotationDTO.setInvitedUserCompanyId(sellSupplierDTO.getFavGroupId());
						makeQuotationDTO.setInvitedUserCompanyName(sellSupplierDTO.getFavGroupIdString());
						makeQuotationDTO.setGroupId(companyDTO.getGroupId());
						makeQuotationDTO.setGroupIdString(companyDTO.getGroupIdString());
						makeQuotationDTO.setIsAccept(false);
						makeQuotationDTO.setIsReject(false);
						makeQuotationDTO.setBidAmount(dto.getBidAmount());
						makeQuotationService.add(makeQuotationDTO, ctx);
					}
				}
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Record has been added successfully.");
			} else {
				ncsResponseData.setSuccess(false);
				ncsResponseData
						.setMessage("Quantity must be greater than MOQ Quantity " + systemSettingDTO.getQuantity());
			}

		} catch (

		DuplicateRecordException e)

		{
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "edits/{id}", method = RequestMethod.GET)
	public NcsResponseData displayEdit(@PathVariable long id, BuyerBiddingForm form, HttpSession session)
			throws Exception {

		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		if (id > 0) {
			BaseDTO dto = service.findByPK(id, null);
			if (dto != null) {
				form.populate(dto);
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(true);
			} else {
				ncsResponseData.setSuccess(false);
				ncsResponseData.setMessage("Record Not found.");
			}
		} else {
			ncsResponseData.setMessage("ID is not valid");
			ncsResponseData.setSuccess(false);
		}
		return ncsResponseData;
	}

	@Override
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public NcsResponseData submitEdit(@RequestBody BuyerBiddingForm form, HttpSession session) throws Exception {
		try {
			NcsResponseData ncsResponseData = new NcsResponseData();
			ctx = getUserContext(session);
			BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
			if (dto.getId() != null && dto.getId() > 0) {
				// dto.setModifiedBy(ctx.getModifiedBy());

				SearchCriteria sc = new SearchCriteria();
				sc.setDto(MakeQuotationDTO.class);
				sc.setAttribute("=bidId", dto.getId());
				List<MakeQuotationDTO> list = makeQuotationService.find(sc, ctx);

				for (MakeQuotationDTO makeQuotationDTO1 : list) {
					makeQuotationDTO1.setProductId(dto.getProductId());
					makeQuotationDTO1.setProductName(dto.getProductName());
					makeQuotationDTO1.setCreatedBy(dto.getCreatedBy());
					makeQuotationDTO1.setDeleted(dto.getDeleted());
					makeQuotationDTO1.setGroupId(dto.getGroupId());
					makeQuotationDTO1.setGroupIdString(dto.getGroupIdString());
					makeQuotationDTO1.setModifiedBy(dto.getModifiedBy());
					makeQuotationDTO1.setPackaging(dto.getPackaging());
					makeQuotationDTO1.setPackagingId(dto.getPackagingId());
					makeQuotationDTO1.setCityId(dto.getCityId());
					makeQuotationDTO1.setCityName(dto.getCityName());
					makeQuotationDTO1.setStateId(dto.getStateId());
					makeQuotationDTO1.setCompanyId(dto.getCompanyId());
					makeQuotationDTO1.setCompanyName(dto.getCompanyName());
					makeQuotationDTO1.setQuantity(dto.getQuantity());
					makeQuotationDTO1.setUnit(dto.getUnit());
					makeQuotationDTO1.setStartDate(dto.getStartDate());
					makeQuotationDTO1.setEnddate(dto.getEnddate());
					makeQuotationDTO1.setExpectedDeliveryDate(dto.getExpectedDeliveryDate());
					makeQuotationDTO1.setStatus(dto.getStatus());
					makeQuotationDTO1.setTransportation(dto.getTransportation());
					makeQuotationDTO1.setInsurance(dto.getInsurance());
					makeQuotationDTO1.setThirdPartyInspection(dto.getThirdPartyInspection());

					if (dto.getStatus().equals("ACTIVE")) {
						MessageDTO messageDTO4 = messageService.findByCode("IS01", ctx);
						if (messageDTO4 != null) {
							String message = messageDTO4.getMessage();
							message = message.replace("<user>", makeQuotationDTO1.getInvitedUserName());
							message = message.replace("<bidRef>", dto.getBidRefrenceNo());
							message = message.replace("<site>", "www.frozenB2B.in");
							NotificationDTO receiverNotification = new NotificationDTO();
							receiverNotification.setSubject(messageDTO4.getTitle());
							receiverNotification.setFrom("system");
							receiverNotification.setMessage(message);
							receiverNotification.setTo(makeQuotationDTO1.getInvitedUserName());
							receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
							receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
							notificationService.add(receiverNotification, ctx);
						}
					}
					if (dto.getStatus().equals("DEACTIVE")) {
						MessageDTO messageDTO3 = messageService.findByCode("IS02", ctx);
						if (messageDTO3 != null) {
							String message = messageDTO3.getMessage();
							message = message.replace("<user>", makeQuotationDTO1.getInvitedUserName());
							message = message.replace("<bidRef>", dto.getBidRefrenceNo());
							message = message.replace("<site>", "www.frozenB2B.in");
							NotificationDTO receiverNotification = new NotificationDTO();
							receiverNotification.setSubject(messageDTO3.getTitle());
							receiverNotification.setFrom("system");
							receiverNotification.setMessage(message);
							receiverNotification.setTo(makeQuotationDTO1.getInvitedUserName());
							receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
							receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
							notificationService.add(receiverNotification, ctx);
						}
					}

					makeQuotationService.update(makeQuotationDTO1, ctx);
				}

				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Record has been updated successfully.");

				if (dto.getStatus().equals("ACTIVE")) {
					MessageDTO messageDTO = messageService.findByCode("B04", ctx);
					if (messageDTO != null) {
						String message = messageDTO.getMessage();
						message = message.replace("<user>", dto.getCreatedBy());
						message = message.replace("<site>", "www.frozenB2B.in");
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO.getTitle());
						receiverNotification.setFrom("system");
						receiverNotification.setMessage(message);
						receiverNotification.setTo(dto.getCreatedBy());
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
					MessageDTO messageDTO1 = messageService.findByCode("SU15", ctx);
					if (messageDTO1 != null) {
						String message = messageDTO1.getMessage();
						message = message.replace("<bidRef>", dto.getBidRefrenceNo());
						message = message.replace("<site>", "www.frozenB2B.in");
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO.getTitle());
						receiverNotification.setFrom(dto.getCreatedBy());
						receiverNotification.setMessage(message);
						receiverNotification.setTo("frozenb2b@mabl.in");
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
				}
				if (dto.getStatus().equals("DEACTIVE")) {
					MessageDTO messageDTO = messageService.findByCode("B10", ctx);
					if (messageDTO != null) {
						String message = messageDTO.getMessage();
						message = message.replace("<user>", dto.getCreatedBy());
						message = message.replace("<site>", "www.frozenB2B.in");
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO.getTitle());
						receiverNotification.setFrom("system");
						receiverNotification.setMessage(message);
						receiverNotification.setTo(dto.getCreatedBy());
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
					MessageDTO messageDTO1 = messageService.findByCode("SU14", ctx);
					if (messageDTO1 != null) {
						String message = messageDTO1.getMessage();
						message = message.replace("<bidRef>", dto.getBidRefrenceNo());
						message = message.replace("<site>", "www.frozenB2B.in");
						NotificationDTO receiverNotification = new NotificationDTO();
						receiverNotification.setSubject(messageDTO.getTitle());
						receiverNotification.setFrom(dto.getCreatedBy());
						receiverNotification.setMessage(message);
						receiverNotification.setTo("frozenb2b@mabl.in");
						receiverNotification.setCreatedDate(new Timestamp(new Date().getTime()));
						receiverNotification.setModifiedDate(new Timestamp(new Date().getTime()));
						notificationService.add(receiverNotification, ctx);
					}
				}

				service.update(dto, ctx);

				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Record has been updated successfully.");

			}
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}

		return ncsResponseData;
	}

	@RequestMapping(value = "editNew", method = RequestMethod.POST)
	public NcsResponseData submitEditt(@RequestBody BuyerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
		System.out.println("inside edit");
		try {
			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				service.update(dto, null);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Details Successfully Send, We Will Contact You Soon! ");

			}
		} catch (DuplicateRecordException e) {

			ncsResponseData.setMessage("Record is Already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}

		return ncsResponseData;
	}

	// Request Send

	@RequestMapping(value = "requestSend", method = RequestMethod.POST)
	public NcsResponseData requestSend(@RequestBody BuyerBiddingForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		BuyerBiddingDTO dto = (BuyerBiddingDTO) form.makeDto();
		try {
			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				// notificationService.newBidOpeningRequest(dto, ctx);
				// System.out.println("Notification Invoked");
				dto.setIsVisit(true);
				service.update(dto, null);
				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Details Successfully Send, We Will Contact You Soon! ");
			} else {
				System.out.println("outsideLoop");
			}
		} catch (DuplicateRecordException e) {

			ncsResponseData.setMessage("Record is Already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}

		return ncsResponseData;
	}

	@RequestMapping(value = "/viewInformation/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewInformation(@PathVariable Long id, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(BuyerBiddingDTO.class);
		// sc.setAttribute("=productId", productId);
		// sc.setAttribute("=packagingId", packagingId);
		sc.setAttribute("=id", id);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/viewSellers", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData viewSellers(@PathVariable Long id, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellSupplierDTO.class);
		// sc.setAttribute("=productId", productId);
		// sc.setAttribute("=packagingId", packagingId);
		// sc.setAttribute("=id", id);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		List list = sellSupplierService.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

}
