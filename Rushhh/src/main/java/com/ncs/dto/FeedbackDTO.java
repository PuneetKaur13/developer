package com.ncs.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "FEEDBACK")
public class FeedbackDTO extends BaseDTO {
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "EMAIL", length = 50)
	private String email;
	
	@Column(name = "FEEDBACK", length = 70)
	private String feedback;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String getValue() {
		return name;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("name", name);
		return uniqueAttributes;
	}

}

