package com.ncs.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name="AGENT")
public class AgentDTO  extends BaseDTO implements Serializable
{
	@Column(name = "AGENT_NAME", length = 50)
	private String agentName;
	
	@Column(name = "EMAIL_ID", length = 50)
	private String emailId;
	
	@Column(name = "ESTABLISHED_DATE", length = 50)
	private Date establishedDate;
	
	@Column(name = "WORK_ON", length = 50)
	private String workOn;
	
	@Column(name = "WORKING_DAYS", length = 50)
	private Date  workingDays;
	
	
	@Column(name = "MEETING_TIME", length = 50)
	private String meetingTime;
	
	@Column(name = "TOTAL_PROPERTY", length = 200)
	private String totalProperty;
	
	@Column(name = "ABOUT_US", length = 50)
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

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getWorkOn() {
		return workOn;
	}

	public void setWorkOn(String workOn) {
		this.workOn = workOn;
	}

	public Date getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Date workingDays) {
		this.workingDays = workingDays;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
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
}
