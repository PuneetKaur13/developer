package com.ncs.form;

import java.util.Arrays;

import javax.persistence.Column;

import com.ncs.dto.OrganizationDTO;
import com.ncs.dto.PreferredSupplierDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class PreferredSupplierForm extends BaseForm {

	private Long productId;
	
	private String productName;

	private Long companyId;

	private String companyName;
	
	private String buyerSelectedIdArray[];
	
	private Long userId;

	private String userName;
	
	private Long bidId;
	
	private String status;
	
	private Boolean isRequest;
	
	
	public Boolean getIsRequest() {
		return isRequest;
	}

	public void setIsRequest(Boolean isRequest) {
		this.isRequest = isRequest;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		PreferredSupplierDTO pdto = new PreferredSupplierDTO();
		super.makeDto(pdto);
		pdto.setProductId(productId);
		pdto.setProductName(productName);
		pdto.setCompanyId(companyId);
		pdto.setCompanyName(companyName);
		pdto.setBuyerSelectedId(Arrays.toString(buyerSelectedIdArray));
		pdto.setUserId(userId);
		pdto.setUserName(userName);
		pdto.setBidId(bidId);
		pdto.setStatus(status);
		pdto.setIsRequest(isRequest);
		return pdto;
	}
	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		PreferredSupplierDTO pdto = (PreferredSupplierDTO) dto;
		productId=pdto.getProductId();
		productName=pdto.getProductName();
		companyId=pdto.getCompanyId();
		companyName=pdto.getCompanyName();
		buyerSelectedIdArray=pdto.getBuyerSelectedId().split(",");
		userId=pdto.getUserId();
		userName=pdto.getUserName();
		bidId=pdto.getBidId();
		status=pdto.getStatus();
		isRequest=pdto.getIsRequest();
		super.populateCommon(dto);
	}
}
