package com.ncs.action;

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

import com.ncs.dto.CityDTO;
import com.ncs.dto.UnitDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CityForm;
import com.ncs.form.UnitForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.UnitServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/Unit")
public class UnitCtl extends BaseCtl<UnitForm> {

	private static Logger log = Logger.getLogger(UnitCtl.class);

	@Override
	@Autowired
	@Qualifier("unitService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	 @Autowired
	private UnitServiceI unitServiceI;
	
	public SearchCriteria getSearchCriteria(UnitForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UnitDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getUnitName())) {
			sc.setAttribute("unitName", form.getUnitName());
		}
		
		return sc;
	};
	

	 	@RequestMapping(value = "/searchUnitDashBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchUnitDashBoard(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UnitDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}


	@RequestMapping(value = "/searchUnit/{unitId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchUnit(@PathVariable long unitId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CityDTO.class);
		sc.setAttribute("=unitId", unitId);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	@RequestMapping(value = "/searchUnit", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchUnit(@RequestBody(required = false) UnitForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(UnitDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	

}
