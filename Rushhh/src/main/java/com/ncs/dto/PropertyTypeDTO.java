package com.ncs.dto;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "PROPERTY_TYPE")
public class PropertyTypeDTO extends BaseDTO implements Serializable {
	
	
	@Column(name = "PROPERTY_TYPE", length = 50)
	private String propertyTypeName;
	
	
	

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("propertyTypeName", propertyTypeName);
		return uniqueAttributes;
	}
	
	@Override
	public String getValue() {
		return propertyTypeName;
	}
}
