package com.ncs.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AdminProductForm;
import com.ncs.form.AdminProductPackagingForm;
import com.ncs.form.StateForm;
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
@RequestMapping(value = "rest/AdminProduct")
public class AdminProductCtl extends BaseCtl<AdminProductForm> {
	private static Logger log = Logger.getLogger(AdminProductCtl.class);

	@Override
	@Autowired
	@Qualifier("adminProductService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private AdminProductServiceI adminProductServiceI;

	@Autowired
	private CompanyProductIntersectionI companyProductIntersectionI;
	
	
	public SearchCriteria getSearchCriteria(AdminProductForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminProductDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getName())) {
			sc.setAttribute("name", form.getName());
		}
		if (!DataValidator.isNull(form.getUnit())) {
			sc.setAttribute("unit", form.getUnit());
		}
		return sc;
	};

	@RequestMapping(value = "/searchProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchProduct(@RequestBody(required = false) AdminProductForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminProductDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}


	@RequestMapping(value = "/searchBySeller", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchBySeller(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CompanyProductIntersectionDTO.class);
		sc.setAttribute("=createdBy", userDTO.getLoginId());
		sc.setAttribute("-productType", "Buyer");
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/setSessionProduct/{productId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData setSessionProduct(@PathVariable Long productId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		AdminProductDTO dto = (AdminProductDTO) service.findByPK(productId, ctx);
		session.setAttribute("sessionProduct", dto);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(null);
		return ncsResponseData;
	}

	@RequestMapping(value = "/getSessionProduct", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData getSessionProduct(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		AdminProductDTO dto = (AdminProductDTO) session.getAttribute("sessionProduct");
		ncsResponseData.setDto(dto);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(null);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByBox", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByBox(@RequestBody AdminProductForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(AdminProductDTO.class);
		if (!DataValidator.isNull(form.getName())) {
			sc.setAttribute("=name", form.getName());
		}
		if (!DataValidator.isNull(form.getUnit())) {
			sc.setAttribute("=packaging", form.getUnit());
		}
		List list = adminProductServiceI.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}



}