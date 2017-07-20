package com.ncs.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.BuySupplierDTO;
import com.ncs.dto.BuyerBiddingDTO;
import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.ncs.dto.SellSupplierDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AdminProductForm;
import com.ncs.form.BuySupplierForm;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.SellSupplierForm;
import com.ncs.services.AdminProductPackagingServiceI;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.BuyerBiddingServiceI;
import com.ncs.services.CompanyProductIntersectionI;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.PreferredSupplierServiceI;
import com.ncs.services.SellSupplierServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/SellSupplier")
public class SellSupplierCtl extends BaseCtl<SellSupplierForm> {

	private static Logger log = Logger.getLogger(AdminProductCtl.class);

	@Override
	@Autowired
	@Qualifier("sellSupplierService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	CompanyServiceI companyService;

	@Autowired
	AdminProductPackagingServiceI adminProductPackagingService;

	@Autowired
	SellSupplierServiceI sellSupplierService;

	@Autowired
	PreferredSupplierServiceI preferredSupplierService;

	@Autowired
	SessionFactory sessionFactory = null;

	@Autowired
	private AdminProductServiceI adminProductService;

	@Autowired
	private CompanyProductIntersectionI companyProductIntersection;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productList", adminProductService.find(ctx));
		map.put("userCompanyProductList", companyProductIntersection.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(SellSupplierForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellSupplierDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());

		if (ctx != null && ctx.getBaseDTO() != null) {
			UserDTO dto = (UserDTO) ctx.getBaseDTO();
			sc.setAttribute("createdBy", dto.getCreatedBy());
		}
		return sc;
	};

	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByUser(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellSupplierDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		sc.setAttribute("deleted", 0);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/excludeSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData excludeSeller(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		List list = service.findBySql(
				"SELECT COMPANY_NAME,FIRST_NAME FROM COMPANY WHERE `TYPE`='SELLER' AND NOT EXISTS (SELECT * FROM SELL_SUPPLIER WHERE COMPANY.COMPANY_NAME = SELL_SUPPLIER.COMPANY_NAME)OR `TYPE`='BOTH' ",
				ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		List<SellSupplierDTO> dtoList = new ArrayList<SellSupplierDTO>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object[] data = (Object[]) it.next();
			SellSupplierDTO dto = new SellSupplierDTO();
			dto.setCompanyName((data[0].toString()));
			dtoList.add(dto);
		}
		ncsResponseData.setList(dtoList);
		return ncsResponseData;
	}

	@RequestMapping(value = "/allSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData allSeller(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setAttribute("-productType", "Buyer");
		sc.setAttribute("-createdBy", userDTO.getCreatedBy());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	public NcsResponseData submitAdd(@RequestBody SellSupplierForm form, HttpSession session) {
		SellSupplierDTO dto = (SellSupplierDTO) form.makeDto();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		List<Object[]> uniqueAttributes = new ArrayList<Object[]>();
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "createdBy", userDTO.getLoginId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productName", dto.getProductName() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "productId", dto.getProductId() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "companyName", dto.getCompanyName() });
		uniqueAttributes.add(new Object[] { "&", "&" });
		uniqueAttributes.add(new Object[] { "companyId", dto.getCompanyId() });
		dto.setUniqueAttributes(uniqueAttributes);
		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
	
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(SellSupplierDTO.class);
			List list = service.find(sc, ctx);
			dto.setCreatedBy(userDTO.getCreatedBy());
			dto.setModifiedBy(userDTO.getModifiedBy());
			dto.setGroupId(userDTO.getGroupId());
			dto.setGroupIdString(userDTO.getGroupIdString());
			CompanyDTO companyDTO = (CompanyDTO) companyService.findByPK(dto.getCompanyId(), ctx);
			dto.setFavGroupId(companyDTO.getGroupId());
			dto.setFavCompanyName(companyDTO.getCompanyName());
			dto.setFavGroupIdString(companyDTO.getGroupIdString());
			dto.setFavCompanyId(companyDTO.getId());
			
			
			service.add(dto, ctx);
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been added successfully.");
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return ncsResponseData;
	}


	@RequestMapping(value = "/select/{ids}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData selectAll(@PathVariable String ids, HttpSession session) throws Exception {

		NcsResponseData ncsResponseData = new NcsResponseData();
		try {
			ctx = getUserContext(session);
			UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
			if (ids != null) {
				String[] arr = ids.split(",");

				// for (int j = 0; j < arr.length; j++) {
				// long id = Long.parseLong(arr[j]);
				// System.out.println(id);
				PreferredSupplierDTO pdto = new PreferredSupplierDTO();
				pdto.setBuyerSelectedId(ids);
				pdto.setCreatedBy(userDTO.getLoginId());
				preferredSupplierService.add(pdto, ctx);
				// }

				ncsResponseData.setSuccess(true);
				ncsResponseData.setMessage("Invitation Sent SuccessFully.");
			} else {
				ncsResponseData.setMessage("ID is not valid");
				ncsResponseData.setSuccess(false);
			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Record is already exist.");
		}
		return ncsResponseData;
	}

}