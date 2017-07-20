package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.SellPropertyDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class SellPropertyForm extends BaseForm{
	private String propertyName;
	private Double areaSqFeet;
	private Long stateId;
	private String stateName;
	private Long cityId;
	private String cityName;
	private String address;
	private Long pincode;
	private String status;
	private Double propertyPrice;
	private Double pricePerSqFeet;

public String getPropertyName() {
		return propertyName;
	}


	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}


	public Double getAreaSqFeet() {
		return areaSqFeet;
	}


	public void setAreaSqFeet(Double areaSqFeet) {
		this.areaSqFeet = areaSqFeet;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getPincode() {
		return pincode;
	}


	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	


public Double getPropertyPrice() {
		return propertyPrice;
	}


	public void setPropertyPrice(Double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}


	public Double getPricePerSqFeet() {
		return pricePerSqFeet;
	}


	public void setPricePerSqFeet(Double pricePerSqFeet) {
		this.pricePerSqFeet = pricePerSqFeet;
	}


@Override
public BaseDTO makeDto() {
	SellPropertyDTO sellPropertyDTO = new SellPropertyDTO();
	super.makeDto(sellPropertyDTO);
	sellPropertyDTO.setPropertyName(propertyName);
	sellPropertyDTO.setAreaSqFeet(areaSqFeet);
	sellPropertyDTO.setStateId(stateId);
	sellPropertyDTO.setStateName(stateName);
	sellPropertyDTO.setCityId(cityId);
	sellPropertyDTO.setCityName(cityName);
	sellPropertyDTO.setAddress(address);
	sellPropertyDTO.setPincode(pincode);
	sellPropertyDTO.setStatus(status);
	sellPropertyDTO.setPropertyPrice(propertyPrice);
	sellPropertyDTO.setPricePerSqFeet(pricePerSqFeet);
		return sellPropertyDTO;
	}


@Override
public void populate(BaseDTO dto) {
	SellPropertyDTO sellPropertyDTO = (SellPropertyDTO) dto;
	propertyName = sellPropertyDTO.getPropertyName();
	areaSqFeet = sellPropertyDTO.getAreaSqFeet();
	stateId = sellPropertyDTO.getStateId();
	stateName = sellPropertyDTO.getStateName();
	cityId = sellPropertyDTO.getCityId();
	cityName = sellPropertyDTO.getCityName();
	address = sellPropertyDTO.getAddress();
	pincode = sellPropertyDTO.getPincode();
	status = sellPropertyDTO.getStatus();
	propertyPrice = sellPropertyDTO.getPropertyPrice();
	pricePerSqFeet = sellPropertyDTO.getPricePerSqFeet();
	super.populateCommon(dto);
	}
}
