package com.ncs.action;

import java.util.HashMap;
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

import com.ncs.dto.AccountMasterDTO;
import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.SellSupplierDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AccountMasterForm;
import com.ncs.form.AdminProductPackagingForm;
import com.ncs.services.AccountMasterServiceI;
import com.ncs.services.AdminProductPackagingServiceI;
import com.ncs.services.AdminProductServiceI;
import com.ncs.services.CompanyProductIntersectionI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/AdminProductPackaging")
public class AdminProductPackagingCtl extends BaseCtl<AdminProductPackagingForm> {
	private static Logger log = Logger.getLogger(AdminProductPackagingCtl.class);

	@Override
	@Autowired
	@Qualifier("adminProductPackagingService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	@Autowired
	private AdminProductPackagingServiceI adminProductPackagingServiceI;
	
	@Autowired
	private AdminProductServiceI adminProductService;
	
	@Autowired
	private CompanyProductIntersectionI companyProductIntersection;
	
	
	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productList", adminProductService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(AdminProductPackagingForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminProductPackagingDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getAdminProductName())) {
			sc.setAttribute("adminProductName", form.getAdminProductName());
		}
		if (!DataValidator.isNull(form.getPackaging())) {
			sc.setAttribute("packaging", form.getPackaging());
		}
		return sc;
	};
	

	@RequestMapping(value = "/findByProductId/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByProductId(@PathVariable("productId") Long productId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminProductPackagingDTO.class);
		sc.setAttribute("=adminProductId", productId);
		List list = adminProductPackagingServiceI.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	@RequestMapping(value = "/findByAmount/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByAmount(@PathVariable("id") Long id, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminProductDTO.class);
		sc.setAttribute("=id", id);
		List list = adminProductService.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	@RequestMapping(value = "/findByUserProductBuyer/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByUserProductBuyer(@PathVariable("productId") Long productId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO=(UserDTO)ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setAttribute("=productId", productId);
		sc.setAttribute("-productType", "Buyer");
		sc.setAttribute("deleted", 0);
		sc.setAttribute("-companyId",userDTO.getUserCompanyId());
		List list = companyProductIntersection.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	@RequestMapping(value = "/findByUserProductFavourite/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByUserProductFavourite(@PathVariable("productId") Long productId, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SellSupplierDTO.class);
		sc.setAttribute("=productId", productId);
		sc.setAttribute("=groupId", userDTO.getGroupId());
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
/*	@RequestMapping(value = "/searchByBox", method = { RequestMethod.GET,
			   RequestMethod.POST })
			 public NcsResponseData search(@RequestBody AdminProductPackagingForm form,
			   HttpSession session) throws Exception {
			  NcsResponseData ncsResponseData = new NcsResponseData();
			  SearchCriteria sc = new SearchCriteria();
			  sc.setDto(AdminProductPackagingDTO.class);
			  if(!DataValidator.isNull(form.getAdminProductName())){
			  sc.setAttribute("=adminProductName", form.getAdminProductName());
			  }
			  if(!DataValidator.isNull(form.getPackaging())){
				  sc.setAttribute("=packaging", form.getPackaging());
				  }
			  List list = adminProductPackagingServiceI.find(sc, ctx);
			  ncsResponseData.setForm(null);
			  ncsResponseData.setSuccess(true);
			  ncsResponseData.setList(list);
			  return ncsResponseData;
			 }
	*/

}
