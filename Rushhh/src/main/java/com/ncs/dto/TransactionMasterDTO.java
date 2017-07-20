package com.ncs.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "TRANSACTION_MASTER")
public class TransactionMasterDTO extends BaseDTO implements Serializable {

	@Column(name = "COMPANY_ID", length = 15)
	private long companyId;
	@Column(name = "COMPANY_NAME", length = 150)
	private String companyName;
	@Column(name = "USER_ID", length = 15)
	private long userId;
	@Column(name = "USER_NAME", length = 100)
	private String userName;
	@Column(name = "AMOUNT", length = 15)
	private double amount;
	@Column(name = "TYPE", length = 100)
	private String type;
	@Column(name = "TIMESTAMP", length = 100)
	private Timestamp timestamp;
	@Column(name = "DESCRIPTION", length = 500)
	private String description;
	@Column(name = "POINTS", length = 500)
	private Long points;

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

	public double getAmount() {
		return amount;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
