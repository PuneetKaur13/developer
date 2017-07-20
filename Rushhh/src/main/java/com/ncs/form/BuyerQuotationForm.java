package com.ncs.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;

import com.ncs.dto.BuyerQuotationDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class BuyerQuotationForm extends BaseForm {

	private Long bidId;
	private Long productId;
	private String productName;
	private Double quotationAmount;
	private String description;
	private Long sellerId;
	private String sellerName;
	private Long companyId;
	private String companyName;
	private String timestamp;
	private String date;
	private Long buyerCompanyId;
	private String buyerCompanyName;
	private boolean isActive;
	private String status;
	private Boolean isCounter;
	private Double quantity;
	private String unit;
	private Long packagingId;
	private String packaging;
	private Double remainingQuantity;
	private Boolean isRemainQuantity;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private String bidRefrenceNo;
	private Double wonQuantity;
	private Integer counter;
	private Integer rank;
	private String offerBy;
	private Double counterQuantity;
	private Double counterAmount;
	private String offerByBuyer;
	private String CounterDate;

	public String getCounterDate() {
		return CounterDate;
	}

	public void setCounterDate(String counterDate) {
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	public BaseDTO makeDto() {
		BuyerQuotationDTO buyerquotationdto = new BuyerQuotationDTO();
		super.makeDto(buyerquotationdto);
		buyerquotationdto.setBidId(bidId);
		buyerquotationdto.setQuotationAmount(quotationAmount);
		buyerquotationdto.setDescription(description);
		buyerquotationdto.setBuyerId(sellerId);
		buyerquotationdto.setBuyerName(sellerName);
		buyerquotationdto.setCompanyId(companyId);
		buyerquotationdto.setCompanyName(companyName);
		buyerquotationdto.setQuantity(quantity);
		buyerquotationdto.setCityId(cityId);
		buyerquotationdto.setCityName(cityName);
		buyerquotationdto.setStateId(stateId);
		buyerquotationdto.setStateName(stateName);
		buyerquotationdto.setRank(rank);
		buyerquotationdto.setOfferByBuyer(offerByBuyer);
	
		buyerquotationdto.setProductId(productId);
		buyerquotationdto.setProductName(productName);
		buyerquotationdto.setBuyerCompanyId(buyerCompanyId);
		buyerquotationdto.setBuyerCompanyName(buyerCompanyName);
		buyerquotationdto.setStatus(status);
		buyerquotationdto.setActive(isActive);
		buyerquotationdto.setIsCounter(isCounter);
		buyerquotationdto.setUnit(unit);
		buyerquotationdto.setPackaging(packaging);
		buyerquotationdto.setPackagingId(packagingId);
		buyerquotationdto.setBidRefrenceNo(bidRefrenceNo);
		buyerquotationdto.setWonQuantity(wonQuantity);
		buyerquotationdto.setCounter(counter);
		buyerquotationdto.setOfferBy(offerBy);
		buyerquotationdto.setCounterQuantity(counterQuantity);
		buyerquotationdto.setCounterAmount(counterAmount);
		buyerquotationdto.setCounterDate(DataUtil.convertDateFormat(CounterDate));
		return buyerquotationdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		BuyerQuotationDTO buyerquotationdto = (BuyerQuotationDTO) dto;
		bidId = buyerquotationdto.getBidId();
		quotationAmount = buyerquotationdto.getQuotationAmount();
		description = buyerquotationdto.getDescription();
		sellerId = buyerquotationdto.getBuyerId();
		sellerName = buyerquotationdto.getBuyerName();
		companyId = buyerquotationdto.getCompanyId();
		companyName = buyerquotationdto.getCompanyName();
		timestamp = DataUtil.convertDateToString(buyerquotationdto.getTimestamp());
		date = DataUtil.convertDateToString(buyerquotationdto.getDate());
		productName = buyerquotationdto.getProductName();
		productId = buyerquotationdto.getProductId();
		buyerCompanyId = buyerquotationdto.getBuyerCompanyId();
		buyerCompanyName = buyerquotationdto.getBuyerCompanyName();
		isActive = buyerquotationdto.isActive();
		status = buyerquotationdto.getStatus();
		isCounter = buyerquotationdto.getIsCounter();
		quantity = buyerquotationdto.getQuantity();
		unit = buyerquotationdto.getUnit();
		packagingId = buyerquotationdto.getPackagingId();
		packaging = buyerquotationdto.getPackaging();
		cityId = buyerquotationdto.getCityId();
		cityName = buyerquotationdto.getCityName();
		stateId = buyerquotationdto.getStateId();
		stateName = buyerquotationdto.getStateName();
		bidRefrenceNo = buyerquotationdto.getBidRefrenceNo();
		wonQuantity = buyerquotationdto.getWonQuantity();
		counter = buyerquotationdto.getCounter();
		offerBy = buyerquotationdto.getOfferBy();
		counterQuantity = buyerquotationdto.getCounterQuantity();
		counterAmount = buyerquotationdto.getCounterAmount();
		offerByBuyer = buyerquotationdto.getOfferByBuyer();
		CounterDate = DataUtil.convertDateToString(buyerquotationdto.getCounterDate());

		rank = buyerquotationdto.getRank();
	}

}
