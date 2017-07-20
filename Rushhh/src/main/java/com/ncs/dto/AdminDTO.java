package com.ncs.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "ADMIN_TABLE")
public class AdminDTO extends BaseDTO {

	@Column(name = "ADMIN_NAME", length = 50)
	private String adminName;

	@Column(name = "ADMIN_DESCRIPTION", length = 70)
	private String adminDescription;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminDescription() {
		return adminDescription;
	}

	public void setAdminDescription(String adminDescription) {
		this.adminDescription = adminDescription;
	}

	@Override
	public String getValue() {
		return adminName;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("adminName", adminName);
		return uniqueAttributes;
	}

}
