package com.ncs.dto;

import java.util.Set;

import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.dto.LicenseDTO;

public class UserContext extends BaseDTO {

	private String userId = null;
	private String userName = null;
	private UserDTO userDTO = null;
	private LicenseDTO licenseDTO = null;
	private Set<String> roles = null;
	private BaseDTO baseDTO = null;
	/**
	 * If multiple organization then user can only one organization to see data
	 */
	private String organizationIdString = null;

	public String getOrganizationIdString() {
		return organizationIdString;
	}

	public void setOrganizationIdString(String organizationIdString) {
		this.organizationIdString = organizationIdString;
	}

	public UserContext() {
	}

	public UserContext(UserDTO userDTO) {
		this.userDTO = userDTO;
		this.userId = userDTO.getLoginId();
		this.userName = userDTO.getFirstName() + " " + userDTO.getLastName();
		System.out.println("____________ user context ------------ " + userName);
		/*
		 * if (roles == null && userDTO != null) { roles = new
		 * HashSet<String>(); Iterator<UserRoleDTO> it =
		 * userDTO.getUserRoles().iterator(); while (it.hasNext()) {
		 * roles.add(it.next().getRoleName()); } }
		 */
	}

	public Set getRoles() {
		return roles;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public boolean hasRole(String role) {
		return roles.contains(role);
	}

	public boolean canAdd() {
		return canAdd(null);
	}

	public boolean canAdd(String module) {
		return true;
	}

	public boolean canView() {
		return canView(null);
	}

	public boolean canView(String module) {
		boolean flag = false;
		return flag;
	}

	public boolean canDelete() {
		return canDelete(null);
	}

	public boolean canDelete(String module) {
		boolean flag = false;
		return flag;
	}

	public boolean canUpdate() {
		return canUpdate(null);
	}

	public boolean canUpdate(String module) {
		boolean flag = false;
		return flag;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LicenseDTO getLicenseDTO() {
		return licenseDTO;
	}

	public void setLicenseDTO(LicenseDTO licenseDTO) {
		this.licenseDTO = licenseDTO;
	}

	public BaseDTO getBaseDTO() {
		return baseDTO;
	}

	public void setBaseDTO(BaseDTO baseDTO) {
		this.baseDTO = baseDTO;
	}

	@Override
	public String toString() {
		return "UserContext [userId=" + userId + ", userName=" + userName + ", userDTO=" + userDTO + ", licenseDTO="
				+ licenseDTO + ", roles=" + roles + ", baseDTO=" + baseDTO + ", organizationIdString="
				+ organizationIdString + "]";
	}

}
