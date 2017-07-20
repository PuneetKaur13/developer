package com.ncs.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.util.JsonDateSerializer;

@Entity
@Table(name = "BUYER_BID")
public class BuyerBiddingDTO extends BaseDTO implements Serializable, Cloneable {

	@Column(name = "BID_REFRENCE", length = 50)
	private String bidRefrenceNo;
	@Column(name = "TYPE", length = 50)
	private String type;
	@Column(name = "BID_ID", length = 50)
	private Long bidId;
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;
	@Column(name = "COMPANY_ID", length = 50)
	private Long companyId;
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;
	@Column(name = "PRODUCT_Id", length = 50)
	private Long productId;
	@Column(name = "QUANTITY", length = 50)
	private Double quantity;
	@Column(name = "UNIT", length = 50)
	private String unit;
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "START_DATE")
	private Date startDate;
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "END_DATE")
	private Date enddate;
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "EXPECTED_DATE")
	private Date expectedDeliveryDate;
	@Column(name = "TRANSPORTATION")
	private String transportation;
	@Column(name = "INSURANCE")
	private String insurance;
	@Column(name = "THIRD_PARTY_INSPECTION")
	private String thirdPartyInspection;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "PACKAGING")
	private String packaging;
	@Column(name = "BUYER_COMPANY_ID")
	private Long buyerCompanyId;
	@Column(name = "BUYER_COMPANY_NAME")
	private String buyerCompanyName;
	@Column(name = "BUYER_ID", length = 50)
	private Long buyerId;
	@Column(name = "BUYER_NAME", length = 50)
	private String buyerName;
	@Column(name = "QUOTATION_AMOUNT", length = 50)
	private Double quotationAmount;
	@Column(name = "TIMESTAMP", length = 50)
	private Date dealDate;
	@Column(name = "EXPECTED_AMOUNT")
	private Double expectedAmount;
	@Column(name = "CITY_ID", length = 50)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	@Column(name = "STATE_ID", length = 50)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	@Column(name = "VISITOR")
	private int visitor;
	@Column(name = "PACKAGING_ID", length = 50)
	private Long packagingId;
	@Column(name = "REMAINING_QUANTITY", length = 50)
	private Double remainingQuantity;
	@Column(name = "IS_REMAIN")
	private Boolean isRemainQuantity;
	@Column(name = "WON_QUANTITY", length = 50)
	private Double wonQuantity;
	@Column(name = "IS_VISIT")
	private Boolean isVisit;
	@Column(name = "FREEZING_TYPE", length = 50)
	private String freezingType;
	@Column(name = "BID_AMOUNT", length = 50)
	private Double bidAmount;
	@Column(name = "SELECTED_SELLERS", length = 50)
	private String selectedSellers[];
	@Column(name = "IS_REQUEST")
	private Boolean isRequest;
	@Column(name = "IS_BIDOPEN")
	private Boolean isBidOpen;
	@Column(name = "counter", length = 50)
	private int counter;
	@Column(name = "CHECK_VALUE")
	private String checkValue;
	@Column(name = "CHECK_VALUE_ALL")
	private String checkValueAllSellers;
	@Column(name = "ALL_SELLER_ID")
	private String allSellerId;
	@Column(name = "UTR_NO")
	private String utrNo;
	@Column(name = "BANK_NAME")
	private String bankName;
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "UTR_RCV_DATE")
	private Date utrRcvDate;
	
	
	public String getUtrNo() {
		return utrNo;
	}

	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getUtrRcvDate() {
		return utrRcvDate;
	}

	public void setUtrRcvDate(Date utrRcvDate) {
		this.utrRcvDate = utrRcvDate;
	}

	public String getCheckValueAllSellers() {
		return checkValueAllSellers;
	}

	public void setCheckValueAllSellers(String checkValueAllSellers) {
		this.checkValueAllSellers = checkValueAllSellers;
	}

	public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}

	public String getAllSellerId() {
		return allSellerId;
	}

	public void setAllSellerId(String allSellerId) {
		this.allSellerId = allSellerId;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Boolean getIsBidOpen() {
		return isBidOpen;
	}

	public void setIsBidOpen(Boolean isBidOpen) {
		this.isBidOpen = isBidOpen;
	}

	public Boolean getIsRequest() {
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
	}

	public String getFreezingType() {
		return freezingType;
	}

	public void setFreezingType(String freezingType) {
		this.freezingType = freezingType;
	}

	public Boolean getIsVisit() {
		return isVisit;
	}

	public void setIsVisit(Boolean isVisit) {
		this.isVisit = isVisit;
	}

	public Double getWonQuantity() {
		return wonQuantity;
	}

	public void setWonQuantity(Double wonQuantity) {
		this.wonQuantity = wonQuantity;
	}

	public Boolean getIsRemainQuantity() {
		return isRemainQuantity;
	}

	public void setIsRemainQuantity(Boolean isRemainQuantity) {
		this.isRemainQuantity = isRemainQuantity;
	}

	public String getBidRefrenceNo() {
		return bidRefrenceNo;
	}

	public void setBidRefrenceNo(String bidRefrenceNo) {
		this.bidRefrenceNo = bidRefrenceNo;
	}

	public Long getPackagingId() {
		return packagingId;
	}

	public void setPackagingId(Long packagingId) {
		this.packagingId = packagingId;
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

	public String getThirdPartyInspection() {
		return thirdPartyInspection;
	}

	public void setThirdPartyInspection(String thirdPartyInspection) {
		this.thirdPartyInspection = thirdPartyInspection;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public Double getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(Double quotationAmount) {
		this.quotationAmount = quotationAmount;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public Double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(Double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}

	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

	public Double getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Double remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public Double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String[] getSelectedSellers() {
		return selectedSellers;
	}

	public void setSelectedSellers(String[] selectedSellers) {
		this.selectedSellers = selectedSellers;
	}

	@Override
	public BuyerBiddingDTO clone() throws CloneNotSupportedException {
		return (BuyerBiddingDTO) super.clone();
	}
}
