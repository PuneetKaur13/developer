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
@Table(name = "SELLER_BID")
public class SellerBiddingDTO extends BaseDTO implements Serializable {

	@Column(name = "TYPE", length = 50)
	private String type;
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
	@Column(name = "TAX")
	private String tax;
	@Column(name = "PACKAGING")
	private String packaging;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "LONGTITUDE")
	private Double longtitude;
	@Column(name = "LATITUDE")
	private Double latitude;
	@Column(name = "SELLER_ID", length = 50)
	private Long sellerId;
	@Column(name = "SELLER_NAME", length = 50)
	private String sellerName;
	@Column(name = "SELLER_COMPANY_ID")
	private Long sellerCompanyId;
	@Column(name = "SELLER_COMPANY_NAME")
	private String sellerCompanyName;
	@Column(name = "QUOTATION_AMOUNT", length = 50)
	private Double quotationAmount;
	@Column(name = "DEAL_DATE")
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
	@Column(name = "BID_REFRENCE", length = 50)
	private String bidRefrenceNo;
	@Column(name = "OFFER_REFRENCE_NO", length = 50)
	private String offerRefrenceNo;
	@Column(name = "FREEZING_TYPE", length = 50)
	private String freezingType;
	@Column(name = "RATE_NEGOTIABLE", length = 50)
	private String rateNegotiable;
	@Column(name = "UTR_NO", length = 50)
	private String utrNo;
	@Column(name = "CROP_YEAR", length = 50)
	private String cropYear;
	@Column(name = "CROP_MONTH", length = 50)
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
	public String toString() {
		return "SellerBiddingDTO [type=" + type + ", companyName=" + companyName + ", companyId=" + companyId
				+ ", productName=" + productName + ", productId=" + productId + ", quantity=" + quantity
				+ ", startDate=" + startDate + ", enddate=" + enddate + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", transportation=" + transportation + ", insurance=" + insurance + ", tax=" + tax + ", packaging="
				+ packaging + ", description=" + description + ", status=" + status + ", address=" + address
				+ ", longtitude=" + longtitude + ", latitude=" + latitude + ", sellerId=" + sellerId + ", sellerName="
				+ sellerName + ", sellerCompanyId=" + sellerCompanyId + ", sellerCompanyName=" + sellerCompanyName
				+ ", quotationAmount=" + quotationAmount + ", dealDate=" + dealDate + ", expectedAmount="
				+ expectedAmount + "]";

	}

}