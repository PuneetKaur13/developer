package com.ncs.form;

import java.util.Date;

import javax.persistence.Column;

import com.ncs.dto.UserCardManagementDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class UserCardManagementForm extends BaseForm {

	private String name;
	private String cardReferenceNo;
	private String chipNo;
	private String cardType;
	private Date dateOfIssue;
	private Date dateOfExpiry;
	private Long cardTypeId;
	private String cardTypeName;
	private Long userId;
	private String userName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardReferenceNo() {
		return cardReferenceNo;
	}

	public void setCardReferenceNo(String cardReferenceNo) {
		this.cardReferenceNo = cardReferenceNo;
	}

	public String getChipNo() {
		return chipNo;
	}

	public void setChipNo(String chipNo) {
		this.chipNo = chipNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public Long getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(Long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public BaseDTO makeDto() {
		UserCardManagementDTO userCardManagementDTO = new UserCardManagementDTO();
		super.makeDto(userCardManagementDTO);
		userCardManagementDTO.setName(name);
		userCardManagementDTO.setCardReferenceNo(cardReferenceNo);
		userCardManagementDTO.setChipNo(chipNo);
		userCardManagementDTO.setCardType(cardType);
		userCardManagementDTO.setDateOfIssue(dateOfIssue);
		userCardManagementDTO.setDateOfExpiry(dateOfExpiry);
		userCardManagementDTO.setCardTypeId(cardTypeId);
		userCardManagementDTO.setCardTypeName(cardTypeName);
		userCardManagementDTO.setCardTypeId(cardTypeId);
		userCardManagementDTO.setCardTypeName(cardTypeName);
		userCardManagementDTO.setUserId(userId);
		userCardManagementDTO.setUserName(userName);
		return userCardManagementDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		UserCardManagementDTO userCardManagementDTO = (UserCardManagementDTO) dto;
		name = userCardManagementDTO.getName();
		cardReferenceNo = userCardManagementDTO.getCardReferenceNo();
		chipNo = userCardManagementDTO.getChipNo();
		cardType = userCardManagementDTO.getCardType();
		dateOfIssue = userCardManagementDTO.getDateOfIssue();
		dateOfExpiry = userCardManagementDTO.getDateOfExpiry();
		cardTypeId = userCardManagementDTO.getCardTypeId();
		cardTypeName = userCardManagementDTO.getCardTypeName();
		userId = userCardManagementDTO.getUserId();
		userName = userCardManagementDTO.getUserName();
		super.populateCommon(dto);
	}

}
