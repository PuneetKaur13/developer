package com.ncs.form;

import com.ncs.dto.ProductDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class ProductForm extends BaseForm {

	private Long adminProductId;
	private String adminProductName;
	private String brand;
	private String description;
	private String quantity;
	private String pkgUNit;
	private String grade;
	private String businessline;
	private String masterrate;
	private String effectfromdate;
	
	
	private String imagePath;

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

	public String getPkgUNit() {
		return pkgUNit;
	}

	public void setPkgUNit(String pkgUNit) {
		this.pkgUNit = pkgUNit;
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



	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getEffectfromdate() {
		return effectfromdate;
	}

	public void setEffectfromdate(String effectfromdate) {
		this.effectfromdate = effectfromdate;
	}

	@Override
	public BaseDTO makeDto() {
		ProductDTO productdto = new ProductDTO();
		super.makeDto(productdto);
		productdto.setAdminProductId(adminProductId);
		productdto.setAdminProductName(adminProductName);
		productdto.setBrand(brand);
		productdto.setDescription(description);
		productdto.setQuantity(quantity);
		productdto.setPkgUNit(pkgUNit);
		productdto.setGrade(grade);
		productdto.setBusinessline(businessline);
		productdto.setMasterrate(masterrate);
		productdto.setEffectfromdate(DataUtil.convertDateFormat(effectfromdate));

		productdto.setImagePath(imagePath);
		return productdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		ProductDTO productdto = (ProductDTO) dto;
		adminProductId = productdto.getAdminProductId();
		adminProductName = productdto.getAdminProductName();
		brand = productdto.getBrand();
		description = productdto.getDescription();
		quantity = productdto.getQuantity();
		pkgUNit=productdto.getPkgUNit();
		grade = productdto.getGrade();
		businessline = productdto.getBusinessline();
		masterrate = productdto.getMasterrate();
		effectfromdate=  DataUtil.convertDateToString(productdto.getEffectfromdate());
	
		imagePath = productdto.getImagePath();
		super.populateCommon(productdto);
	}

	@Override
	public String toString() {
		return "ProductForm [adminProductId=" + adminProductId
				+ ", adminProductName=" + adminProductName + ", brand=" + brand
				+ ", description=" + description + ", quantity=" + quantity
				+ ", pkgUNit=" + pkgUNit + ", grade=" + grade
				+ ", businessline=" + businessline + ", masterrate="
				+ masterrate + ", effectfromdate=" + effectfromdate
				+ ", imagePath=" + imagePath + "]";
	}


}
