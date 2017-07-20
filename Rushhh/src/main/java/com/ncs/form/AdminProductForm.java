package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.AdminProductDTO;
import com.ncs.dto.RoleDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class AdminProductForm extends BaseForm {
	private String name;
	private String unit;
	private String quantity;
	private String description;
	private Double secuirityAmount ;
	private String imagePath;
	

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Double getSecuirityAmount() {
		return secuirityAmount;
	}

	public void setSecuirityAmount(Double secuirityAmount) {
		this.secuirityAmount = secuirityAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public BaseDTO makeDto() {
		AdminProductDTO productdto = new AdminProductDTO();
		super.makeDto(productdto);
		productdto.setName(name);
		productdto.setDescription(description);
		productdto.setUnit(unit);
		productdto.setQuantity(quantity);
		productdto.setSecuirityAmount(secuirityAmount);
		productdto.setImagePath(imagePath);
		return productdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		AdminProductDTO productdto = (AdminProductDTO) dto;
		name = productdto.getName();
		description = productdto.getDescription();
		unit = productdto.getUnit();
		quantity = productdto.getQuantity();
		secuirityAmount=productdto.getSecuirityAmount();
		imagePath=productdto.getImagePath();
		super.populateCommon(dto);
	}
}
