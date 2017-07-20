package com.ncs.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CityDTO;
import com.ncs.dto.PropertyDTO;
import com.ncs.dto.PropertySearchDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.PropertyForm;
import com.ncs.form.PropertySearchForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.StateServiceI;
import com.ncs.utill.getLocation.GetLocation;
import com.ncs.utill.getLocation.ServerLocation;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/PropertySearch")
public class PropertySearchCtl extends BaseCtl<PropertySearchForm> {

	@Override
	@Autowired
	@Qualifier("propertySearchService")

	public void setService(BaseServiceI service) {
		this.service = service;

	}

	@Autowired
	private StateServiceI stateService;

	@Autowired
	private CityServiceI cityService;
	
	@Autowired
	private HttpServletRequest request;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stateList", stateService.find(ctx));
		map.put("cityList", cityService.find(ctx));
		return map;
	
	}
	
	public SearchCriteria getSearchCriteria(PropertyForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
	
		
		if (!DataValidator.isNull(form)) {
			sc.setAttribute("propertyFor", form.getPropertyFor());
		}
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
			
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
			
		}
		return sc;
	};

	/*	@RequestMapping(value = { "/search" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET,
			org.springframework.web.bind.annotation.RequestMethod.POST })
	public NcsResponseData search(PropertySearchForm form, HttpSession session) throws Exception {
		System.out.println("in property search");
		this.ncsResponseData = new NcsResponseData(preload());
		this.ctx = getUserContext(session);
		SearchCriteria sc = getSearchCriteria(form);

		ServerLocation location = null;
		try {
			String ipAddress = request.getRemoteAddr();
			GetLocation getLocation = new GetLocation();
			location = getLocation.getLocation("111.118.250.74");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(location);

		
		if (location != null) {
			if (DataValidator.isNull(sc.getAttribute("stateName"))) {
				sc.setAttribute("stateName", location.getRegionName());
				SearchCriteria ssc = new SearchCriteria(StateDTO.class);
				ssc.setAttribute("=stateName", location.getRegionName());
				List stateList = stateService.find(ssc, ctx);
				if (stateList.size() > 0) {
					StateDTO stateDTO = (StateDTO) stateList.get(0);
					form.setStateId(stateDTO.getId());
					System.out.println("state ----"+stateDTO.getStateName());
					form.setStateName(stateDTO.getStateName());
				}
			}
			if (DataValidator.isNull(sc.getAttribute("cityName"))) {
				sc.setAttribute("cityName", location.getCity());
				SearchCriteria ssc = new SearchCriteria(CityDTO.class);
				ssc.setAttribute("=cityName", location.getCity());
				List cityList = cityService.find(ssc, ctx);
				if (cityList.size() > 0) {
					CityDTO cityDTO = (CityDTO) cityList.get(0);
					form.setCityId(cityDTO.getId());
					form.setCityName(cityDTO.getCityName());
				}
			}
		}

		List list = this.service.find(sc, this.ctx);
		this.ncsResponseData.setList(list);

		if (sc.isPagging()) {
			this.ncsResponseData.setRecordCount(sc.getRecordCount());
			this.ncsResponseData.setPageNo(sc.getPage());
			int size = (int) Math.ceil(sc.getRecordCount() / sc.getNoOfRecords());
			Integer[] pageNoList = new Integer[size];
			for (int i = 1; i <= size; ++i) {
				pageNoList[(i - 1)] = Integer.valueOf(i);
			}
			this.ncsResponseData.setPageNoList(pageNoList);
		}
		return this.ncsResponseData;
	}*/



}