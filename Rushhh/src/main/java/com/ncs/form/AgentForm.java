package com.ncs.form;

import java.util.Date;
import java.util.jar.Attributes.Name;

import com.ncs.dto.AgentDTO;
import com.ncs.dto.CardTypeDTO;
import com.ncs.dto.ProductDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class AgentForm extends BaseForm {

	private String agentName;
	private String emailId;
	private String establishedDate;
	private String workOn;
	private String workingDays;
	private String meetingTime;
	private String totalProperty;
	private String aboutUs;

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(String totalProperty) {
		this.totalProperty = totalProperty;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWorkOn() {
		return workOn;
	}

	public void setWorkOn(String workOn) {
		this.workOn = workOn;
	}

	public String getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	@Override
	public BaseDTO makeDto() {
		AgentDTO agentDTO = new AgentDTO();
		super.makeDto(agentDTO);
		agentDTO.setAgentName(agentName);
		agentDTO.setEmailId(emailId);
		agentDTO.setEstablishedDate(DataUtil.convertDateFormat(establishedDate));
		agentDTO.setWorkOn(workOn);
		agentDTO.setWorkingDays(DataUtil.convertDateFormat(workingDays));
		agentDTO.setMeetingTime(meetingTime);
		agentDTO.setTotalProperty(totalProperty);
		agentDTO.setAboutUs(aboutUs);
		return agentDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		AgentDTO agentDTO = (AgentDTO) dto;
		agentName = agentDTO.getAgentName();
		emailId = agentDTO.getEmailId();
		establishedDate = DataUtil.convertDateToString(agentDTO.getEstablishedDate());
		workOn = agentDTO.getWorkOn();
		workingDays = DataUtil.convertDateToString(agentDTO.getWorkingDays());
		meetingTime = agentDTO.getMeetingTime();
		totalProperty = agentDTO.getTotalProperty();
		aboutUs = agentDTO.getAboutUs();

		super.populateCommon(agentDTO);

	}

}
