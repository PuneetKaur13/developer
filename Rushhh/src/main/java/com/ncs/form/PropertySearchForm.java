package com.ncs.form;

import com.ncs.dto.AgentDTO;
import com.ncs.dto.PropertySearchDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class PropertySearchForm extends BaseForm {

	private String propertyFor;
	private String propertyType;
	private String state;
	private String city;
	private Double areaSqFeet;
	private Double minPrice;
	private Double maxPrice;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

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

	public String getPropertyFor() {
		return propertyFor;
	}

	public void setPropertyFor(String propertyFor) {
		this.propertyFor = propertyFor;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getAreaSqFeet() {
		return areaSqFeet;
	}

	public void setAreaSqFeet(Double areaSqFeet) {
		this.areaSqFeet = areaSqFeet;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public BaseDTO makeDto() {
		PropertySearchDTO propertySearchDTO = new PropertySearchDTO();
		super.makeDto(propertySearchDTO);

		propertySearchDTO.setPropertyFor(propertyFor);
		propertySearchDTO.setPropertyType(propertyType);
		propertySearchDTO.setState(state);
		propertySearchDTO.setCity(city);
		propertySearchDTO.setAreaSqFeet(areaSqFeet);
		propertySearchDTO.setMinPrice(minPrice);
		propertySearchDTO.setMaxPrice(maxPrice);
		propertySearchDTO.setCityId(cityId);
		propertySearchDTO.setCityName(cityName);
		propertySearchDTO.setStateId(stateId);
		propertySearchDTO.setStateName(stateName);

		return propertySearchDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		PropertySearchDTO propertySearchDTO = (PropertySearchDTO) dto;
		propertyFor = propertySearchDTO.getPropertyFor();
		propertyType = propertySearchDTO.getPropertyType();
		state = propertySearchDTO.getState();
		city = propertySearchDTO.getCity();
		areaSqFeet = propertySearchDTO.getAreaSqFeet();
		minPrice = propertySearchDTO.getMinPrice();
		maxPrice = propertySearchDTO.getMaxPrice();
		stateId = propertySearchDTO.getStateId();
		stateName = propertySearchDTO.getStateName();
		cityId = propertySearchDTO.getCityId();
		cityName = propertySearchDTO.getCityName();

		super.populateCommon(propertySearchDTO);

	}

}
