package com.ncs.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;
@Entity
@Table(name = "BUY_SUPPLIER")
public class BuySupplierDTO extends BaseDTO {
	
	@Column(name = "USER_ID", length = 15)
	private Long userId;

	@Column(name = "USER_NAME", length = 50)
	private String userName;

	@Column(name = "COMPANY_ID", length = 15)
	private Long companyId;

	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;

	@Column(name = "PRODUCT_ID", length = 15)
	private Long productId;

	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	
	@Column(name = "PACKAGING_ID", length = 15)
	private Long packagingId;

	@Column(name = "PACKAGING", length = 50)
	private String packaging;

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

	public Long getPackagingId() {
		return packagingId;
	}

	public void setPackagingId(Long packagingId) {
		this.packagingId = packagingId;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
}
