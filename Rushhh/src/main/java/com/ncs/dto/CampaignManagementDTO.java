package com.ncs.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.util.JsonDateSerializer;

@Entity
@Table(name = "CAMPAIGN_MANAGEMENT")
public class CampaignManagementDTO  extends BaseDTO implements Serializable{
	
	
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	
	@Column(name = "COMPANY_ID", length = 50)
	private Long companyId;
	
	@Column(name = "STATUS", length = 250)
	private String status;

	@Column(name = "CAMPAIGN_NAME", length = 50)
	private String campaignName;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "START_DATE", length = 50)
	private Date startDate;
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "END_DATE", length = 50)
	private Date endDate;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return campaignName;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("campaignName", campaignName);
		return uniqueAttributes;
	}
	
}
