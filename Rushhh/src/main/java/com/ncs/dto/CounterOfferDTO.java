package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "COUNTER_OFFER")
public class CounterOfferDTO  extends BaseDTO implements Serializable{
	
	@Column(name = "TYPE", length = 50)
	private String type;
	@Column(name = "QUOTATION_ID", length = 50)
	private Long quotationId;
	@Column(name = "SELLER_ID", length = 50)
	private Long sellerId;
	@Column(name = "BUYER_ID", length = 50)
	private Long buyerId;
	@Column(name = "SLLER_NAME", length = 50)
	private String sellerName;
	@Column(name = "BUYER_NAME", length = 50)
	private String buyerName;
	@Column(name = "QUOTATION_AMOUNT", length = 50)
	private Double quotationAmount;
	@Column(name = "QUANTITY", length = 50)
	private Double quantity;
	@Column(name = "UNIT", length = 50)
	private String unit;
	@Column(name = "OFFER_BY", length = 50)
	private String offerBy;
	@Column(name = "BID_ID", length = 50)
	private Long bidId;
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	@Column(name = "PRODUCT_ID", length = 50)
	private Long productId;
	@Column(name = "PACKAGING_ID", length = 50)
	private Long packagingId;
	@Column(name = "PACKAGING")
	private String packaging;
	@Column(name = "CITY_ID", length = 50)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_ID", length = 50)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "COUNTER_AMOUNT", length = 50)
	private Double counterAmount;
	@Column(name = "COUNTER_QUANTITY", length = 50)
	private Double counterQuantity;
	


	public Double getCounterQuantity() {
		return counterQuantity;
	}

	public void setCounterQuantity(Double counterQuantity) {
		this.counterQuantity = counterQuantity;
	}

	public Double getCounterAmount() {
		return counterAmount;
	}

	public void setCounterAmount(Double counterAmount) {
		this.counterAmount = counterAmount;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public String getOfferBy() {
		return offerBy;
	}

	public void setOfferBy(String offerBy) {
		this.offerBy = offerBy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Long quotationId) {
		this.quotationId = quotationId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(Double quotationAmount) {
		this.quotationAmount = quotationAmount;
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
	

}
