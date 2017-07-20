package com.ncs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;
@Entity
@Table(name = "NON_PREFERRED_SUPPLIER")
public class NonPreferredSupplierDTO extends BaseDTO {
	
	@Column(name = "USER_ID", length = 15)
	private long userId;

	@Column(name = "USER_NAME", length = 50)
	private String userName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
