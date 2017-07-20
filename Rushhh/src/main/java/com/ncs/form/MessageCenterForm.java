package com.ncs.form;

import javax.persistence.Column;

import com.itextpdf.text.pdf.DefaultFontMapper.BaseFontParameters;
import com.ncs.dto.MessageCenterDTO;
import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class MessageCenterForm extends BaseForm {
	
	private String type;
	private String userType;
	private String message;
	private String productName;
	private String productType;
	private Long productId;
	
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		MessageCenterDTO messageCenterDTO = new MessageCenterDTO();
		super.makeDto(messageCenterDTO);
		messageCenterDTO.setType(type);
		messageCenterDTO.setMessage(message);
		messageCenterDTO.setUserType(userType);
		messageCenterDTO.setProductName(productName);
		messageCenterDTO.setProductType(productType);
		messageCenterDTO.setProductId(productId);
		return messageCenterDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		MessageCenterDTO messageCenterDTO = (MessageCenterDTO) dto;
		type=messageCenterDTO.getType();
		message=messageCenterDTO.getMessage();
		userType=messageCenterDTO.getUserType();
		productType=messageCenterDTO.getProductType();
		productName=messageCenterDTO.getProductName();
		productId=messageCenterDTO.getProductId();
		super.populateCommon(dto);
	}
}
