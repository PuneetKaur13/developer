package com.ncs.dto;

import javax.persistence.Column;
import com.nenosystems.common.dto.BaseDTO;

public class AddressDTO extends BaseDTO {

	@Column(name = "COUNTRY_ID", length = 15)
	private long countryId;
	@Column(name = "COUNTRY_NAME", length = 50)
	private String countryName;
	@Column(name = "STATE_ID", length = 50)
	private long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "CITY_ID", length = 50)
	private long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "LOCALITY", length = 50)
	private String locality;
	@Column(name = "ZIPCODE", length = 50)
	private String zipcode;
	@Column(name = "ADDRESS_LINE_1", length = 50)
	private String addressLine1;
	@Column(name = "ADDRESS_LINE_2", length = 50)
	private String addressLine2;
	@Column(name = "LANDMARK", length = 50)
	private String landMark;

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	@Override
	public String toString() {
		return "AddressDTO [countryId=" + countryId + ", countryName=" + countryName + ", stateId=" + stateId
				+ ", stateName=" + stateName + ", cityId=" + cityId + ", cityName=" + cityName + ", locality="
				+ locality + ", zipcode=" + zipcode + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", landMark=" + landMark + "]";
	}

}