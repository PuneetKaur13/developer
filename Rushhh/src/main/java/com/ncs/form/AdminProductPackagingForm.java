package com.ncs.form;

import com.ncs.dto.AdminProductPackagingDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class AdminProductPackagingForm extends BaseForm {

	private Long adminProductId;
	private String adminProductName;
	private String packaging;

	public Long getAdminProductId() {
		return adminProductId;
	}

	public void setAdminProductId(Long adminProductId) {
		this.adminProductId = adminProductId;
	}

	public String getAdminProductName() {
		return adminProductName;
	}

	public void setAdminProductName(String adminProductName) {
		this.adminProductName = adminProductName;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	@Override
	public BaseDTO makeDto() {
		AdminProductPackagingDTO admintproductpackagingdto = new AdminProductPackagingDTO();
		super.makeDto(admintproductpackagingdto);
		admintproductpackagingdto.setPackaging(packaging);
		admintproductpackagingdto.setAdminProductId(adminProductId);
		admintproductpackagingdto.setAdminProductName(adminProductName);
		return admintproductpackagingdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		AdminProductPackagingDTO admintproductpackagingdto = (AdminProductPackagingDTO) dto;
		adminProductId = admintproductpackagingdto.getAdminProductId();
		adminProductName = admintproductpackagingdto.getAdminProductName();
		packaging = admintproductpackagingdto.getPackaging();
		super.populateCommon(dto);
	}
}
