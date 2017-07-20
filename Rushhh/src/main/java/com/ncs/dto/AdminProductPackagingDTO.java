package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "ADMIN_PRODUCT_PACKAGING")
public class AdminProductPackagingDTO extends BaseDTO implements Serializable {

	@Column(name = "ADMIN_PRODUCT_ID", length = 50)
	private Long adminProductId;
	@Column(name = "ADMIN_PRODUCT_NAME", length = 50)
	private String adminProductName;
	@Column(name = "PACKAGING", length = 50)
	private String packaging;

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

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("adminProductId", adminProductId);
		addUniqueAttribute("&", "&");
		addUniqueAttribute("packaging", packaging);
		return uniqueAttributes;
	}
}
