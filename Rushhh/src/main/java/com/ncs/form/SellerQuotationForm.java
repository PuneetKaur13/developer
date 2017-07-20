package com.ncs.form;

import java.sql.Timestamp;

import javax.persistence.Column;

import com.ncs.dto.SellerQuotationDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class SellerQuotationForm extends BaseForm {

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
	private Long sellerCompanyId;
	private String sellerCompanyName;
	private boolean isActive;
	private String status;
	private Boolean isCounter;
	private Double quantity;
	private String unit;
	private String packaging;
	private Long cityId;
	private String cityName;
	private Long stateId;
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

	public Boolean getIsCounter() {
		return isCounter;
	}

	public void setIsCounter(Boolean isCounter) {
		this.isCounter = isCounter;
	}
	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	@Override
	public BaseDTO makeDto() {
		SellerQuotationDTO sellerquotationdto = new SellerQuotationDTO();
		super.makeDto(sellerquotationdto);
		sellerquotationdto.setBidId(bidId);
		sellerquotationdto.setProductId(productId);
		sellerquotationdto.setProductName(productName);
		sellerquotationdto.setQuotationAmount(quotationAmount);
		sellerquotationdto.setDescription(description);
		sellerquotationdto.setSellerId(sellerId);
		sellerquotationdto.setSellerName(sellerName);
		sellerquotationdto.setCompanyId(companyId);
		sellerquotationdto.setCompanyName(companyName);
		sellerquotationdto.setPackaging(packaging);
		if (timestamp != null) {
			sellerquotationdto.setTimestamp(new Timestamp(DataUtil.convertDateFormat(timestamp).getTime()));
		}
		sellerquotationdto.setDate(DataUtil.convertDateFormat(date));
		sellerquotationdto.setSellerCompanyId(sellerCompanyId);
		sellerquotationdto.setSellerCompanyName(sellerCompanyName);
		sellerquotationdto.setActive(isActive);
		sellerquotationdto.setStatus(status);
		sellerquotationdto.setIsCounter(isCounter);
		sellerquotationdto.setQuantity(quantity);
		sellerquotationdto.setUnit(unit);
		sellerquotationdto.setCityId(cityId);
		sellerquotationdto.setCityName(cityName);
		sellerquotationdto.setStateId(stateId);
		sellerquotationdto.setStateName(stateName);
		
		return sellerquotationdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		SellerQuotationDTO sellerquotationdto = (SellerQuotationDTO) dto;
		bidId = sellerquotationdto.getBidId();
		productId = sellerquotationdto.getProductId();
		productName = sellerquotationdto.getProductName();
		quotationAmount = sellerquotationdto.getQuotationAmount();
		description = sellerquotationdto.getDescription();
		sellerId = sellerquotationdto.getSellerId();
		sellerName = sellerquotationdto.getSellerName();
		companyId = sellerquotationdto.getCompanyId();
		companyName = sellerquotationdto.getCompanyName();
		timestamp = DataUtil.convertDateToString(sellerquotationdto.getTimestamp());
		date = DataUtil.convertDateToString(sellerquotationdto.getDate());
		sellerCompanyId = sellerquotationdto.getSellerCompanyId();
		sellerCompanyName = sellerquotationdto.getSellerCompanyName();
		isActive = sellerquotationdto.isActive();
		status = sellerquotationdto.getStatus();
		isCounter = sellerquotationdto.getIsCounter();
		quantity=sellerquotationdto.getQuantity();
		unit=sellerquotationdto.getUnit();
		packaging=sellerquotationdto.getPackaging();
		cityId=sellerquotationdto.getCityId();
		cityName=sellerquotationdto.getCityName();
		stateId=sellerquotationdto.getStateId();
		stateName=sellerquotationdto.getStateName();
	}

}
