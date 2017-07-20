package com.ncs.form;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import org.apache.commons.beanutils.converters.StringArrayConverter;
import org.codehaus.jackson.map.ser.std.StdArraySerializers.StringArraySerializer;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

import com.ncs.dto.BuyerQuotationDTO;
import com.ncs.dto.CompanyDTO;
import com.ncs.dto.ProductDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class CompanyForm extends BaseForm {

	private String companyName;
	private String companyAddress;
	private Long userId;
	private String country;
	private String designation;
	private String ceoName;
	private String description;
	private String rgNumber;
	private String status;
	private String imagePath;
	private String primaryEmail;
	private String alternateEmail;
	private String website;
	private String phoneNo;
	private String firstName;
	private String lastName;
	private String ceoLast;
	private String phoneNo1;
	private String bankName;
	private String branchAddress;
	private String ifscCode;
	private String branchCode;
	private String panNo;
	private String tinNo;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private String type;
	private String[] userProductArray;
	private String[] userCompanyArray;
	private Long productId;
	private String productName;
	private String productType;
	private String companyRole;
	private String designationOther;
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

	public String getCompanyRole() {
		return companyRole;
	}

	public void setCompanyRole(String companyRole) {
		this.companyRole = companyRole;
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

	private ArrayList<CompanyDTO> userprod;
	
	public String[] getUserCompanyArray() {
		return userCompanyArray;
	}

	public void setUserCompanyArray(String[] userCompanyArray) {
		this.userCompanyArray = userCompanyArray;
	}

	public ArrayList<CompanyDTO> getUserprod() {
		return userprod;
	}

	public void setUserprod(ArrayList<CompanyDTO> userprod) {
		this.userprod = userprod;
	}

	public String[] getUserProductArray() {
		return userProductArray;
	}

	public void setUserProductArray(String[] userProductArray) {
		this.userProductArray = userProductArray;
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

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public String getCeoLast() {
		return ceoLast;
	}

	public void setCeoLast(String ceoLast) {
		this.ceoLast = ceoLast;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
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

	@Override
	public BaseDTO makeDto() {
		CompanyDTO companydto = new CompanyDTO();
		ProductDTO productDTO = new ProductDTO();
		super.makeDto(companydto);
		companydto.setCompanyName(companyName);
		companydto.setCompanyAddress(companyAddress);
		companydto.setDescription(description);
		companydto.setRgNumber(rgNumber);
		companydto.setStatus(status);
		companydto.setPhoneNo(phoneNo);
		companydto.setPrimaryEmail(primaryEmail);
		companydto.setAlternateEmail(alternateEmail);
		companydto.setDesignation(designation);
		companydto.setFirstName(firstName);
		companydto.setLastName(lastName);
		companydto.setCeoName(ceoName);
		companydto.setImagePath(imagePath);
		companydto.setWebsite(website);
		companydto.setPhoneNo1(phoneNo1);
		companydto.setCeoLast(ceoLast);
		companydto.setCountry(country);
		companydto.setBankName(bankName);
		companydto.setBranchAddress(branchAddress);
		companydto.setBranchCode(branchCode);
		companydto.setIfscCode(ifscCode);
		companydto.setPanNo(panNo);
		companydto.setTinNo(tinNo);
		companydto.setStateId(stateId);
		companydto.setStateName(stateName);
		companydto.setCityId(cityId);
		companydto.setCityName(cityName);
		companydto.setType(type);

		companydto.setProductId(productId);
		companydto.setProductType(productType);
		companydto.setProductName(productName);
		companydto.setCompanyRole(companyRole);
		companydto.setDesignationOther(designationOther);
		
		return companydto;
	}

	@Override
	public void populate(BaseDTO dto) {
		CompanyDTO companydto = (CompanyDTO) dto;
		companyRole=companydto.getCompanyRole();
		companyName = companydto.getCompanyName();
		companyAddress = companydto.getCompanyAddress();
		description = companydto.getDescription();
		rgNumber = companydto.getRgNumber();
		status = companydto.getStatus();
		userId = companydto.getUserId();
		imagePath = companydto.getImagePath();
		primaryEmail = companydto.getPrimaryEmail();
		ceoName = companydto.getCeoName();
		firstName = companydto.getFirstName();
		lastName = companydto.getLastName();
		designation = companydto.getDesignation();
		alternateEmail = companydto.getAlternateEmail();
		phoneNo = companydto.getPhoneNo();
		website = companydto.getWebsite();
		phoneNo1 = companydto.getPhoneNo1();
		ceoLast = companydto.getCeoLast();
		country = companydto.getCountry();
		bankName = companydto.getBankName();
		branchAddress = companydto.getBranchAddress();
		branchCode = companydto.getBranchCode();
		ifscCode = companydto.getIfscCode();
		panNo = companydto.getPanNo();
		tinNo = companydto.getTinNo();
		cityId = companydto.getCityId();
		stateId = companydto.getStateId();
		cityName = companydto.getCityName();
		stateName = companydto.getStateName();
		type = companydto.getType();
		productId=companydto.getProductId();
		productType=companydto.getProductType();
		productName=companydto.getProductName();
		designationOther=companydto.getDesignationOther();
		super.populateCommon(dto);
	}
}
