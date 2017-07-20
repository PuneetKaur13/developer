  
 
 package com.ncs.form;

 import com.ncs.dto.UnitDTO;
import com.nenosystems.common.dto.BaseDTO;
 import com.nenosystems.common.form.BaseForm;

 public class UnitForm extends BaseForm {


 	private String unitName;
 	
 	
   public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public BaseDTO makeDto() {
		UnitDTO unitDTO = new UnitDTO();
		super.makeDto(unitDTO);
        unitDTO.setUnitName(unitName);
		return unitDTO;
	}
@Override
	public void populate(BaseDTO dto) {
		UnitDTO unitDTO = (UnitDTO) dto;
		unitName=unitDTO.getUnitName();
		
		super.populateCommon(dto);
 	}
 }
