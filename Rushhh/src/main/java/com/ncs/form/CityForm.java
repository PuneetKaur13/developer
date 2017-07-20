package com.ncs.form;

import com.ncs.dto.CityDTO;
import com.ncs.dto.StateDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class CityForm extends BaseForm {

	private Long stateId ;
	private String stateName ;
	private String cityName;
	
	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public BaseDTO makeDto() {
		CityDTO cityDTO = new CityDTO();
		super.makeDto(cityDTO);
		cityDTO.setStateId(stateId);
		cityDTO.setStateName(stateName);
		cityDTO.setCityName(cityName);
		return cityDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		CityDTO cityDTO = (CityDTO) dto;
		stateId=cityDTO.getStateId();
		stateName=cityDTO.getStateName();
	    cityName=cityDTO.getCityName();
		super.populateCommon(dto);
	}
}
