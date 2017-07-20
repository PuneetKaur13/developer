package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "STATE")
public class StateDTO extends BaseDTO implements Serializable {
	
	
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "SHORT_NAME", length = 50)
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
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("stateName", stateName);
		return uniqueAttributes;
	}
	
	@Override
	public String getValue() {
		return stateName;
	}
}
