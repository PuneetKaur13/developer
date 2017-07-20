package com.ncs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "COMPANY")
public class CompanyDTO extends BaseDTO implements Serializable {

	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	@Column(name = "COMPANY_ROLE", length = 50)
	private String companyRole;
	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;
	@Column(name = "LAST_NAME", length = 50)
	private String lastName;
	@Column(name = "DESIGNATION", length = 50)
	private String designation;
	@Column(name = "DESIGNATION_OTHER", length = 50)
	private String designationOther;
	@Column(name = "IMAGE_PATH", length = 200)
	private String imagePath;
	@Column(name = "CEO_NAME", length = 50)
	private String ceoName;
	@Column(name = "CEO_LAST_NAME", length = 50)
	private String ceoLast;
	@Column(name = "EMAIL", length = 50)
	private String primaryEmail;
	@Column(name = "ALTERNATE_EMAIL", length = 50)
	private String alternateEmail;
	@Column(name = "WEBSITE", length = 50)
	private String website;
	@Column(name = "PHONE_NO", length = 50)
	private String phoneNo;
	@Column(name = "PHONE_NO2", length = 50)
	private String phoneNo1;
	@Column(name = "COMPANY_ADDRESS", length = 250)
	private String companyAddress;
	@Column(name = "DERSCRIPTION", length = 250)
	private String description;
	@Column(name = "REGISTRATION_NUMBER", length = 250)
	private String rgNumber;
	@Column(name = "STATUS", length = 250)
	private String status;
	@Column(name = "USER_ID", length = 50, nullable = false)
	private long userId;
	@Column(name = "COUNTRY", length = 250)
	private String country;
	@Column(name = "BANK_NAME", length = 50)
	private String bankName;
	@Column(name = "BRANCH_ADDRESS", length = 250)
	private String branchAddress;
	@Column(name = "IFSC_CODE", length = 50)
	private String ifscCode;
	@Column(name = "BRANCH_CODE", length = 50)
	private String branchCode;
	@Column(name = "PAN_NO", length = 500)
	private String panNo;
	@Column(name = "TIN_NO", length = 500)
	private String tinNo;
	@Column(name = "CITY_ID", length = 50)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_ID", length = 50)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "TYPE", length = 50)
	private String type;
	@Column(name = "PRODUCT_ID", length = 50)
	private Long productId;
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	@Column(name = "PRODUCT_TYPE", length = 50)
	private String productType;
	@Column(name = "USER_PK", length = 50)
	private Long userPk;


	public Long getUserPk() {
		return userPk;
	}

	public void setUserPk(Long userPk) {
		this.userPk = userPk;
	}

	public String getDesignationOther() {
		return designationOther;
	}

	public void setDesignationOther(String designationOther) {
		this.designationOther = designationOther;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public String getCeoLast() {
		return ceoLast;
	}

	public void setCeoLast(String ceoLast) {
		this.ceoLast = ceoLast;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRgNumber() {
		return rgNumber;
	}

	public void setRgNumber(String rgNumber) {
		this.rgNumber = rgNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCompanyRole() {
		return companyRole;
	}

	public void setCompanyRole(String companyRole) {
		this.companyRole = companyRole;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return companyName;
	}
	

}
