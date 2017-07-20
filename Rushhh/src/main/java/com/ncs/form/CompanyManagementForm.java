package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.CompanyManagementDTO;
import com.ncs.dto.OrganizationDTO;
import com.nenosystems.common.dto.BaseDTO;

import com.nenosystems.common.form.BaseForm;

public class CompanyManagementForm extends BaseForm {

	private String companyName;
	private String companyAddress;
	private String status;
	

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

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Override
	public BaseDTO makeDto() {
		CompanyManagementDTO cmdto = new CompanyManagementDTO();
		super.makeDto(cmdto);
		cmdto.setCompanyName(companyName);
		cmdto.setCompanyAddress(companyAddress);
		cmdto.setStatus(status);
		return cmdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		CompanyManagementDTO cmdto = (CompanyManagementDTO) dto;
		companyName=cmdto.getCompanyName();
		companyAddress=cmdto.getCompanyAddress();
		status=cmdto.getStatus();
		
		super.populateCommon(dto);
	}

}
