package com.ncs.action;

import com.ncs.dto.FeedbackDTO;
import com.ncs.form.FeedbackForm;
import com.ncs.services.FeedbackServiceI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nenosystems.common.action.BaseCtl;
import com.nenosystems.common.services.BaseServiceI;


@RestController
@RequestMapping(value = "rest/Feedback")
public class FeedbackCtl extends BaseCtl<FeedbackForm>{
	private static Logger log = Logger.getLogger(RoleCtl.class);

	@Override
	@Autowired
	@Qualifier("feedbackService")
	public void setService(BaseServiceI service) {
		this.service = service;
	}
	@Autowired
	private FeedbackServiceI feedbackServiceI;

}
