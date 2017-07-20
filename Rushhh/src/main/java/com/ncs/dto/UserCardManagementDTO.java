package com.ncs.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "USER_CARD_MANAGEMENT")
public class UserCardManagementDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "CARD_REFERENCE_NO", length = 100)
	private String cardReferenceNo;
	@Column(name = "CHIP_NO", length = 100)
	private String chipNo;
	@Column(name = "CARD_TYPE", length = 100)
	private String cardType;
	@Column(name = "DATE_OF_ISSUE", length = 100)
	private Date dateOfIssue;
	@Column(name = "DATE_OF_EXPIRY", length = 100)
	private Date dateOfExpiry;
	@Column(name = "CARD_TYPE_ID", length = 100)
	private Long cardTypeId;
	@Column(name = "CARD_TYPE_NAME", length = 100)
	private String cardTypeName;
	@Column(name = "USER_ID", length = 100)
	private Long userId;
	@Column(name = "USER_NAME", length = 100)
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
	public void setUniqueAttributes(List<Object[]> uniqueAttributes) {
		addUniqueAttribute("cardReferenceNo", cardReferenceNo);
		addUniqueAttribute("chipNo", chipNo);
	}

}
