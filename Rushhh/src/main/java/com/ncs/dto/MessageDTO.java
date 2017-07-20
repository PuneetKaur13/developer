package com.ncs.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "MESSAGE")
public class MessageDTO extends BaseDTO implements Serializable{
	
	@Column(name = "TYPE", length = 50)
	private String type;
	@Column(name = "TITLE", length = 50)
	private String title;
	@Column(name = "MESSAGE", length = 500)
	private String message;
	@Column(name = "CODE", length = 500)
	private String code;
	@Column(name = "COUNTER", length = 500)
	private BigInteger Counter;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
