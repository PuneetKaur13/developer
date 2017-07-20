package com.ncs.action;

import java.util.ArrayList;
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
import com.ncs.dto.AdminProductPackagingDTO;
import com.ncs.dto.CityDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.SellerBiddingDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.AccountMasterForm;
import com.ncs.form.CityForm;
import com.ncs.form.SellerBiddingForm;
import com.ncs.form.StateForm;
import com.ncs.services.AccountMasterServiceI;
import com.ncs.services.CityServiceI;
import com.ncs.services.CityServiceImpl;
import com.ncs.services.StateServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/City")
public class CityCtl extends BaseCtl<CityForm> {

	private static Logger log = Logger.getLogger(CityCtl.class);

	@Override
	@Autowired
	@Qualifier("cityService")
	public void setService(BaseServiceI service) {
		this.service = service;

	}

	@Autowired
	private StateServiceI stateService;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stateList", stateService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(CityForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CityDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
		}
		return sc;
	}
	
	
	@RequestMapping(value = "/searchCity", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchState(@RequestBody(required = false) CityForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CityDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/findByStateId/{stateId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData findByStateId(@PathVariable("stateId") Long stateId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CityDTO.class);
		sc.setAttribute("=stateId", stateId);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	/*
	 * @RequestMapping(value = "/searchByBox", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public NcsResponseData search(@RequestBody CityForm
	 * form, HttpSession session) throws Exception { NcsResponseData
	 * ncsResponseData = new NcsResponseData(); SearchCriteria sc = new
	 * SearchCriteria(); sc.setDto(CityDTO.class);
	 * if(!DataValidator.isNull(form.getCityName())){
	 * sc.setAttribute("=cityName", form.getCityName()); }
	 * if(!DataValidator.isNull(form.getStateName())){
	 * sc.setAttribute("=stateName", form.getStateName()); } List list =
	 * cityService.find(sc, ctx); System.out.println("List"+list);
	 * ncsResponseData.setForm(null); ncsResponseData.setSuccess(true);
	 * ncsResponseData.setList(list); return ncsResponseData; }
	 */
}
