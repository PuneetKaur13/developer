package com.ncs.form;

import javax.persistence.Column;

import com.ncs.dto.CounterOfferDTO;
import com.ncs.dto.FacebookDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class FacebookForm  extends BaseForm
{

	 private Long id;
	 private String name;
	 private String firstName;
	 private String lastName;
	 private String link;
	 private String email;
	 private String pic;
	 private String gender;
	 
	 
     public Long getId() 
     {
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link) 
	{
		this.link = link;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPic() 
	{
		return pic;
	}

	public void setPic(String pic) 
	{
		this.pic = pic;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	@Override
	public BaseDTO makeDto() 
	{
	FacebookDTO fbDTO = new FacebookDTO();
	super.makeDto(fbDTO);
	fbDTO.setId(id);;
	fbDTO.setName(name);
	fbDTO.setFirstName(firstName);
	fbDTO.setLastName(lastName);
	fbDTO.setLink(link);
	fbDTO.setEmail(email);;
	fbDTO.setPic(pic);
	fbDTO.setGender(gender);
	return fbDTO;
	}

	@Override
	public void populate(BaseDTO dto) 
	{
		FacebookDTO fbDTO = (FacebookDTO) dto;
		id= fbDTO.getId();
		name = fbDTO.getName();
		firstName = fbDTO.getFirstName();
		lastName = fbDTO.getLastName();
		link = fbDTO.getLink();
		link = fbDTO.getEmail();
		pic = fbDTO.getPic();
		gender = fbDTO.getGender();
		
		super.populateCommon(dto);
		
	}

}
