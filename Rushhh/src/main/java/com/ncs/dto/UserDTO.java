package com.ncs.dto;

import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.util.JsonDateSerializer;

@Entity
@Table(name = "USER")
public class UserDTO extends BaseDTO {

	public static final String ACTIVE = "ACTIVE";
	public static final String DEACTIVE = "DEACTIVE";
	public static final String LOCKED = "locked";
	public static final String APPROVED = "APPROVED";
	public static final String DISAPPROVED = "DISAPPROVED";

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "LOGIN_ID", length = 50)
	private String loginId;

	@Column(name = "USER_COMPANY_ID", length = 50)
	private Long userCompanyId;

	@Column(name = "PASSWORD", length = 50)
	private String password;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "CARD_ID", length = 100)
	private Long cardId;

	@Column(name = "CARD_TYPE", length = 100)
	private String cardType;

	@Column(name = "OTP", length = 50)
	private String otp;


	@Column(name = "IMAGE_ID")
	private Long imageId = new Long(0);

	@Column(name = "COMPANY_TYPE", length = 50)
	private String companyType;

	/**
	 * Organization ID
	 */
	@Column(name = "ORG_ID")
	private Long orgId;

	/**
	 * Y/N Only power user can create organization and groups under him. Normal
	 * user can not create organization and groups under him.
	 */
	@Column(name = "POWER_USER", length = 20)
	private String powerUser;

	/**
	 * Time interval enforce to change password 0 - Never, 7 - After A Week, 15
	 * - After 2 weeks, 30 - After a month, 90 - After 3 months
	 */
	@Column(name = "PWD_CHANGE_AFTER")
	private Integer pwdChangeAfter;

	/**
	 * Active - user is active and can login in application Deactive - user has
	 * left organization Locked - User is locked due to unsuccessful login
	 * attempts or some other reason
	 */
	private byte[] file1;

	@Column(name = "STATUS", length = 20)
	private String status;

	/**
	 * Last login date and time
	 */
	@Column(name = "LAST_LOGIN_AT")
	private Timestamp lastLogin;

	/**
	 * How many time user has entered incorrect password
	 */
	@Column(name = "UNSUCCESSFUL_LOGIN_ATTEMPT")
	private Integer unsucessfullLoginAttempt = 0;

	/**
	 * User status will be active after this date
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "VALID_FROM_DATE")
	private Date validFromDate;

	/**
	 * User will be deactivted after this date
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	@Column(name = "VALID_TO_DATE")
	private Date validToDate;

	/**
	 * User can login only after this time
	 */
	@Column(name = "ACCESS_TIME_FROM")
	private Time accessTimeFrom;

	/**
	 * User can login only before this time
	 */
	@Column(name = "ACCESS_TIME_TO")
	private Time accessTimeTo;

	/**
	 * User picture, file/contentType/filename are userd by Strts2 to upload an
	 * file
	 */

	@Column(name = "REGISTERED_IP", length = 20)
	private String registeredIP;

	@Column(name = "LAST_LOGIN_IP", length = 20)
	private String lastLoginIP;

	private File file;

	private String contentType;

	@Column(name = "FILE_NAME", length = 30)
	private String filename;

	/**
	 * Force user to change password at first login value - Y/N
	 */
	@Column(name = "FORCE_PASSWORD_CHANGE", length = 1)
	private String forcePasswordToChange;

	@Column(name = "USER_COMPANY", length = 30)
	private String userCompany;

	/**
	 * Contains Role Name, same as roleCode
	 */
	@Column(name = "ROLE_NAME", length = 50)
	private String roleName = null;

	/**
	 * A user may have multiple roles
	 */
	@Transient
	private Set userRoles = null;

	/**
	 * User group just like LDAP directory
	 */
	/*
	 * @Column(name = "ROLE_NAME", length = 50) private Long groupId;
	 */
	/**
	 * User primary role ID
	 */
	@Column(name = "ROLE_ID")
	private Long roleId;

	/**
	 * User primary Role Name
	 */
	@Column(name = "ROLE_CODE", length = 50)
	private String roleCode;

	/**
	 * Future use
	 */
	@Column(name = "ENTITY_ID")
	private Long entityId;

	/**
	 * Future use
	 */
	@Column(name = "ENTITY_NAME", length = 50)
	private String entityName;

	/**
	 * Address details
	 */
	@Column(name = "STREET", length = 50)
	private String street;

	@Column(name = "CITY")
	private Long city;

	@Column(name = "STATE")
	private Long state;

	@Column(name = "COUNTERY")
	private Long country;

	@Column(name = "PHONE", length = 50)
	private String phone;

	@Column(name = "FAX", length = 50)
	private String fax;

	@Column(name = "MOBILE", length = 50)
	private String mobile;

	@Column(name = "URL", length = 50)
	private String url;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER", length = 10)
	private String gender;

	@Column(name = "IMAGE_PATH", length = 250)
	private String imagePath;
	
	@Column(name = "SMS_LIMIT", length = 250)
	private static Integer smsLimit=1 ;
	
	@Column(name = "CARD_REFERENCE_NO", length = 100)
	private String cardReferenceNo;
	
        @Transient
	private CardTypeDTO cardTypeDTO;

	public String getCardReferenceNo() {
		return cardReferenceNo;
	}

	public void setCardReferenceNo(String cardReferenceNo) {
		this.cardReferenceNo = cardReferenceNo;
	}
	

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getForcePasswordToChange() {
		return forcePasswordToChange;
	}

	public void setForcePasswordToChange(String forcePasswordToChange) {
		this.forcePasswordToChange = forcePasswordToChange;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userRoles
	 */
	public Set getUserRoles() {
		return userRoles;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @param userRoles
	 *            the userRoles to set
	 */
	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	public String userDescription() {

		return lastName + " " + firstName;
	}

	public String userKey() {
		return firstName + " " + lastName;
	}

	public String userValue() {
		return firstName + " " + lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPwdChangeAfter() {
		return pwdChangeAfter;
	}

	public void setPwdChangeAfter(Integer pwdChangeAfter) {
		this.pwdChangeAfter = pwdChangeAfter;
	}

	public boolean hasValidateDate() {
		boolean flag = true;

		return flag;

	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getUnsucessfullLoginAttempt() {
		return unsucessfullLoginAttempt;
	}

	public void setUnsucessfullLoginAttempt(int unsucessfullLoginAttempt) {
		this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public Time getAccessTimeFrom() {
		return accessTimeFrom;
	}

	public void setAccessTimeFrom(Time accessTimeFrom) {
		this.accessTimeFrom = accessTimeFrom;
	}

	public Time getAccessTimeTo() {
		return accessTimeTo;
	}

	public void setAccessTimeTo(Time accessTimeTo) {
		this.accessTimeTo = accessTimeTo;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getFile1() {
		return file1;
	}

	public void setFile1(byte[] file1) {
		this.file1 = file1;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getPowerUser() {
		return powerUser;
	}

	public void setPowerUser(String powerUser) {
		this.powerUser = powerUser;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompanyType() {
		return companyType;
	}

	public Long getUserCompanyId() {
		return userCompanyId;
	}

	public void setUserCompanyId(Long userCompanyId) {
		this.userCompanyId = userCompanyId;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
		this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
	}

	public CardTypeDTO getCardTypeDTO() {
		return cardTypeDTO;
	}

	public void setCardTypeDTO(CardTypeDTO cardTypeDTO) {
		this.cardTypeDTO = cardTypeDTO;
	}
	
	

	public Integer getSmsLimit() {
		return smsLimit;
	}

	public void setSmsLimit(Integer smsLimit) {
		this.smsLimit = smsLimit;
	}

	@Override
	public List<Object[]> getUniqueAttributes() {
		addUniqueAttribute("loginId", loginId);
		addUniqueAttribute("&", "&");
		addUniqueAttribute("mobile", mobile);
		return uniqueAttributes;
	}

	public String userName() {
		if (firstName != null && lastName != null)
			return firstName + " " + lastName;
		if (firstName != null)
			return firstName;
		if (lastName != null)
			return lastName;
		return null;
	}
	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId
				+ ", userCompanyId=" + userCompanyId + ", password=" + password + ", email=" + email + ", cardId="
				+ cardId + ", cardType=" + cardType + ", otp=" + otp + ", imageId=" + imageId + ", companyType="
				+ companyType + ", orgId=" + orgId + ", powerUser=" + powerUser + ", pwdChangeAfter=" + pwdChangeAfter
				+ ", file1=" + Arrays.toString(file1) + ", status=" + status + ", lastLogin=" + lastLogin
				+ ", unsucessfullLoginAttempt=" + unsucessfullLoginAttempt + ", validFromDate=" + validFromDate
				+ ", validToDate=" + validToDate + ", accessTimeFrom=" + accessTimeFrom + ", accessTimeTo="
				+ accessTimeTo + ", registeredIP=" + registeredIP + ", lastLoginIP=" + lastLoginIP + ", file=" + file
				+ ", contentType=" + contentType + ", filename=" + filename + ", forcePasswordToChange="
				+ forcePasswordToChange + ", userCompany=" + userCompany + ", roleName=" + roleName + ", userRoles="
				+ userRoles + ", roleId=" + roleId + ", roleCode=" + roleCode + ", entityId=" + entityId
				+ ", entityName=" + entityName + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", phone=" + phone + ", fax=" + fax + ", mobile=" + mobile + ", url=" + url
				+ ", dob=" + dob + ", gender=" + gender + ", imagePath=" + imagePath + ", cardTypeDTO=" + cardTypeDTO
				+ ", id=" + id + "]";
	}

}
