package com.ncs.form;

import java.util.Date;

import javax.persistence.Column;

import com.ncs.dto.BannerManagementDTO;
import com.ncs.dto.CampaignManagementDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class BannerManagementForm extends BaseForm {

	private String companyName;
	
	private String status;
	private String campaignName;
	private String description;
	private String bannerName;
	private String url;
	private Long campaignId;
	private Long companyId;

	
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

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public BaseDTO makeDto() {
		BannerManagementDTO bmdto = new BannerManagementDTO();
		super.makeDto(bmdto);
		bmdto.setCompanyName(companyName);
		bmdto.setStatus(status);
		bmdto.setCampaignName(campaignName);
		bmdto.setDescription(description);
		bmdto.setBannerName(bannerName);
		bmdto.setUrl(url);
		bmdto.setCampaignId(campaignId);
		bmdto.setCompanyId(companyId);
		return bmdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		BannerManagementDTO bmdto = (BannerManagementDTO) dto;
		companyName=bmdto.getCompanyName();
		status=bmdto.getStatus();
		campaignName=bmdto.getCampaignName();
		description=bmdto.getDescription();
		url=bmdto.getUrl();
		campaignId=bmdto.getCampaignId();
		companyId=bmdto.getCompanyId();
		
		super.populateCommon(dto);
	}

}
