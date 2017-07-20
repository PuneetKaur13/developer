package com.ncs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "SELL_PROPERTY")
public class SellPropertyDTO extends BaseDTO{
	@Column(name = "PROPERTY_NAME", length = 255)
	private String propertyName;
	@Column(name = "AREA_SQ_FEET")
	private Double areaSqFeet;
	@Column(name = "STATE_ID")
	private Long stateId;
	@Column(name = "STATE_NAME", length =255)
	private String stateName;
	@Column(name = "CITY_ID")
	private Long cityId;
	@Column(name = "CITY_NAME", length = 255)
	private String cityName;
	@Column(name = "ADDRESS", length = 255)
	private String address;
	@Column(name = "PINCODE")
	private Long pincode;
	@Column(name = "STATUS", length = 255)
	private String status;
	@Column(name = "PROPERTY_PRICE")
	private Double propertyPrice;
	@Column(name = "PRICE_PER_SQ_FEET")
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
	public String getValue() {
		// TODO Auto-generated method stub
		return cityName;
	}
}
