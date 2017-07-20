package com.ncs.form;

import com.ncs.dto.AccountMasterDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class AccountMasterForm extends BaseForm {

	private long companyId;
	private String companyName;
	private long userId;
	private String userName;
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

	@Override
	public BaseDTO makeDto() {
		AccountMasterDTO dto = new AccountMasterDTO();
		super.makeDto(dto);
		dto.setCompanyId(companyId);
		dto.setCompanyName(companyName);
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setBalance(balance);
		return dto;
	}

	@Override
	public void populate(BaseDTO dto) {
		AccountMasterDTO accountMasterDTO = (AccountMasterDTO) dto;
		companyId = accountMasterDTO.getCompanyId();
		companyName = accountMasterDTO.getCompanyName();
		userId = accountMasterDTO.getUserId();
		userName = accountMasterDTO.getUserName();
		balance = accountMasterDTO.getBalance();
		super.populateCommon(accountMasterDTO);
	}

}