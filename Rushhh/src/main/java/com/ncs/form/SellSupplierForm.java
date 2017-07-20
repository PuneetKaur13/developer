package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.PreferredSupplierDTO;
import com.ncs.dto.SellSupplierDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class SellSupplierForm extends BaseForm {

	private Long userId;
	private String userName;
	private Long companyId;
	private String companyName;
	private Long productId;
	private String productName;

	private Long favCompanyId;
	private String favCompanyName;
	private Long favGroupId;
	private String favGroupIdString;



	public String getFavCompanyName() {
		return favCompanyName;
	}

	public void setFavCompanyName(String favCompanyName) {
		this.favCompanyName = favCompanyName;
	}


	public String getFavGroupIdString() {
		return favGroupIdString;
	}

	public void setFavGroupIdString(String favGroupIdString) {
		this.favGroupIdString = favGroupIdString;
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

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		SellSupplierDTO sellSupplierDTO = new SellSupplierDTO();
		super.makeDto(sellSupplierDTO);
		sellSupplierDTO.setProductId(productId);
		sellSupplierDTO.setProductName(productName);
		sellSupplierDTO.setCompanyId(companyId);
		sellSupplierDTO.setCompanyName(companyName);
		sellSupplierDTO.setUserId(userId);
		sellSupplierDTO.setUserName(userName);
		sellSupplierDTO.setFavCompanyId(favCompanyId);
		sellSupplierDTO.setFavCompanyName(favCompanyName);
		sellSupplierDTO.setFavGroupId(favGroupId);
		sellSupplierDTO.setFavGroupIdString(favGroupIdString);

		return sellSupplierDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		SellSupplierDTO sellSupplierDTO = (SellSupplierDTO) dto;
		productId = sellSupplierDTO.getProductId();
		productName = sellSupplierDTO.getProductName();
		companyId = sellSupplierDTO.getCompanyId();
		companyName = sellSupplierDTO.getCompanyName();
		userId = sellSupplierDTO.getUserId();
		userName = sellSupplierDTO.getUserName();
	
		favCompanyId = sellSupplierDTO.getFavCompanyId();
		favCompanyName = sellSupplierDTO.getFavCompanyName();
		favGroupId = sellSupplierDTO.getFavGroupId();
		favGroupIdString = sellSupplierDTO.getFavGroupIdString();

		super.populateCommon(dto);
	}
}
