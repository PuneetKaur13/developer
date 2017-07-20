package com.ncs.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "BANNER_MANAGEMENT")
public class BannerManagementDTO  extends BaseDTO implements Serializable{
	
	
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	
	@Column(name = "CAMPAIGN_ID", length = 50)
	private Long campaignId;
	
	@Column(name = "COMPANY_ID", length = 50)
	private Long companyId;
	
	@Column(name = "STATUS", length = 250)
	private String status;

	@Column(name = "CAMPAIGN_NAME", length = 50)
	private String campaignName;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	
	@Column(name = "BANNER_NAME", length = 50)
	private String bannerName;
	
	@Column(name = "URL", length = 50)
	private String url;
	
	
	public Long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	
}
