package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "ADMIN_PRODUCT")
public class AdminProductDTO extends BaseDTO implements Serializable {
	@Column(name = "PRODUCT_NAME", length = 50)
	private String name;
	@Column(name = "UNIT", length = 50)
	private String unit;
	@Column(name = "quantity", length = 50)
	private String quantity;
	@Column(name = "SECUIRITY_AMOUNT", length = 200)
	private Double secuirityAmount;
	@Column(name = "PRODUCT_DESCRIPTION", length = 200)
	private String description;
	@Column(name = "IMAGE_PATH", length = 250)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("name", name);
		return uniqueAttributes;
	}

}
