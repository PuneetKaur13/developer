package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "ORZANIZATION")
public class OrganizationDTO  extends BaseDTO implements Serializable{
	
	
	@Column(name = "ORZANIZATION_NAME", length = 50)
	private String orzanizationName;

	@Column(name = "ORZANIZATION_ADDRESS", length = 250)
	private String orzanizationAddress;

	public String getOrzanizationName() {
		return orzanizationName;
	}

	public void setOrzanizationName(String orzanizationName) {
		this.orzanizationName = orzanizationName;
	}

	public String getOrzanizationAddress() {
		return orzanizationAddress;
	}

	public void setOrzanizationAddress(String orzanizationAddress) {
		this.orzanizationAddress = orzanizationAddress;
	}
	
	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("orzanizationName", orzanizationName);
		return uniqueAttributes;
	}
	
}
