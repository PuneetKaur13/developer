package com.ncs.form;

import java.math.BigInteger;

import com.ncs.dto.MessageDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class MessageForm extends BaseForm {

	private String type;
	private String title;
	private String message;
	private String code;
	private BigInteger Counter;
	
	
	
	public BigInteger getCounter() {
		return Counter;
	}

	public void setCounter(BigInteger counter) {
		Counter = counter;
	}

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
	

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		MessageDTO messagedto = new MessageDTO();
		super.makeDto(messagedto);
		messagedto.setType(type);
		messagedto.setTitle(title);
		messagedto.setMessage(message);
		messagedto.setCode(code);
		return messagedto;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		MessageDTO messagedto = (MessageDTO) dto;
		type=messagedto.getType();
		title=messagedto.getTitle();
		message=messagedto.getMessage();
		code=messagedto.getCode();
		super.populateCommon(dto);
	}
 }
