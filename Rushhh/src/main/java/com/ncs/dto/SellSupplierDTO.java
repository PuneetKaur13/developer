package com.ncs.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;
@Entity
@Table(name = "SELL_SUPPLIER")
public class SellSupplierDTO extends BaseDTO {
	
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
	
	@Column(name = "FAV_COMPANY_ID", length = 50)
	private Long favCompanyId;
	@Column(name = "FAV_COMPANY_NAME", length = 50)
	private String favCompanyName;
	@Column(name = "FAV_GROUP_ID", length = 50)
	private Long favGroupId;
	@Column(name = "FAV_GROUP_ID_STRING", length = 50)
	private String favGroupIdString;
	



	public Long getFavCompanyId() {
		return favCompanyId;
	}

	public void setFavCompanyId(Long favCompanyId) {
		this.favCompanyId = favCompanyId;
	}

	public Long getFavGroupId() {
		return favGroupId;
	}

	public void setFavGroupId(Long favGroupId) {
		this.favGroupId = favGroupId;
	}

	public String getFavGroupIdString() {
		return favGroupIdString;
	}

	public String getFavCompanyName() {
		return favCompanyName;
	}

	public void setFavCompanyName(String favCompanyName) {
		this.favCompanyName = favCompanyName;
	}

	public void setFavGroupIdString(String favGroupIdString) {
		this.favGroupIdString = favGroupIdString;
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
