 package com.ncs.form;

import com.ncs.dto.RoleDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class RoleForm extends BaseForm {

	public static final Long SUPER_ADMIN_ID = 1L;
	public static final String SUPER_ADMIN = "Super Admin";
	public static final Long USER_ROLE_ID = 2L;
	public static final String USER_ROLE = "User";
	public static final Long HR_ROLE_ID = 3L;
	public static final String HR_ROLE = "HR";
	public static final Long FINANCE_DEPT_ID = 4L;
	public static final String FINANCE_DEPT_ROLE = "Finance";
	public static final Long EMPOLOYEE_ID = 4L;
	public static final String EMPLOYEE_ROLE = "Employee";
	
	
	

	private String roleName;

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
	public BaseDTO makeDto() {
		RoleDTO roledto = new RoleDTO();
		super.makeDto(roledto);
		roledto.setRoleName(roleName);
		roledto.setRoleDescription(roleDescription);
		return roledto;
	}

	@Override
	public void populate(BaseDTO dto) {
		RoleDTO roledto = (RoleDTO) dto;
		roleName = roledto.getRoleName();
		roleDescription = roledto.getRoleDescription();
		super.populateCommon(dto);
	}

}
