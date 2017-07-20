package com.ncs.dto;

import javax.persistence.Column;

import com.nenosystems.common.dto.BaseDTO;

public class FacebookDTO extends BaseDTO
{
	@Column(name = "FB_ID", length = 15)
	  private Long id;
	@Column(name = "FB_NAME", length = 50)
	 private String name;
	@Column(name = "FB_FIRSTNAME", length = 50)
	 private String firstName;
	@Column(name = "FB_LASTNAME", length = 50)
	 private String lastName;
	@Column(name = "FB_LINK", length = 50)
	 private String link;
	@Column(name = "FB_USERNAME", length = 50)
	 private String userName;
	@Column(name = "FB_EMAIL", length = 50)
	 private String email;
	@Column(name = "FB_PIC", length = 50)
	 private String pic;
	@Column(name = "FB_GENDER", length = 50)
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

public String getLastName() 
	{
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

public String getUserName() 
	{
		return userName;
	}

public void setUserName(String userName) 
	{
		this.userName = userName;
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

public String toString()
   {
    return 
    
      "FacebookDTO [id=" + this.id + ", name=" + this.name + ", firstName=" 
      + this.firstName + ", lastName=" + this.lastName + ", link=" + this.link 
      + ", fuserName=" + this.userName + ", email=" + this.email + ",gender=" + this.gender +"]";
  }
	
}
