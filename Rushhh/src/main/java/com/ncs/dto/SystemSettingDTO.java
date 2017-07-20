package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "SYSTEM_SETTING")
public class SystemSettingDTO extends BaseDTO implements Serializable {

	@Column(name = "CONVERSION_FACTOR", length = 50)
	private String conversionFactor;

	@Column(name = "RECORDS_PER_PAGE", length = 50)
	private Long recordsPerPage;
	
	@Column(name = "SECUIRITY_AMOUNT", length = 50)
	private Double secuirityAmount;
	@Column(name = "UNIT", length = 50)
	private String unit;
	
	@Column(name = "QUANTITY", length = 50)
	private Double quantity;
	
	
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getSecuirityAmount() {
		return secuirityAmount;
	}

	public void setSecuirityAmount(Double secuirityAmount) {
		this.secuirityAmount = secuirityAmount;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public Long getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(Long recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("id", id);
		return uniqueAttributes;
	}
}