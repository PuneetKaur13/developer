package com.ncs.form;

import com.ncs.dto.AdminDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class AdminForm extends BaseForm {

	private String adminName;

	private String adminDescription;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminDescription() {
		return adminDescription;
	}

	public void setAdminDescription(String adminDescription) {
		this.adminDescription = adminDescription;
	}

	@Override
	public BaseDTO makeDto() {
		AdminDTO adminDTO = new AdminDTO();
		super.makeDto(adminDTO);
		adminDTO.setAdminName(adminName);
		adminDTO.setAdminDescription(adminDescription);
		return adminDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		AdminDTO adminDTO = (AdminDTO) dto;
		adminName = adminDTO.getAdminName();
		adminDescription = adminDTO.getAdminDescription();
		super.populateCommon(dto);
	}

}
