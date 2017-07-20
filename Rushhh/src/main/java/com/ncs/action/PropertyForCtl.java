
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
import com.ncs.dto.PropertyForDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.PropertyForForm;
import com.ncs.services.PropertyForServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;

@RestController
@RequestMapping(value = "rest/PropertyFor")
public class PropertyForCtl extends BaseCtl<PropertyForForm> {

	private static Logger log = Logger.getLogger(PropertyForCtl.class);

	@Override
	@Autowired
	@Qualifier("propertyForService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	@Autowired
	private PropertyForServiceI propertyForServiceI;

	public SearchCriteria getSearchCriteria(PropertyForForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyForDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getPropertyForName())) {
			sc.setAttribute("propertyForName", form.getPropertyForName());
		}

		return sc;
	};

	@RequestMapping(value = "/searchPropertyForDashBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchPropertyForDashBoard(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyForDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchPropertyFor/{propertyForId}", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchProperty(@PathVariable long propertyForId, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(CityDTO.class); /**/
		sc.setAttribute("=propertyForId", propertyForId);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

	@RequestMapping(value = "/searchPropertyFor", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchPropertyFor(@RequestBody(required = false) PropertyForForm form, HttpSession session)
			throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyForDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

}
