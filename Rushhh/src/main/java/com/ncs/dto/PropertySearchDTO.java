package com.ncs.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = " PROPERTY_SEARCH")
public class PropertySearchDTO extends BaseDTO implements Serializable {

	@Column(name = "PROPERTY_FOR", length = 100)
	private String propertyFor;
	@Column(name = "PROPERTY_TYPE", length = 100)
	private String propertyType;
	@Column(name = "STATE", length = 100)
	private String state;
	@Column(name = "CITY", length = 100)
	private String city;
	@Column(name = "CITY_ID", length = 50)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_ID", length = 50)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;

	@Column(name = "AREA_SQ_FEET", length = 255)
	private Double areaSqFeet;

	@Column(name = "MIN_PRICE", length = 100)
	private Double minPrice;

	@Column(name = "MAX_PRICE", length = 100)
	private Double maxPrice;

	
	
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

}
