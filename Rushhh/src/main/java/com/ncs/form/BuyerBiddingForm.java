package com.ncs.form;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ncs.dto.BuyerBiddingDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;
import com.nenosystems.common.util.JsonDateSerializer;

/**
 * @author root
 *
 */
public class BuyerBiddingForm extends BaseForm {

	private Long bidId;
	private String type;
	private String productName;
	private Double quantity;
	private String unit;
	private Long productId;
	private String startDate;
	private String enddate;
	private String expectedDeliveryDate;
	private String transportation;
	private String insurance;
	private String thirdPartyInspection;
	private String address;
	private String packaging;
	private String status;
	private String companyName;
	private Long companyId;
	private Long buyerCompanyId;
	private String buyerCompanyName;
	private Long buyerId;
	private String buyerName;
	private Double quotationAmount;
	private String timestamp;
	private String buyerProduct;
	private String dealDate;
	private Double expectedAmount;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private int visitor;
	private Long packagingId;
	private String bidRefrenceNo;
	private Double remainingQuantity;
	private Boolean isRemainQuantity;
	private Double wonQuantity;
	private Boolean isVisit;
	private String freezingType;
	private Double bidAmount;
	private String selectedSellers[];
	private Boolean isRequest;
	private Boolean isBidOpen;
	private int counter;
	private String FavSellerIdArray[];
	private String checkValue;
	private String checkValueAllSellers;
	private String allSellerIdArray[];
	private String utrNo;
	private String bankName;
	private String utrRcvDate;
	private int category;
	
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	private List alarmData=null;
	
	
	
	
	public List getAlarmData() {
		return alarmData;
	}

	public void setAlarmData(List alarmData) {
		this.alarmData = alarmData;
	}

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

	public String getUtrRcvDate() {
		return utrRcvDate;
	}

	public void setUtrRcvDate(String utrRcvDate) {
		this.utrRcvDate = utrRcvDate;
	}

	public String[] getFavSellerIdArray() {
		return FavSellerIdArray;
	}

	public void setFavSellerIdArray(String[] favSellerIdArray) {
		FavSellerIdArray = favSellerIdArray;
	}

	public String getCheckValueAllSellers() {
		return checkValueAllSellers;
	}

	public void setCheckValueAllSellers(String checkValueAllSellers) {
		this.checkValueAllSellers = checkValueAllSellers;
	}

	public String[] getAllSellerIdArray() {
		return allSellerIdArray;
	}

	public void setAllSellerIdArray(String[] allSellerIdArray) {
		this.allSellerIdArray = allSellerIdArray;
	}

