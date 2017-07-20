package com.ncs.form;

import com.ncs.dto.StateDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class StateForm extends BaseForm {


	private String stateName;
	private String shortName;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public BaseDTO makeDto() {
		StateDTO stateDTO = new StateDTO();
		super.makeDto(stateDTO);
	
		stateDTO.setStateName(stateName);
		stateDTO.setShortName(shortName);
		return stateDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		StateDTO stateDTO = (StateDTO) dto;
		stateName=stateDTO.getStateName();
		shortName=stateDTO.getShortName();
		super.populateCommon(dto);
	}
}
