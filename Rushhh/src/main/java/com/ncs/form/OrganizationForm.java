package com.ncs.form;

import com.ncs.dto.OrganizationDTO;
import com.nenosystems.common.dto.BaseDTO;

import com.nenosystems.common.form.BaseForm;

public class OrganizationForm extends BaseForm {

	private String organizationName;

	private String organizationAddress;
	
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	@Override
	public BaseDTO makeDto() {
		OrganizationDTO orgdto = new OrganizationDTO();
		super.makeDto(orgdto);
		orgdto.setOrzanizationName(organizationName);
		orgdto.setOrzanizationAddress(organizationAddress);
		return orgdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		OrganizationDTO orgdto = (OrganizationDTO) dto;
		organizationName =  orgdto.getOrzanizationName();
		organizationAddress =  orgdto.getOrzanizationAddress();
		super.populateCommon(dto);
	}

}
