package com.ncs.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.util.JsonDateSerializer;

@Entity
@Table(name = "BUYER_QUOTATION")
public class BuyerQuotationDTO extends BaseDTO implements Serializable {

	@Column(name = "BID_ID", length = 50)
	private Long bidId;
	@Column(name = "BID_REFRENCE", length = 50)
	private String bidRefrenceNo;
	@Column(name = "QUOTATION_AMOUNT", length = 50)
	private Double quotationAmount;
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	@Column(name = "BUYER_ID", length = 50)
	private Long buyerId;
	@Column(name = "BUYER_NAME", length = 50)
	private String buyerName;
	@Column(name = "COMPANY_ID", length = 50)
	private Long companyId;
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	@Column(name = "TIMESTAMP", length = 50)
	private Timestamp timestamp;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	@Column(name = "PRODUCT_ID", length = 50)
	private Long productId;
	@Column(name = "BUYER_COMPANY_ID")
	private Long buyerCompanyId;
	@Column(name = "BUYER_COMPANY_NAME")
	private String buyerCompanyName;
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
	@Column(name = "PACKAGING_ID", length = 50)
	private Long packagingId;
	@Column(name = "PACKAGING")
	private String packaging;
	@Column(name = "REMAINING_QUANTITY", length = 50)
	private Double remainingQuantity;
	@Column(name = "IS_REMAIN")
	private Boolean isRemainQuantity;
	@Column(name = "CITY_ID", length = 50)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_ID", length = 50)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "WON_QUANTITY", length = 50)
	private Double wonQuantity;
	@Column(name = "COUNTER", length = 50)
	private Integer counter;
	@Column(name = "RANK", length = 50)
	private Integer rank;
	@Column(name = "OFFER_BY", length = 50)
	private String offerBy;
	@Column(name = "OFFER_BY_BUYER", length = 50)
	private String offerByBuyer;
	@Column(name = "COUNTER_QUANTITY", length = 50)
	private Double counterQuantity;
	@Column(name = "COUNTER_AMOUNT", length = 50)
	private Double counterAmount;
	@Column(name = "COUNTER_DATE")
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date CounterDate;
	

	public Date getCounterDate() {
		return CounterDate;
	}

	public void setCounterDate(Date counterDate) {
		CounterDate = counterDate;
	}

	public String getOfferByBuyer() {
		return offerByBuyer;
	}

	public void setOfferByBuyer(String offerByBuyer) {
		this.offerByBuyer = offerByBuyer;
	}

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

	public String getOfferBy() {
		return offerBy;
	}

	public void setOfferBy(String offerBy) {
		this.offerBy = offerBy;
	}
	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getWonQuantity() {
		return wonQuantity;
	}

	public void setWonQuantity(Double wonQuantity) {
		this.wonQuantity = wonQuantity;
	}

	public String getBidRefrenceNo() {
		return bidRefrenceNo;
	}

	public void setBidRefrenceNo(String bidRefrenceNo) {
		this.bidRefrenceNo = bidRefrenceNo;
	}

	public Double getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Double remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public Boolean getIsRemainQuantity() {
		return isRemainQuantity;
	}

	public void setIsRemainQuantity(Boolean isRemainQuantity) {
		this.isRemainQuantity = isRemainQuantity;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Long getPackagingId() {
		return packagingId;
	}

	public void setPackagingId(Long packagingId) {
		this.packagingId = packagingId;
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
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

	public Long getBuyerCompanyId() {
		return buyerCompanyId;
	}

	public void setBuyerCompanyId(Long buyerCompanyId) {
		this.buyerCompanyId = buyerCompanyId;
	}

	public String getBuyerCompanyName() {
		return buyerCompanyName;
	}

	public void setBuyerCompanyName(String buyerCompanyName) {
		this.buyerCompanyName = buyerCompanyName;
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
	@Override
	public List<Object[]> getUniqueAttributes() {
		 //addUniqueAttribute("productId", productId);
		// addUniqueAttribute("&", "&");
		return uniqueAttributes;
	}

}