	public String getCheckValue() {
		return checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
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

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
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

	public Double getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(Double remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
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

	public void setStateName(String stateName) {
		this.stateName = stateName;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getBuyerProduct() {
		return buyerProduct;
	}

	public void setBuyerProduct(String buyerProduct) {
		this.buyerProduct = buyerProduct;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	public BaseDTO makeDto() {
		BuyerBiddingDTO buyerbiddingdto = new BuyerBiddingDTO();
		super.makeDto(buyerbiddingdto);
		buyerbiddingdto.setProductName(productName);
		buyerbiddingdto.setInsurance(insurance);
		buyerbiddingdto.setExpectedDeliveryDate(DataUtil.convertDateFormat(expectedDeliveryDate));
		buyerbiddingdto.setQuantity(quantity);
		buyerbiddingdto.setUnit(unit);
		buyerbiddingdto.setStartDate(DataUtil.convertDateFormat(startDate));
		buyerbiddingdto.setEnddate(DataUtil.convertDateFormat(enddate));
		buyerbiddingdto.setTransportation(transportation);
		buyerbiddingdto.setThirdPartyInspection(thirdPartyInspection);
		buyerbiddingdto.setProductId(productId);
		buyerbiddingdto.setType(type);
		buyerbiddingdto.setStatus(status);
		buyerbiddingdto.setPackaging(packaging);
		buyerbiddingdto.setCompanyId(companyId);
		buyerbiddingdto.setCompanyName(companyName);
		buyerbiddingdto.setBuyerCompanyId(buyerCompanyId);
		buyerbiddingdto.setBuyerCompanyName(buyerCompanyName);
		buyerbiddingdto.setBuyerId(buyerId);
		buyerbiddingdto.setBuyerName(buyerName);
		buyerbiddingdto.setQuotationAmount(quotationAmount);
		buyerbiddingdto.setDealDate(DataUtil.convertDateFormat(dealDate));
		buyerbiddingdto.setExpectedAmount(expectedAmount);
		buyerbiddingdto.setCityId(cityId);
		buyerbiddingdto.setCityName(cityName);
		buyerbiddingdto.setStateId(stateId);
		buyerbiddingdto.setStateName(stateName);
		buyerbiddingdto.setVisitor(visitor);
		buyerbiddingdto.setPackagingId(packagingId);
		buyerbiddingdto.setBidRefrenceNo(bidRefrenceNo);
		buyerbiddingdto.setRemainingQuantity(quantity);
		buyerbiddingdto.setIsRemainQuantity(isRemainQuantity);
		buyerbiddingdto.setWonQuantity(wonQuantity);
		buyerbiddingdto.setBidId(bidId);
		buyerbiddingdto.setIsVisit(isVisit);
		buyerbiddingdto.setFreezingType(freezingType);
		buyerbiddingdto.setBidAmount(bidAmount);
		buyerbiddingdto.setSelectedSellers(selectedSellers);
		buyerbiddingdto.setIsRequest(isRequest);
		buyerbiddingdto.setIsBidOpen(isBidOpen);
		buyerbiddingdto.setCounter(counter);
		buyerbiddingdto.setCheckValue(checkValue);
		buyerbiddingdto.setCheckValueAllSellers(checkValueAllSellers);
		buyerbiddingdto.setAllSellerId(Arrays.toString(allSellerIdArray).replaceAll("\\[|\\]|\\s", ""));
		buyerbiddingdto.setBankName(bankName);
		buyerbiddingdto.setUtrNo(utrNo);
		buyerbiddingdto.setUtrRcvDate(DataUtil.convertDateFormat(utrRcvDate));
		
		return buyerbiddingdto;
	}
	
	@Override
	public void populate(BaseDTO dto) {
		BuyerBiddingDTO buyerbiddingdto = (BuyerBiddingDTO) dto;
		productName = buyerbiddingdto.getProductName();
		insurance = buyerbiddingdto.getInsurance();
		quantity = buyerbiddingdto.getQuantity();
		unit = buyerbiddingdto.getUnit();
		expectedDeliveryDate = DataUtil.convertDateToString(buyerbiddingdto.getExpectedDeliveryDate());
		startDate = DataUtil.convertDateToString(buyerbiddingdto.getStartDate());
		enddate = DataUtil.convertDateToString(buyerbiddingdto.getEnddate());
		transportation = buyerbiddingdto.getTransportation();
		productId = buyerbiddingdto.getProductId();
		type = buyerbiddingdto.getType();
		status = buyerbiddingdto.getStatus();
		thirdPartyInspection = buyerbiddingdto.getThirdPartyInspection();
		packaging = buyerbiddingdto.getPackaging();
		companyId = buyerbiddingdto.getCompanyId();
		companyName = buyerbiddingdto.getCompanyName();
		buyerCompanyId = buyerbiddingdto.getBuyerCompanyId();
		buyerCompanyName = buyerbiddingdto.getBuyerCompanyName();
		buyerId = buyerbiddingdto.getBuyerId();
		buyerName = buyerbiddingdto.getBuyerName();
		quotationAmount = buyerbiddingdto.getQuotationAmount();
		dealDate = DataUtil.convertDateToString(buyerbiddingdto.getDealDate());
		expectedAmount = buyerbiddingdto.getExpectedAmount();
		stateId = buyerbiddingdto.getStateId();
		stateName = buyerbiddingdto.getStateName();
		cityId = buyerbiddingdto.getCityId();
		cityName = buyerbiddingdto.getCityName();
		visitor = buyerbiddingdto.getVisitor();
		remainingQuantity = buyerbiddingdto.getRemainingQuantity();
		packagingId = buyerbiddingdto.getPackagingId();
		bidRefrenceNo = buyerbiddingdto.getBidRefrenceNo();
		isRemainQuantity = buyerbiddingdto.getIsRemainQuantity();
		wonQuantity = buyerbiddingdto.getWonQuantity();
		bidId = buyerbiddingdto.getBidId();
		isVisit = buyerbiddingdto.getIsVisit();
		freezingType = buyerbiddingdto.getFreezingType();
		bidAmount = buyerbiddingdto.getBidAmount();
		selectedSellers = buyerbiddingdto.getSelectedSellers();
		isRequest = buyerbiddingdto.getIsRequest();
		isBidOpen = buyerbiddingdto.getIsBidOpen();
		counter = buyerbiddingdto.getCounter();
		if (buyerbiddingdto.getAllSellerId() != null) {
			allSellerIdArray = buyerbiddingdto.getAllSellerId().split(",");
		}
		checkValue = buyerbiddingdto.getCheckValue();
		checkValueAllSellers=buyerbiddingdto.getCheckValueAllSellers();
		startDate = DataUtil.convertDateToString(buyerbiddingdto.getStartDate());
		utrRcvDate= DataUtil.convertDateToString(buyerbiddingdto.getUtrRcvDate());
		bankName=buyerbiddingdto.getBankName();
		utrNo=buyerbiddingdto.getUtrNo();
		super.populateCommon(buyerbiddingdto);
	}

}
