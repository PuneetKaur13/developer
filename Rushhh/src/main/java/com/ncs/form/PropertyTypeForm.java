 


package com.ncs.form;

import com.ncs.dto.PropertyTypeDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class PropertyTypeForm  extends BaseForm {


	private String propertyTypeName;
	
	
	
	
	public String getPropertyTypeName() {
		return propertyTypeName;
	}
	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}
	@Override
	public BaseDTO makeDto() {
		PropertyTypeDTO propertyTypeDTO = new PropertyTypeDTO();
		super.makeDto(propertyTypeDTO);
		
	propertyTypeDTO.setPropertyTypeName(propertyTypeName);
	return propertyTypeDTO;
	}
@Override
	public void populate(BaseDTO dto) {
	PropertyTypeDTO propertyTypeDTO = (PropertyTypeDTO) dto;
	propertyTypeName=propertyTypeDTO.getPropertyTypeName();
		super.populateCommon(dto);
 	}
 }
