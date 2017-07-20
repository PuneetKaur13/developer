package com.ncs.form;

import com.ncs.dto.NonPreferredSupplierDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class NonPreferredSupplierForm extends BaseForm {
	
	private String userName;
	private long userId;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		NonPreferredSupplierDTO pdto = new NonPreferredSupplierDTO();
		super.makeDto(pdto);
		pdto.setUserId(userId);
		pdto.setUserName(userName);
		return pdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		NonPreferredSupplierDTO pdto = (NonPreferredSupplierDTO) dto;
		userId=pdto.getUserId();
		userName=pdto.getUserName();
		super.populateCommon(dto);
	}
}
