package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.CompanyProductIntersectionDTO;
import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class CompanyProductIntersectionForm extends BaseForm {
	
	private Long companyId;
	private String companyName;
	private Long productId;
	private String productName;
	private String productType;
	private String emailId;
	private String mobileNo;
	

	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		CompanyProductIntersectionDTO companyProductIntersection = new CompanyProductIntersectionDTO();
		super.makeDto(companyProductIntersection);
		companyProductIntersection.setCompanyId(companyId);
		companyProductIntersection.setCompanyName(companyName);
		companyProductIntersection.setProductId(productId);
		companyProductIntersection.setProductName(productName);
		companyProductIntersection.setProductType(productType);
		companyProductIntersection.setEmailId(emailId);
		companyProductIntersection.setMobileNo(mobileNo);
		return companyProductIntersection;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		CompanyProductIntersectionDTO companyProductIntersection = (CompanyProductIntersectionDTO) dto;
		companyId=companyProductIntersection.getCompanyId();
		companyName=companyProductIntersection.getCompanyName();
		productId=companyProductIntersection.getProductId();
		productType=companyProductIntersection.getProductType();
		productName=companyProductIntersection.getProductName();
		emailId=companyProductIntersection.getEmailId();
		mobileNo=companyProductIntersection.getMobileNo();
		super.populateCommon(dto);
	}	
}
