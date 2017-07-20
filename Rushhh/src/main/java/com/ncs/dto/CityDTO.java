package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "CITY")
public class CityDTO extends BaseDTO implements Serializable {
	
	@Column(name = "STATE_ID", length = 50)
	private Long stateId ;
	
	@Column(name = "STATE_NAME", length = 50)
	private String stateName ;
		
	@Column(name = "CITY_NAME", length = 50)
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
	public String getValue() {
		return cityName;
	}

	
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("cityName", cityName);
		return uniqueAttributes;
	}
}
