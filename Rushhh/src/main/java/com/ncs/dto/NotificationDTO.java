package com.ncs.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "NOTIFICATION")
public class NotificationDTO  extends BaseDTO implements Serializable {

	
	@Column(name = "NOT_SUBJECT", length = 50)
	private String subject;
	@Column(name = "NOT_MESSAGE", length = 50000000)
	private String message;
	@Column(name = "NOT_FROM", length = 500)
	private String from;
	@Column(name = "NOT_TO", length = 500)
	private String to;
	@Column(name = "SELLER_ID", length = 500)
	private Long sellerId;
	@Column(name = "BUYER_ID", length = 500)
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

}
