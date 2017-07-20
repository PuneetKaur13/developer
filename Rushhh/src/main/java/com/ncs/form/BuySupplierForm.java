package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.BuySupplierDTO;
import com.ncs.dto.SellSupplierDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class BuySupplierForm extends BaseForm {
	
	private Long userId;
	private String userName;
	private Long companyId;
	private String companyName;
	private Long productId;
	private String productName;
	private Long packagingId;
	private String packaging;
	
	
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
	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		BuySupplierDTO buySupplierDTO = new BuySupplierDTO();
		super.makeDto(buySupplierDTO);
		buySupplierDTO.setProductId(productId);
		buySupplierDTO.setProductName(productName);
		buySupplierDTO.setCompanyId(companyId);
		buySupplierDTO.setCompanyName(companyName);
		buySupplierDTO.setUserId(userId);
		buySupplierDTO.setUserName(userName);
		buySupplierDTO.setPackagingId(packagingId);
		buySupplierDTO.setPackaging(packaging);
		return buySupplierDTO;
	}
	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		BuySupplierDTO buySupplierDTO = (BuySupplierDTO) dto;
		productId=buySupplierDTO.getProductId();
		productName=buySupplierDTO.getProductName();
		companyId=buySupplierDTO.getCompanyId();
		companyName=buySupplierDTO.getCompanyName();
		userId=buySupplierDTO.getUserId();
		userName=buySupplierDTO.getUserName();
		packaging=buySupplierDTO.getPackaging();
		packagingId=buySupplierDTO.getPackagingId();
		super.populateCommon(dto);
	}


}
