package com.ncs.dao;

import org.springframework.stereotype.Repository;

import com.ncs.dto.FeedbackDTO;
import com.nenosystems.common.dao.BaseDAOImpl;

@Repository("feedbackDAO")
public class FeedbackDAOImpl extends BaseDAOImpl implements FeedbackDAOI{
	public String getDtoName() {
		return "FeedbackDTO";
	}

	public Class dtoClass() {
		return FeedbackDTO.class;
	}
}
