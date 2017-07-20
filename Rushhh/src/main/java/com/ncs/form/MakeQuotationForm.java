package com.ncs.form;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ncs.dto.MakeQuotationDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.JsonDateSerializer;

public class MakeQuotationForm extends BaseForm {

	private String bidRefrenceNo;
	private String type;
	private Long bidId;
	private String companyName;
	private Long companyId;
	private String invitedUserName;
	private Long invitedUserCompanyId;
	private String invitedUserCompanyName;
	private Long invitedUserId;
	private String productName;
	private Long productId;
	private Double quantity;
	private String unit;
	private Date startDate;
	private Date enddate;
	private Date expectedDeliveryDate;
	private String transportation;
	private String insurance;
	private String thirdPartyInspection;
	private String status;
	private String inviteStatus;
	private String packaging;
	private Long buyerCompanyId;
	private String buyerCompanyName;
	private Long buyerId;
	private String buyerName;
	private Double quotationAmount;
	private Date dealDate;
	private Double expectedAmount;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private int visitor;
	private Long packagingId;
	private Double remainingQuantity;
	private Boolean isRemainQuantity;
	private Double wonQuantity;
	private Boolean isVisit;
	private String freezingType;
	private Boolean isRequest;
	private Boolean isBidOpen;
	private int counter;
	private String FavSellerId;
	private String checkValue;
	private String checkValueAllSellers;
	private Boolean isAccept;
	private Boolean isReject;
	private Double bidAmount;
	private Boolean isQuote;
	private Long inviteGroupId;
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

