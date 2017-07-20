package com.ncs.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.dto.CityDTO;
import com.ncs.dto.PropertyDTO;
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.PropertyForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.PropertyForServiceI;
import com.ncs.services.PropertyTypeServiceI;
import com.ncs.services.StateServiceI;
import com.ncs.services.UnitServiceI;
import com.ncs.utill.getLocation.GetLocation;
import com.ncs.utill.getLocation.ServerLocation;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.DuplicateRecordException;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Property")
public class PropertyCtl extends BaseCtl<PropertyForm> {
	@Override
	@Autowired
	@Qualifier("propertyService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private StateServiceI stateService;

	@Autowired
	private CityServiceI cityService;

	@Autowired
	private UnitServiceI unitService;

	@Autowired
	private PropertyForServiceI propertyForService;

	@Autowired
	private PropertyTypeServiceI propertyTypeService;

	@Autowired
	private HttpServletRequest request;

	@Override
	public HashMap<String, Object> preload() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stateList", stateService.find(ctx));
		// map.put("cityList", cityService.find(ctx));
		// map.put("unitList", unitService.find(ctx));
		// map.put("propertyForList", propertyForService.find(ctx));
		// map.put("propertyTypeList", propertyTypeService.find(ctx));
		return map;
	}

	public SearchCriteria getSearchCriteria(PropertyForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getPropertyFor())) {
			sc.setAttribute("propertyFor", form.getPropertyFor());
		}
		if (!DataValidator.isNull(form.getPropertyType())) {
			sc.setAttribute("propertyType", form.getPropertyType());
		}

		if (!DataValidator.isNull(form.getPropertyPrice())) {
			sc.setAttribute("propertyPrice", form.getPropertyPrice());
		}

		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getCityName())) {
			sc.setAttribute("cityName", form.getCityName());
		}

		if (!DataValidator.isNull(form.getAddress())) {
			sc.setAttribute("address", form.getAddress());
		}
		if (!DataValidator.isNull(form.getLandmark())) {
			sc.setAttribute("landmark", form.getLandmark());
		}
		if (!DataValidator.isNull(form.getBedrooms())) {
			sc.setAttribute("bedrooms", form.getBedrooms());
		}
		if (!DataValidator.isNull(form.getBathrooms())) {
			sc.setAttribute("bathrooms", form.getBathrooms());
		}
		if (!DataValidator.isNull(form.getBalconies())) {
			sc.setAttribute("balconies", form.getBalconies());
		}

		return sc;
	};

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody PropertyForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			PropertyDTO dto = (PropertyDTO) form.makeDto();
			if (dto.getCreatedBy() == null) {
				dto.setCreatedBy(dto.getPersonEmail());
				dto.setModifiedBy(dto.getModifiedBy());
				dto.setStatus("DEACTIVATE");
			}
			if (ctx != null && ctx.getBaseDTO() != null) {
				dto.setCreatedBy(userDTO.getCreatedBy());
				dto.setModifiedBy(userDTO.getModifiedBy());
			}
			if (dto != null) {
				long pk = service.add(dto, this.ctx);
				form.setId(Long.valueOf(pk));
				ncsResponseData.setForm(form);
				ncsResponseData.setSuccess(Boolean.valueOf(true));
				ncsResponseData.setMessage(
						"Congrats " + dto.getPersonFirstName() + " !! Your Property has been added successfully.");
			}
		} catch (DuplicateRecordException e) {
			ncsResponseData.setMessage("Property is already exist.");
		} catch (Exception e) {
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchByPropertyFor/{propertyFor}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByProprtyFor(@PathVariable("propertyFor") String propertyFor, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyDTO.class);
		sc.setAttribute("=propertyFor", propertyFor);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = { "/search" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET,
			org.springframework.web.bind.annotation.RequestMethod.POST })
	public NcsResponseData search(@RequestBody(required = false) PropertyForm form, HttpSession session)
			throws Exception {
		System.out.println(form);
		this.ncsResponseData = new NcsResponseData(preload());
		this.ctx = getUserContext(session);
		SearchCriteria sc = getSearchCriteria(form);
		sc.setPagging(false);

		ServerLocation location = null;
		try {
			String ipAddress = request.getRemoteAddr();
			GetLocation getLocation = new GetLocation();
			location = getLocation.getLocation("111.118.250.74");
			// location = getLocation.getLocation(ipAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (location != null) {
			if (DataValidator.isNull(sc.getAttribute("stateName"))) {
				// sc.setAttribute("stateName", location.getRegionName());
				SearchCriteria ssc = new SearchCriteria(StateDTO.class);
				ssc.setAttribute("=stateName", location.getRegionName());
				List stateList = stateService.find(ssc, ctx);
				if (stateList.size() > 0) {
					StateDTO stateDTO = (StateDTO) stateList.get(0);
					form.setStateId(stateDTO.getId());
					form.setStateName(stateDTO.getStateName());
				}
			}
			if (DataValidator.isNull(sc.getAttribute("cityName"))) {
				// sc.setAttribute("cityName", location.getCity());
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
		// System.out.println(sc.getAttribute("cityName") + " " +
		// sc.getAttribute("stateName"));
		//
		// System.out.println(sc.getAttributeNames());

		List list = this.service.find(sc, this.ctx);
		System.out.println("List size  " + list.size());
		// if (list.size() == 0) {
		// PropertyDTO dto = new PropertyDTO();
		// dto.setCreatedBy(form.get);
		// }

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
		this.ncsResponseData.setForm(form);
		return this.ncsResponseData;
	}
}
