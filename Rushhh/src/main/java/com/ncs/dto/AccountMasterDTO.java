package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "ACCOUNT_MASTER")
public class AccountMasterDTO extends BaseDTO implements Serializable {

	@Column(name = "COMPANY_ID", length = 15)
	private long companyId;
	@Column(name = "COMPANY_NAME", length = 150)
	private String companyName;
	@Column(name = "USER_ID", length = 15)
	private long userId;
	@Column(name = "USER_NAME", length = 100)
	private String userName;
	@Column(name = "BALANCE", length = 15)
	private double balance;

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
