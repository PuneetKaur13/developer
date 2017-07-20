package com.ncs.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "ROLE")
public class RoleDTO extends BaseDTO {
	@Column(name = "ROLE_NAME", length = 50)
	private String roleName;

	@Column(name = "ROLE_DESCRIPTION", length = 70)
	private String roleDescription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
	@Override
	public String getValue() {
		return roleName;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("roleName", roleName);
		return uniqueAttributes;
	}

}
