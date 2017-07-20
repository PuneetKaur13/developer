package com.ncs.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ncs.dto.CompanyDTO;
import com.ncs.dto.SystemSettingDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.CompanyForm;
import com.ncs.form.SystemSettingForm;
import com.ncs.services.CompanyServiceI;
import com.ncs.services.SystemSettingServiceI;
import com.ncs.utill.PropertyReader;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/SystemSetting")
public class SystemSettingCtl extends BaseCtl<SystemSettingForm> {

	private static Logger log = Logger.getLogger(SystemSettingCtl.class);

	@Override
	@Autowired
	@Qualifier("systemSettingService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	@Autowired
	private SystemSettingServiceI systemSettingService;

	@RequestMapping(value = "/addNew", method = RequestMethod.GET)
	public NcsResponseData displayAdd() {
		return new NcsResponseData();
	}
	
	public SearchCriteria getSearchCriteria(SystemSettingForm form) {
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SystemSettingDTO.class);
		return sc;
	};
	
	@RequestMapping(value = "/searchByCf", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData search(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();

		SystemSettingForm form=new SystemSettingForm();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(SystemSettingDTO.class);
		List list = service.find(sc, ctx);
		SystemSettingDTO dto = new SystemSettingDTO();
		if (list != null && list.size() > 0) {
			dto = (SystemSettingDTO) list.get(0);
		}
		form.populate(dto);
		ncsResponseData.setForm(form);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}
	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public NcsResponseData uploadFileHandler(@RequestParam("form") String data, HttpServletRequest request, HttpSession session) {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			SystemSettingForm form = new ObjectMapper().readValue(data, SystemSettingForm.class);
			SystemSettingDTO dto = (SystemSettingDTO) form.makeDto();
			
			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				service.update(dto, null);
			} else {
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				service.add(dto, null);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage("Record has been saved successfully.");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

}
