package com.ncs.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.util.JsonDateSerializer;
@Entity
@Table(name = "MAKE_QUOTATION")
public class MakeQuotationDTO extends BaseDTO implements Serializable, Cloneable {
	
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
	@Column(name = "INVITED_USER_NAME", length = 50)
	private String invitedUserName;
	@Column(name = "INVITED_USER_COMPANY_ID", length = 50)
	private Long invitedUserCompanyId;
	@Column(name = "INVITED_USER_COMPANY_NAME", length = 50)
	private String invitedUserCompanyName;
	@Column(name = "INVITED_USER_ID", length = 50)
	private Long invitedUserId;
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
	@Column(name = "INVITE_STATUS")
	private String inviteStatus;
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
	@Column(name = "IS_REQUEST")
	private Boolean isRequest;
	@Column(name = "IS_BIDOPEN")
	private Boolean isBidOpen;
	@Column(name = "IS_ACCEPT")
	private Boolean isAccept;
	@Column(name = "IS_Reject")
	private Boolean isReject;
	@Column(name = "counter", length = 50)
	private int counter;
	@Column(name = "FAV_SELLER_ID")
	private String FavSellerId;
	@Column(name = "CHECK_VALUE")
	private String checkValue;
	@Column(name="CHECK_VALUE_ALL")	
	private String checkValueAllSellers;
	@Column(name="BID_AMOUNT")	
	private Double bidAmount;
	@Column(name="IS_QUOTE")	
	private Boolean isQuote;
	@Column(name = "INVITE_GROUPID", length = 50)
	private Long inviteGroupId;
	@Column(name = "APPROVE_USER_ID", length = 50)
	private Long approveUserId;
	
	
	public Long getApproveUserId() {
		return approveUserId;
	}
	public void setApproveUserId(Long approveUserId) {
		this.approveUserId = approveUserId;
	}
	public Long getInviteGroupId() {
		return inviteGroupId;
	}
	public void setInviteGroupId(Long inviteGroupId) {
		this.inviteGroupId = inviteGroupId;
	}
	public Boolean getIsQuote() {
		return isQuote;
	}
	public void setIsQuote(Boolean isQuote) {
		this.isQuote = isQuote;
	}
	public Double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Boolean getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(Boolean isAccept) {
		this.isAccept = isAccept;
	}
	public Boolean getIsReject() {
		return isReject;
	}
	public void setIsReject(Boolean isReject) {
		this.isReject = isReject;
	}
	public String getBidRefrenceNo() {
		return bidRefrenceNo;
	}
	public void setBidRefrenceNo(String bidRefrenceNo) {
		this.bidRefrenceNo = bidRefrenceNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getBidId() {
		return bidId;
	}
	public void setBidId(Long bidId) {
		this.bidId = bidId;
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
	public String getInvitedUserName() {
		return invitedUserName;
	}
	public void setInvitedUserName(String invitedUserName) {
		this.invitedUserName = invitedUserName;
	}
	public Long getInvitedUserCompanyId() {
		return invitedUserCompanyId;
	}
	public void setInvitedUserCompanyId(Long invitedUserCompanyId) {
		this.invitedUserCompanyId = invitedUserCompanyId;
	}
	public String getInvitedUserCompanyName() {
		return invitedUserCompanyName;
	}
	public void setInvitedUserCompanyName(String invitedUserCompanyName) {
		this.invitedUserCompanyName = invitedUserCompanyName;
	}
	public Long getInvitedUserId() {
		return invitedUserId;
	}
	public void setInvitedUserId(Long invitedUserId) {
		this.invitedUserId = invitedUserId;
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
	public String getThirdPartyInspection() {
		return thirdPartyInspection;
	}
	public void setThirdPartyInspection(String thirdPartyInspection) {
		this.thirdPartyInspection = thirdPartyInspection;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInviteStatus() {
		return inviteStatus;
	}
	public void setInviteStatus(String inviteStatus) {
		this.inviteStatus = inviteStatus;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
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
	public int getVisitor() {
		return visitor;
	}
	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}
	public Long getPackagingId() {
		return packagingId;
	}
	public void setPackagingId(Long packagingId) {
		this.packagingId = packagingId;
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
	public Double getWonQuantity() {
		return wonQuantity;
	}
	public void setWonQuantity(Double wonQuantity) {
		this.wonQuantity = wonQuantity;
	}
	public Boolean getIsVisit() {
		return isVisit;
	}
	public void setIsVisit(Boolean isVisit) {
		this.isVisit = isVisit;
	}
	public String getFreezingType() {
		return freezingType;
	}
	public void setFreezingType(String freezingType) {
		this.freezingType = freezingType;
	}
	public Boolean getIsRequest() {
		return isRequest;
	}
	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
	}
	public Boolean getIsBidOpen() {
		return isBidOpen;
	}
	public void setIsBidOpen(Boolean isBidOpen) {
		this.isBidOpen = isBidOpen;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getFavSellerId() {
		return FavSellerId;
	}
	public void setFavSellerId(String favSellerId) {
		FavSellerId = favSellerId;
	}
	public String getCheckValue() {
		return checkValue;
	}
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
	public String getCheckValueAllSellers() {
		return checkValueAllSellers;
	}
	public void setCheckValueAllSellers(String checkValueAllSellers) {
		this.checkValueAllSellers = checkValueAllSellers;
	}
}
