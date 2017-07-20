package com.ncs.form;

import com.ncs.dto.FeedbackDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class FeedbackForm extends BaseForm {

	private String name;

	private String email;

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
	public BaseDTO makeDto() {
		FeedbackDTO feedbackdto = new FeedbackDTO();
		super.makeDto(feedbackdto);
		feedbackdto.setName(name);
		feedbackdto.setEmail(email);
		feedbackdto.setFeedback(feedback);
		return feedbackdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		FeedbackDTO feedbackdto = (FeedbackDTO)dto;
		name = feedbackdto.getName();
		email = feedbackdto.getEmail();
		feedback = feedbackdto.getFeedback();
		super.populateCommon(dto);
	}

}
