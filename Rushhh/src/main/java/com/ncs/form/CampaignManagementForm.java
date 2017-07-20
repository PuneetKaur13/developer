package com.ncs.form;

import java.util.Date;

import javax.persistence.Column;

import com.ncs.dto.CampaignManagementDTO;
import com.ncs.dto.CompanyManagementDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class CampaignManagementForm extends BaseForm {

	private String companyName;
	private String status;
	private String campaignName;
	private String description;
	private String startDate;
	private String endDate;
	private Long companyId;

	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	@Override
	public BaseDTO makeDto() {
		CampaignManagementDTO cmdto = new CampaignManagementDTO();
		super.makeDto(cmdto);
		cmdto.setCompanyName(companyName);
		cmdto.setCompanyId(companyId);
		cmdto.setStatus(status);
		cmdto.setCampaignName(campaignName);
		cmdto.setStartDate(DataUtil.convertDateFormat(startDate));
		cmdto.setEndDate(DataUtil.convertDateFormat(endDate));
		cmdto.setDescription(description);
		
		return cmdto;
	}
	@Override
	public void populate(BaseDTO dto) {
		CampaignManagementDTO cmdto = (CampaignManagementDTO) dto;
		companyName=cmdto.getCompanyName();
		startDate = DataUtil.convertDateToString(cmdto.getStartDate());
		endDate = DataUtil.convertDateToString(cmdto.getEndDate());
		status=cmdto.getStatus();
		campaignName=cmdto.getCampaignName();
		description=cmdto.getDescription();
		companyId=cmdto.getCompanyId();
		super.populateCommon(dto);
	}

}
