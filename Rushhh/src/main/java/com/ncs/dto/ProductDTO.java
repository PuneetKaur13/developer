package com.ncs.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "PRODUCT")
public class ProductDTO extends BaseDTO implements Serializable {

	@Column(name = "ADMIN_PRODUCT_ID", length = 50)
	private Long adminProductId;
	@Column(name = "ADMIN_PRODUCT_NAME", length = 50)
	private String adminProductName;
	@Column(name = "BRAND_NAME", length = 50)
	private String brand;
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	@Column(name = "UNIT", length = 50)
	private String pkgUNit;
	@Column(name = "QUANTITY", length = 50)
	private String quantity;
	@Column(name = "IMAGE_PATH", length = 200)
	private String imagePath;
	@Column(name = "GRADE", length = 200)
	private String grade;
	@Column(name = "BUSINESS_LINE", length = 200)
	private String businessline;
	@Column(name = "MASTER_RATE", length = 200)
	private String masterrate;
	@Column(name = "EFFECT_FROM_DATE", length = 200)
	private Date effectfromdate;
	
	
	public Long getAdminProductId() {
		return adminProductId;
	}

	public void setAdminProductId(Long adminProductId) {
		this.adminProductId = adminProductId;
	}

	public String getAdminProductName() {
		return adminProductName;
	}

	public void setAdminProductName(String adminProductName) {
		this.adminProductName = adminProductName;
	}
	public String getPkgUNit() {
		return pkgUNit;
	}

	public void setPkgUNit(String pkgUNit) {
		this.pkgUNit = pkgUNit;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getBusinessline() {
		return businessline;
	}

	public void setBusinessline(String businessline) {
		this.businessline = businessline;
	}

	public String getMasterrate() {
		return masterrate;
	}

	public void setMasterrate(String masterrate) {
		this.masterrate = masterrate;
	}
	public Date getEffectfromdate() {
		return effectfromdate;
	}

	public void setEffectfromdate(Date effectfromdate) {
		this.effectfromdate = effectfromdate;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("adminProductName", adminProductName);
		return uniqueAttributes;
	}

}
