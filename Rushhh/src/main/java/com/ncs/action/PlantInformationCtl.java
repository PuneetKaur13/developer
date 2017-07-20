package com.ncs.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ncs.dto.CompanyDTO;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.ncs.dto.PlantInformationDTO;
import com.ncs.dto.SystemSettingDTO;
import com.ncs.dto.UserDTO;
import com.ncs.form.BuyerBiddingForm;
import com.ncs.form.CompanyForm;
import com.ncs.form.PlantInformationForm;
import com.ncs.form.SystemSettingForm;
import com.ncs.form.UserForm;
import com.ncs.utill.PropertyReader;
import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.action.NcsResponseData;
import com.nenosystems.common.dto.SearchCriteria;
import com.nenosystems.common.dto.UserContext;
import com.nenosystems.common.exception.UnauthorizedAccessException;
import com.nenosystems.common.exception.UserNotFoundException;
import com.nenosystems.common.services.BaseServiceI;

@RestController
@RequestMapping(value = "rest/PlantInformation")
public class PlantInformationCtl extends BaseCtl<PlantInformationForm> {
	private static Logger logger = Logger.getLogger(PlantInformationCtl.class);

	@Override
	@Autowired
	@Qualifier("PlantInformationService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}



	@RequestMapping(value = "/searchByUser", method = { RequestMethod.GET, RequestMethod.POST })
	public NcsResponseData searchByUser(HttpSession session) throws Exception {
		NcsResponseData ncsResponseData = new NcsResponseData();
		UserContext ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		PlantInformationForm form = new PlantInformationForm();
		SearchCriteria sc = new SearchCriteria();
		sc.setDto(PlantInformationDTO.class);
		sc.setAttribute("=userId", userDTO.getId());
		List list = service.find(sc, ctx);
		PlantInformationDTO dto = new PlantInformationDTO();
		if (list != null && list.size() > 0) {
			dto = (PlantInformationDTO) list.get(0);
		}
		form.populate(dto);
		ncsResponseData.setForm(form);
		ncsResponseData.setSuccess(true);
		ncsResponseData.setList(list);
		return ncsResponseData;
	}

/*	@RequestMapping(value = "/updatePlantInfo", method = RequestMethod.POST)
	public NcsResponseData updatePlantInfo(@RequestBody PlantInformationForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
		
			PlantInformationDTO dto = (PlantInformationDTO) form.makeDto();
			dto.setUserId(userDTO.getId());
			if (ctx.getCreatedBy() != null && ctx.getModifiedBy()!=null) {
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				service.update(dto, ctx);
			} 
			if(dto.getGroupId()==null){
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				
				service.add(dto, ctx);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage(
					"Congrats!...Your Plant Information is added successfully...This will help you in Ranking System");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}
	*/

	@RequestMapping(value = "/updatePlantInfo", method = RequestMethod.POST)
	public NcsResponseData updatePlantInfo(@RequestBody PlantInformationForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			PlantInformationDTO dto = (PlantInformationDTO) form.makeDto();
	
			if (userDTO.getId()!= null && userDTO.getId()> 0) {
				dto.setUserId(userDTO.getId());
				dto.setModifiedBy(ctx.getModifiedBy());
				System.out.println(ctx.getCreatedBy());
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				System.out.println("asdnajkdkjs");
				System.out.println("asdnajkdkjsaksjdjadd");
				service.update(dto, ctx);
				System.out.println("asdnajkdkjs");
				System.out.println("asdnajkdkjsaksjdjadd");
			} else {
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				
				service.add(dto, ctx);
			}
			
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
			ncsResponseData.setMessage(
					"Congrats!...Your Plant Information is added successfully...This will help you in Ranking System");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NcsResponseData submitAdd(@RequestBody PlantInformationForm form, HttpSession session) throws Exception {
		ncsResponseData = new NcsResponseData();
		ctx = getUserContext(session);
		UserDTO userDTO = (UserDTO) ctx.getBaseDTO();
		try {
			PlantInformationDTO dto = (PlantInformationDTO) form.makeDto();
			System.out.println("asdnajkdkjs");
			System.out.println("asdnajkdkjsaksjdjadd");
			dto.setUserId(userDTO.getId());
			dto.setGroupId(userDTO.getGroupId());
			dto.setGroupIdString(userDTO.getGroupIdString());
			if (dto.getId() != null && dto.getId() > 0) {
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setGroupId(userDTO.getGroupId());
				dto.setGroupIdString(userDTO.getGroupIdString());
				System.out.println("asdnajkdkjs");
				System.out.println("asdnajkdkjsaksjdjadd");
				service.update(dto, ctx);
				
		
			} else {
				dto.setCreatedBy(ctx.getCreatedBy());
				dto.setModifiedBy(ctx.getModifiedBy());
				dto.setUserId(userDTO.getId());
				dto.setGroupId(userDTO.getGroupId());
				service.add(dto, ctx);
			}
			ncsResponseData.setForm(form);
			ncsResponseData.setSuccess(true);
		
			ncsResponseData.setMessage(
					"Congrats!...Your company has been registred.You are the Admin  of this company and all other user of this company will be under you...");
		} catch (Exception e) {
			ncsResponseData.setSuccess(false);
			ncsResponseData.setMessage(e.getMessage());
		}
		return ncsResponseData;
	}
	
	

}
