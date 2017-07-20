


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
import com.ncs.dto.PropertyDTO;
import com.ncs.dto.PropertyTypeDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CityForm;
import com.ncs.form.PropertyTypeForm;
import com.ncs.services.CityServiceI;
import com.ncs.services.PropertyTypeServiceI;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;
import com.nenosystems.common.util.DataValidator;


@RestController
@RequestMapping(value = "rest/PropertyType")
public class PropertyTypeCtl extends BaseCtl<PropertyTypeForm> {

	private static Logger log = Logger.getLogger(PropertyTypeCtl.class);

	@Override
	@Autowired
	@Qualifier("propertyTypeService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}

	 @Autowired
	private PropertyTypeServiceI propertyTypeServiceI;
	
	public SearchCriteria getSearchCriteria(PropertyTypeForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyTypeDTO.class);
		sc.setPagging(true);
		sc.setPage(form.getPageNo());
		sc.setNoOfRecords(form.getPageSize());
		if (!DataValidator.isNull(form.getPropertyTypeName())) {
			sc.setAttribute("propertyTypeName", form.getPropertyTypeName());
		}
		
		return sc;
	};
	

	 	@RequestMapping(value = "/searchPropertyTypeDashBoard", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchPropertyTypeDashBoard(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyTypeDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setForm(null);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

		@RequestMapping(value = "/searchPropertyType/{propertyTypeId}", method = { RequestMethod.GET, RequestMethod.POST })
		public NcsResponseData searchProperty(@PathVariable long propertyTypeId, HttpSession session) throws Exception {
			NcsResponseData ncsResponseData = new NcsResponseData();
			UserContext ctx = getUserContext(session);
			UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
			SearchCriteria sc = new SearchCriteria();
			sc.setDto(CityDTO.class); /**/ 
			sc.setAttribute("=propertyTypeId", propertyTypeId);
			List list = service.find(sc, ctx);
			ncsResponseData.setForm(null);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setList(list);
			return ncsResponseData;
		}
		
	
	@RequestMapping(value = "/searchPropertyType", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchPropertyType(@RequestBody(required = false) PropertyTypeForm form, HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PropertyTypeDTO.class);
		List list = service.find(sc, ctx);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	
	

}
