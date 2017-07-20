package com.ncs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "CARD_TYPE")
public class CardTypeDTO extends BaseDTO {

	@Column(name = "NAME", length = 100)
	private String name;
	@Column(name = "POINTS", length = 100)
	private Double points;
	@Column(name = "CONVERSION_FACTOR", length = 100)
	private Double conversionFactor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(Double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	@Override
	public String toString() {
		return "CardTypeDTO [id=" + id + ",name=" + name + ", points=" + points + ", conversionFactor="
				+ conversionFactor + "]";
	}

}
