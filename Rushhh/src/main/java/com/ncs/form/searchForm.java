package com.ncs.form;

import java.sql.Timestamp;
import java.util.List;

import com.nenosystems.common.action.NcsResponseData;

public class searchForm extends NcsResponseData {
	
	private String  productName;
	private String stateName;
	private String cityName;
	private String companyName;
	private Timestamp startDate;
	private Timestamp endDate;
	
	private List reportData=null;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public List getReportData() {
		return reportData;
	}

	public void setReportData(List reportData) {
		this.reportData = reportData;
	} 
}
