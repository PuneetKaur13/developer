package com.ncs.form;

import java.sql.Timestamp;

import com.ncs.dto.TransactionMasterDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class TransactionMasterForm extends BaseForm {

	private long companyId;
	private String companyName;
	private long userId;
	private String userName;
	private double amount;
	private String type;
	private String timestamp;
	private String description;
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

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	@Override
	public BaseDTO makeDto() {
		TransactionMasterDTO dto = new TransactionMasterDTO();
		super.makeDto(dto);
		dto.setCompanyId(companyId);
		dto.setCompanyName(companyName);
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setAmount(amount);
		dto.setType(type);
		dto.setTimestamp(new Timestamp(DataUtil.convertDateFormat(timestamp).getTime()));
		dto.setDescription(description);
		dto.setPoints(points);
		return dto;
	}

	@Override
	public void populate(BaseDTO dto) {
		TransactionMasterDTO masterDTO = (TransactionMasterDTO) dto;
		companyId = masterDTO.getCompanyId();
		companyName = masterDTO.getCompanyName();
		userId = masterDTO.getUserId();
		userName = masterDTO.getUserName();
		amount = masterDTO.getAmount();
		type = masterDTO.getType();
		timestamp = DataUtil.convertDateToString(masterDTO.getTimestamp());
		description = masterDTO.getDescription();
		points=masterDTO.getPoints();
		super.populateCommon(masterDTO);
	}

}