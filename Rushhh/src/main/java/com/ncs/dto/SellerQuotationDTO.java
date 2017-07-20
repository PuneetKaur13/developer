package com.ncs.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "SELLER_QUOTATION")
public class SellerQuotationDTO extends BaseDTO implements Serializable {

	@Column(name = "BID_ID", length = 50)
	private Long bidId;
	@Column(name = "PRODUCT_ID", length = 50)
	private Long productId;
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	@Column(name = "QUOTATION_AMOUNT", length = 50)
	private Double quotationAmount;
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	@Column(name = "SELLER_ID", length = 50)
	private Long sellerId;
	@Column(name = "SELLER_NAME", length = 50)
	private String sellerName;
	@Column(name = "COMPANY_ID", length = 50)
	private Long companyId;
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	@Column(name = "TIMESTAMP", length = 50)
	private Timestamp timestamp;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "SELLER_COMPANY_ID")
	private Long sellerCompanyId;
	@Column(name = "SELLER_COMPANY_NAME")
	private String sellerCompanyName;
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "IS_COUNTER")
	private Boolean isCounter;
	@Column(name = "QUANTITY", length = 50)
	private Double quantity;
	@Column(name = "UNIT", length = 50)
	private String unit;
	@Column(name = "PACKAGING", length = 50)
	private String packaging;
	@Column(name = "CITY_ID", length = 50)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_ID", length = 50)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
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

	public Double getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(Double quotationAmount) {
		this.quotationAmount = quotationAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getSellerCompanyId() {
		return sellerCompanyId;
	}

	public void setSellerCompanyId(Long sellerCompanyId) {
		this.sellerCompanyId = sellerCompanyId;
	}

	public String getSellerCompanyName() {
		return sellerCompanyName;
	}

	public void setSellerCompanyName(String sellerCompanyName) {
		this.sellerCompanyName = sellerCompanyName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsCounter() {
		return isCounter;
	}

	public void setIsCounter(Boolean isCounter) {
		this.isCounter = isCounter;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		 //addUniqueAttribute("productId", productId);
		 addUniqueAttribute("&", "&");
		 //addUniqueAttribute("companyId", companyId);
		return uniqueAttributes;
	}

}
