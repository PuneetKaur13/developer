package com.ncs.form;

import com.ncs.dto.CardTypeDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class CardTypeForm extends BaseForm {
	private String name;
	private Double points;
	private Double conversionFactor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	@Override
	public BaseDTO makeDto() {
		CardTypeDTO cardTypeDTO = new CardTypeDTO();
		super.makeDto(cardTypeDTO);
		cardTypeDTO.setId(id);
		cardTypeDTO.setName(name);
		cardTypeDTO.setPoints(points);
		cardTypeDTO.setConversionFactor(conversionFactor);
		return cardTypeDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		CardTypeDTO cardTypeDTO = (CardTypeDTO) dto;
		id = cardTypeDTO.getId();
		name = cardTypeDTO.getName();
		points = cardTypeDTO.getPoints();
		conversionFactor = cardTypeDTO.getConversionFactor();
		super.populateCommon(dto);
	}

	@Override
	public String toString() {
		return "CardTypeForm [id=" + id + ",name=" + name + ", points=" + points + ", conversionFactor="
				+ conversionFactor + "]";
	}

}