	@Override
	public BaseDTO makeDto() {
		MakeQuotationDTO makeQuotationDTO = new MakeQuotationDTO();
		super.makeDto(makeQuotationDTO);
		makeQuotationDTO.setStatus(inviteStatus);
		makeQuotationDTO.setProductName(productName);
		makeQuotationDTO.setInsurance(insurance);
		makeQuotationDTO.setQuantity(quantity);
		makeQuotationDTO.setUnit(unit);
		makeQuotationDTO.setTransportation(transportation);
		makeQuotationDTO.setThirdPartyInspection(thirdPartyInspection);
		makeQuotationDTO.setProductId(productId);
		makeQuotationDTO.setType(type);
		makeQuotationDTO.setStatus(status);
		makeQuotationDTO.setPackaging(packaging);
		makeQuotationDTO.setCompanyId(companyId);
		makeQuotationDTO.setCompanyName(companyName);
		makeQuotationDTO.setBuyerCompanyId(buyerCompanyId);
		makeQuotationDTO.setBuyerCompanyName(buyerCompanyName);
		makeQuotationDTO.setBuyerId(buyerId);
		makeQuotationDTO.setBuyerName(buyerName);
		makeQuotationDTO.setQuotationAmount(quotationAmount);
		makeQuotationDTO.setExpectedAmount(expectedAmount);
		makeQuotationDTO.setCityId(cityId);
		makeQuotationDTO.setCityName(cityName);
		makeQuotationDTO.setStateId(stateId);
		makeQuotationDTO.setStateName(stateName);
		makeQuotationDTO.setVisitor(visitor);
		makeQuotationDTO.setPackagingId(packagingId);
		makeQuotationDTO.setBidRefrenceNo(bidRefrenceNo);
		makeQuotationDTO.setRemainingQuantity(quantity);
		makeQuotationDTO.setIsRemainQuantity(isRemainQuantity);
		makeQuotationDTO.setWonQuantity(wonQuantity);
		makeQuotationDTO.setBidId(bidId);
		makeQuotationDTO.setIsVisit(isVisit);
		makeQuotationDTO.setFreezingType(freezingType);
		makeQuotationDTO.setIsRequest(isRequest);
		makeQuotationDTO.setIsBidOpen(isBidOpen);
		makeQuotationDTO.setCounter(counter);
		makeQuotationDTO.setCheckValue(checkValue);
		makeQuotationDTO.setCheckValueAllSellers(checkValueAllSellers);
		makeQuotationDTO.setInvitedUserId(invitedUserId);
		makeQuotationDTO.setInvitedUserName(invitedUserName);
		makeQuotationDTO.setInvitedUserCompanyId(invitedUserCompanyId);
		makeQuotationDTO.setInvitedUserCompanyName(invitedUserCompanyName);
		makeQuotationDTO.setIsAccept(isAccept);
		makeQuotationDTO.setIsReject(isReject);
		makeQuotationDTO.setBidAmount(bidAmount);
		makeQuotationDTO.setIsQuote(isQuote);
		makeQuotationDTO.setInviteGroupId(inviteGroupId);
		makeQuotationDTO.setApproveUserId(approveUserId);
		return makeQuotationDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		MakeQuotationDTO makeQuotationDTO = (MakeQuotationDTO) dto;
		invitedUserCompanyId = makeQuotationDTO.getInvitedUserCompanyId();
		invitedUserCompanyName = makeQuotationDTO.getInvitedUserCompanyName();
		productName = makeQuotationDTO.getProductName();
		insurance = makeQuotationDTO.getInsurance();
		quantity = makeQuotationDTO.getQuantity();
		unit = makeQuotationDTO.getUnit();
		transportation = makeQuotationDTO.getTransportation();
		productId = makeQuotationDTO.getProductId();
		type = makeQuotationDTO.getType();
		status = makeQuotationDTO.getStatus();
		thirdPartyInspection = makeQuotationDTO.getThirdPartyInspection();
		packaging = makeQuotationDTO.getPackaging();
		companyId = makeQuotationDTO.getCompanyId();
		companyName = makeQuotationDTO.getCompanyName();
		buyerCompanyId = makeQuotationDTO.getBuyerCompanyId();
		buyerCompanyName = makeQuotationDTO.getBuyerCompanyName();
		buyerId = makeQuotationDTO.getBuyerId();
		buyerName = makeQuotationDTO.getBuyerName();
		quotationAmount = makeQuotationDTO.getQuotationAmount();
		expectedAmount = makeQuotationDTO.getExpectedAmount();
		stateId = makeQuotationDTO.getStateId();
		stateName = makeQuotationDTO.getStateName();
		cityId = makeQuotationDTO.getCityId();
		cityName = makeQuotationDTO.getCityName();
		visitor = makeQuotationDTO.getVisitor();
		remainingQuantity = makeQuotationDTO.getRemainingQuantity();
		packagingId = makeQuotationDTO.getPackagingId();
		bidRefrenceNo = makeQuotationDTO.getBidRefrenceNo();
		isRemainQuantity = makeQuotationDTO.getIsRemainQuantity();
		wonQuantity = makeQuotationDTO.getWonQuantity();
		bidId = makeQuotationDTO.getBidId();
		isVisit = makeQuotationDTO.getIsVisit();
		freezingType = makeQuotationDTO.getFreezingType();
		isRequest = makeQuotationDTO.getIsRequest();
		isBidOpen = makeQuotationDTO.getIsBidOpen();
		counter = makeQuotationDTO.getCounter();
		inviteStatus = makeQuotationDTO.getInviteStatus();
		checkValue = makeQuotationDTO.getCheckValue();
		invitedUserId = makeQuotationDTO.getInvitedUserId();
		invitedUserName = makeQuotationDTO.getInvitedUserName();
		isAccept=makeQuotationDTO.getIsAccept();
		isReject=makeQuotationDTO.getIsReject();
		bidAmount=makeQuotationDTO.getBidAmount();
		isQuote=makeQuotationDTO.getIsQuote();
		inviteGroupId=makeQuotationDTO.getInviteGroupId();
		approveUserId=makeQuotationDTO.getApproveUserId();
		super.populateCommon(makeQuotationDTO);
	}

}
