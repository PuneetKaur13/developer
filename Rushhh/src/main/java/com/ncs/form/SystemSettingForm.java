package com.ncs.form;

import java.io.Serializable;

import com.ncs.dto.MessageDTO;
import com.ncs.dto.SystemSettingDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class SystemSettingForm extends BaseForm {

	private String conversionFactor;
	private Long recordsPerPage;
	private Double secuirityAmount;
	private Double quantity;
	private String unit;
	public Double getQuantity() {
		return quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		SystemSettingDTO cf = new SystemSettingDTO();
		super.makeDto(cf);
		cf.setConversionFactor(conversionFactor);
		cf.setRecordsPerPage(recordsPerPage);
		cf.setSecuirityAmount(secuirityAmount);
		cf.setQuantity(quantity);
		cf.setUnit(unit);

		return cf;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		SystemSettingDTO cf = (SystemSettingDTO) dto;
		conversionFactor = cf.getConversionFactor();
		recordsPerPage = cf.getRecordsPerPage();
		secuirityAmount = cf.getSecuirityAmount();
		quantity = cf.getQuantity();
		unit=cf.getUnit();
		super.populateCommon(dto);
	}
}
