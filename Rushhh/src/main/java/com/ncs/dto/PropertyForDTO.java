package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "PROPERTY_FOR")
public class PropertyForDTO extends BaseDTO implements Serializable {
	
	
	@Column(name = "PROPERTY_FOR", length = 50)
	private String propertyForName;
	
	
	

	public String getPropertyForName() {
		return propertyForName;
	}

	public void setPropertyForName(String propertyForName) {
		this.propertyForName = propertyForName;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("propertyForName", propertyForName);
		return uniqueAttributes;
	}
	
	@Override
	public String getValue() {
		return propertyForName;
	}
}
