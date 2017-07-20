package com.ncs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "Company_Product_intersection")
public class CompanyProductIntersectionDTO extends BaseDTO {

	@Column(name = "COMPANY_ID", length = 50)
	private Long companyId;
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	@Column(name = "PRODUCT_ID", length = 50)
	private Long productId;
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	@Column(name = "PRODUCT_TYPE", length = 50)
	private String productType;
	@Column(name = "EMAIL_ID", length = 50)
	private String emailId;
	@Column(name = "MOBILE_NO", length = 50)
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}
