
package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.CounterOfferDTO;
import com.ncs.dto.OrganizationDTO;
import com.nenosystems.common.dto.BaseDTO;

import com.nenosystems.common.form.BaseForm;

public class CounterOfferForm extends BaseForm {

	private String type;
	private Long quotationId;
	private Long sellerId;
	private Long buyerId;
	private String sellerName;
	private String buyerName;
	private String unit;
	private Double quantity;
	private Double quotationAmount;
	private String offerBy;
	private Long bidId;
	private String productName;
	private Long productId;
	private Long packagingId;
	private String packaging;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private Double counterAmount;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(Double quotationAmount) {
		this.quotationAmount = quotationAmount;
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
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public BaseDTO makeDto() {
		CounterOfferDTO cfDTO = new CounterOfferDTO();
		super.makeDto(cfDTO);
		cfDTO.setType(type);
		cfDTO.setQuotationId(quotationId);
		cfDTO.setBuyerId(buyerId);
		cfDTO.setSellerId(sellerId);
		cfDTO.setBuyerName(buyerName);
		cfDTO.setSellerName(sellerName);
		cfDTO.setQuotationAmount(quotationAmount);
		cfDTO.setQuantity(quantity);
		cfDTO.setUnit(unit);
		cfDTO.setOfferBy(offerBy);
		cfDTO.setBidId(bidId);
		cfDTO.setProductId(productId);
		cfDTO.setProductName(productName);
		cfDTO.setPackaging(packaging);
		cfDTO.setPackagingId(packagingId);
		cfDTO.setStateId(stateId);
		cfDTO.setStateName(stateName);
		cfDTO.setCityName(cityName);
		cfDTO.setCityId(cityId);
		cfDTO.setCounterAmount(counterAmount);
		cfDTO.setCounterQuantity(counterQuantity);
		return cfDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		CounterOfferDTO cfDTO = (CounterOfferDTO) dto;
		type=cfDTO.getType();
		quotationId=cfDTO.getQuotationId();
		buyerId=cfDTO.getBuyerId();
		sellerId=cfDTO.getSellerId();
		buyerName=cfDTO.getSellerName();
		sellerName=cfDTO.getSellerName();
		quantity=cfDTO.getQuantity();
		quotationAmount=cfDTO.getQuotationAmount();
		unit=cfDTO.getUnit();
		offerBy=cfDTO.getOfferBy();
		bidId=cfDTO.getBidId();
		productId=cfDTO.getProductId();
		productName=cfDTO.getProductName();
		packaging=cfDTO.getPackaging();
		packagingId=cfDTO.getPackagingId();
		stateId=cfDTO.getStateId();
		stateName=cfDTO.getStateName();
		cityId=cfDTO.getCityId();
		cityName=cfDTO.getCityName();
		counterAmount=cfDTO.getCounterAmount();
		counterQuantity=cfDTO.getCounterQuantity();
		
		super.populateCommon(dto);
	}

}
