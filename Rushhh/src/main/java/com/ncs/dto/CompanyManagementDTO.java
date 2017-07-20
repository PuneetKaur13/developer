package com.ncs.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "COMPANY_MANAGEMENT")
public class CompanyManagementDTO  extends BaseDTO implements Serializable{
	
	
	@Column(name = "COMPANY_NAME", length = 50)
	private String companyName;

	@Column(name = "COMPANY_ADDRESS", length = 250)
	private String companyAddress;
	
	@Column(name = "STATUS", length = 250)
	private String status;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getCompanyAddress() {
		return companyAddress;
	}
@Override
public String getValue() {
	// TODO Auto-generated method stub
	return companyName;
}


	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}



	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("companyName", companyName);
		return uniqueAttributes;
	}
	
}
