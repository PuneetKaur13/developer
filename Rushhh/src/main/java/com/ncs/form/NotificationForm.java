package com.ncs.form;

import com.ncs.dto.MessageDTO;
import com.ncs.dto.NotificationDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class NotificationForm  extends BaseForm{

	
	private String subject;
	private String message;
	private String from;
	private String to;
	private Long sellerId;
	private Long buyerId;
	

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		NotificationDTO notificationdto = new NotificationDTO();
		super.makeDto(notificationdto);
		notificationdto.setSubject(subject);
		notificationdto.setFrom(from);
		notificationdto.setTo(to);
		notificationdto.setMessage(message);
		notificationdto.setSellerId(sellerId);
		
		return notificationdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		NotificationDTO notificationdto = (NotificationDTO) dto;
		subject=notificationdto.getSubject();
		message=notificationdto.getMessage();
		from=notificationdto.getFrom();
		to=notificationdto.getTo();
		sellerId=notificationdto.getSellerId();
		super.populateCommon(dto);
	}
}
