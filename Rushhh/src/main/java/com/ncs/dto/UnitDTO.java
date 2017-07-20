


package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "UNIT")
public class UnitDTO extends BaseDTO implements Serializable {
	
	
	@Column(name = "UNIT_NAME", length = 50)
	private String unitName;
	
	
	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("unitName", unitName);
		return uniqueAttributes;
	}
	
	@Override
	public String getValue() {
		return unitName;
	}
}
