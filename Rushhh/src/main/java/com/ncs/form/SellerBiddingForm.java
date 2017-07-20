package com.ncs.form;

import com.ncs.dto.SellerBiddingDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class SellerBiddingForm extends BaseForm {

	private String type;
	private String companyName;
	private Long companyId;
	private String productName;
	private Double quantity;
	private String unit;
	private Long productId;
	private String startDate;
	private String enddate;
	private String expectedDeliveryDate;
	private String transportation;
	private String insurance;
	private String tax;
	private String packaging;
	private String description;
	private String status;
	private Double latitude;
	private Double longtitude;
	private Long sellerId;
	private String sellerName;
	private Long sellerCompanyId;
	private String sellerCompanyName;
	private Double quotationAmount;
	private String dealDate;
	private String address;
	private Double expectedAmount;
	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private int visitor;
	private String bidRefrenceNo;
	private Long packagingId;
	private String offerRefrenceNo;
	private String freezingType;
	private String rateNegotiable;
	private String utrNo;
	private String cropYear;
	private String cropMonth;
	

	public String getCropMonth() {
		return cropMonth;
	}

	public void setCropMonth(String cropMonth) {
		this.cropMonth = cropMonth;
	}

	public String getCropYear() {
		return cropYear;
	}

	public void setCropYear(String cropYear) {
		this.cropYear = cropYear;
	}

	public String getUtrNo() {
		return utrNo;
	}

	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}

	public String getFreezingType() {
		return freezingType;
	}

	public void setFreezingType(String freezingType) {
		this.freezingType = freezingType;
	}

	public String getRateNegotiable() {
		return rateNegotiable;
	}

	public void setRateNegotiable(String rateNegotiable) {
		this.rateNegotiable = rateNegotiable;
	}

	public String getBidRefrenceNo() {
		return bidRefrenceNo;
	}

	public void setBidRefrenceNo(String bidRefrenceNo) {
		this.bidRefrenceNo = bidRefrenceNo;
	}

	public String getOfferRefrenceNo() {
		return offerRefrenceNo;
	}

	public void setOfferRefrenceNo(String offerRefrenceNo) {
		this.offerRefrenceNo = offerRefrenceNo;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
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

	public Double getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(Double quotationAmount) {
		this.quotationAmount = quotationAmount;
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

	@Override
	public BaseDTO makeDto() {
		SellerBiddingDTO biddingdto = new SellerBiddingDTO();
		super.makeDto(biddingdto);
		biddingdto.setProductName(productName);
		biddingdto.setInsurance(insurance);
		biddingdto.setExpectedDeliveryDate(DataUtil.convertDateFormat(expectedDeliveryDate));
		biddingdto.setQuantity(quantity);
		biddingdto.setStartDate(DataUtil.convertDateFormat(startDate));
		biddingdto.setEnddate(DataUtil.convertDateFormat(enddate));
		biddingdto.setTransportation(transportation);
		biddingdto.setTax(tax);
		biddingdto.setProductId(productId);
		biddingdto.setType(type);
		biddingdto.setStatus(status);
		biddingdto.setLatitude(latitude);
		biddingdto.setLongtitude(longtitude);
		biddingdto.setPackaging(packaging);
		biddingdto.setCompanyId(companyId);
		biddingdto.setCompanyName(companyName);
		biddingdto.setSellerId(sellerId);
		biddingdto.setSellerName(sellerName);
		biddingdto.setSellerCompanyId(sellerCompanyId);
		biddingdto.setSellerCompanyName(sellerCompanyName);
		biddingdto.setQuotationAmount(quotationAmount);
		biddingdto.setDealDate(DataUtil.convertDateFormat(dealDate));
		biddingdto.setAddress(address);
		biddingdto.setDescription(description);
		biddingdto.setExpectedAmount(expectedAmount);
		biddingdto.setUnit(unit);
		biddingdto.setCityId(cityId);
		biddingdto.setCityName(cityName);
		biddingdto.setStateId(stateId);
		biddingdto.setStateName(stateName);
		biddingdto.setVisitor(visitor);
		biddingdto.setPackagingId(packagingId);
		biddingdto.setFreezingType(freezingType);
		biddingdto.setRateNegotiable(rateNegotiable);
		biddingdto.setUtrNo(utrNo);
		biddingdto.setCropYear(cropYear);
		biddingdto.setCropMonth(cropMonth);
		return biddingdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		SellerBiddingDTO biddingdto = (SellerBiddingDTO) dto;
		productName = biddingdto.getProductName();
		insurance = biddingdto.getInsurance();
		quantity = biddingdto.getQuantity();
		expectedDeliveryDate = DataUtil.convertDateToString(biddingdto.getExpectedDeliveryDate());
		startDate = DataUtil.convertDateToString(biddingdto.getStartDate());
		enddate = DataUtil.convertDateToString(biddingdto.getEnddate());
		transportation = biddingdto.getTransportation();
		productId = biddingdto.getProductId();
		type = biddingdto.getType();
		status = biddingdto.getStatus();
		tax = biddingdto.getTax();
		latitude = biddingdto.getLatitude();
		longtitude = biddingdto.getLongtitude();
		packaging = biddingdto.getPackaging();
		companyId = biddingdto.getCompanyId();
		companyName = biddingdto.getCompanyName();
		sellerId = biddingdto.getSellerId();
		sellerName = biddingdto.getSellerName();
		sellerCompanyId = biddingdto.getSellerCompanyId();
		sellerCompanyName = biddingdto.getSellerCompanyName();
		quotationAmount = biddingdto.getQuotationAmount();
		dealDate = DataUtil.convertDateToString(biddingdto.getDealDate());
		address = biddingdto.getAddress();
		description = biddingdto.getDescription();
		expectedAmount = biddingdto.getExpectedAmount();
		cityId=biddingdto.getCityId();
		cityName=biddingdto.getCityName();
		stateId=biddingdto.getStateId();
		stateName=biddingdto.getStateName();
		unit=biddingdto.getUnit();
		visitor=biddingdto.getVisitor();
		packagingId=biddingdto.getPackagingId();
		freezingType=biddingdto.getFreezingType();
		rateNegotiable=biddingdto.getRateNegotiable();
		utrNo=biddingdto.getUtrNo();
		cropYear=biddingdto.getCropYear();
		cropMonth=biddingdto.getCropMonth();
		super.populateCommon(biddingdto);
	}
}