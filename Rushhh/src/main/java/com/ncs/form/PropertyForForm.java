package com.ncs.form;

import com.ncs.dto.PropertyForDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class PropertyForForm extends BaseForm {

	private String propertyForName;

	public String getPropertyForName() {
		return propertyForName;
	}

	public void setPropertyForName(String propertyForName) {
		this.propertyForName = propertyForName;
	}

	@Override
	public BaseDTO makeDto() {
		PropertyForDTO propertyForDTO = new PropertyForDTO();
		super.makeDto(propertyForDTO);

		propertyForDTO.setPropertyForName(propertyForName);
		return propertyForDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		PropertyForDTO propertyForDTO = (PropertyForDTO) dto;
		propertyForName = propertyForDTO.getPropertyForName();
		super.populateCommon(dto);
	}
}
