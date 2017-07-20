package com.ncs.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;
@Entity
@Table(name = "PREFERRED_SUPPLIER")
public class PreferredSupplierDTO extends BaseDTO {
	
	@Column(name = "PRODUCT_ID", length = 15)
	private Long productId;

	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;

	@Column(name = "COMPANY_ID", length = 15)
	private Long companyId;

	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	
	@Column(name = "USER_ID", length = 15)
	private Long userId;

	@Column(name = "USER_NAME", length = 50)
	private String userName;
	
	@Column(name = "IS_REQUEST")
	private Boolean isRequest;
	
	@Column(name = "BID_ID", length = 15)
	private Long bidId;
	

	@Column(name = "STATUS", length = 50)
	private String status;
	
	
	public Boolean getIsRequest() {
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
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

	@Column(name = "BUYER_SELECTED_ID", length = 50)
	private String buyerSelectedId;
	
	
	
	public String getBuyerSelectedId() {
		return buyerSelectedId;
	}

	public void setBuyerSelectedId(String buyerSelectedId) {
		this.buyerSelectedId = buyerSelectedId;
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
	
}
