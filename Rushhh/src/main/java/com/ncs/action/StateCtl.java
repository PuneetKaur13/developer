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
import com.ncs.dto.StateDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CityForm;
import com.ncs.form.StateForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.StateServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/State")
public class StateCtl extends BaseCtl<StateForm> {

	private static Logger log = Logger.getLogger(StateCtl.class);

	@Override
	@Autowired
	@Qualifier("stateService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	@Autowired
	private StateServiceI stateServiceI;
	
	public SearchCriteria getSearchCriteria(StateForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(StateDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getStateName())) {
			sc.setAttribute("stateName", form.getStateName());
		}
		if (!DataValidator.isNull(form.getShortName())) 	{
			sc.setAttribute("shortName", form.getShortName());
		}
		return sc;
	};
	@RequestMapping(value = "/searchStateDashBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchStateDashBoard(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(StateDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}


	@RequestMapping(value = "/searchState/{stateId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchState(@PathVariable long stateId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CityDTO.class); /*UnitsDTO Which Will Come*/
		sc.setAttribute("=stateId", stateId);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	@RequestMapping(value = "/searchState", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchState(@RequestBody(required = false) StateForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(StateDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
}