package com.ncs.form;

import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import com.ncs.dto.CardTypeDTO;
import com.ncs.dto.UserDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;
import com.nenosystems.common.util.DataUtil;

public class UserForm extends BaseForm {

	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private String confirmPassword;
	private String newPassword;
	private String email;
	private String confirmEmail;
	private Long cardId;
	private String cardType;
	private Long imageId = new Long(0);
	private Long orgId;
	private String powerUser;
	private Integer pwdChangeAfter;
	private byte[] file1;
	private String status;
	private Timestamp lastLogin;
	private Integer unsucessfullLoginAttempt = 0;
	private Date validFromDate;
	private Date validToDate;
	private Time accessTimeFrom;
	private Time accessTimeTo;
	private String registeredIP;
	private String lastLoginIP;
	private File file;
	private String contentType;
	private String filename;
	private String forcePasswordToChange;
	private String roleName = null;
	private Set userRoles = null;
	private Long roleId;
	private String roleCode;
	private Long entityId;
	private String entityName;
	private String street;
	private Long city;
	private Long state;
	private Long country;
	private String phone;
	private String fax;
	private String mobile;
	private String url;
	private String dob;
	private String gender;
	private String imagePath;
	private Long groupId;
	private String otp;
	private CompanyForm company;
	private String userCompany;
	private CardTypeForm cardTypeForm;
	private static Integer smsLimit;
	private String cardReferenceNo;

	public String getCardReferenceNo() {
		return cardReferenceNo;
	}

	public void setCardReferenceNo(String cardReferenceNo) {
		this.cardReferenceNo = cardReferenceNo;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	private String companyType;
	private Long userCompanyId;

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

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public CompanyForm getCompany() {
		return company;
	}

	public void setCompany(CompanyForm company) {
		this.company = company;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
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

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
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

	public Integer getPwdChangeAfter() {
		return pwdChangeAfter;
	}

	public void setPwdChangeAfter(Integer pwdChangeAfter) {
		this.pwdChangeAfter = pwdChangeAfter;
	}

	public byte[] getFile1() {
		return file1;
	}

	public void setFile1(byte[] file1) {
		this.file1 = file1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getUnsucessfullLoginAttempt() {
		return unsucessfullLoginAttempt;
	}

	public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
		this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set getUserRoles() {
		return userRoles;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public CardTypeForm getCardTypeForm() {
		return cardTypeForm;
	}

	public void setCardTypeForm(CardTypeForm cardTypeForm) {
		this.cardTypeForm = cardTypeForm;
	}

	public Integer getSmsLimit() {
		return smsLimit;
	}

	public void setSmsLimit(Integer smsLimit) {
		this.smsLimit = smsLimit;
	}

	@Override
	public BaseDTO makeDto() {
		UserDTO userdto = new UserDTO();
		super.makeDto(userdto);
		userdto.setFirstName(firstName);
		userdto.setLastName(lastName);
		userdto.setLoginId(loginId);
		if (password != null) {
			userdto.setPassword(DataUtil.encodeString(password));
		}
		userdto.setEmail(email);
		userdto.setCardId(cardId);
		userdto.setCardType(cardType);
		userdto.setRoleId(roleId);
		userdto.setRoleName(roleName);
		userdto.setDob(DataUtil.convertDateFormat(dob));
		userdto.setStatus(status);
		userdto.setMobile(mobile);
		userdto.setGender(gender);
		userdto.setImagePath(imagePath);
		userdto.setGroupId(groupId);
		userdto.setOtp(otp);
		userdto.setUserCompany(userCompany);
		userdto.setCompanyType(companyType);
		userdto.setUserCompanyId(userCompanyId);
		userdto.setSmsLimit(smsLimit);
		userdto.setCardReferenceNo(cardReferenceNo);
		if (cardTypeForm != null && cardTypeForm.getId() > 0) {
			CardTypeDTO cardTypeDTO = (CardTypeDTO) cardTypeForm.makeDto();
			userdto.setCardTypeDTO(cardTypeDTO);
		}

		return userdto;
	}

	@Override
	public void populate(BaseDTO dto) {
		UserDTO userdto = (UserDTO) dto;
		firstName = userdto.getFirstName();
		lastName = userdto.getLastName();
		loginId = userdto.getLoginId();
		password = DataUtil.decodeString(userdto.getPassword());
		mobile = userdto.getMobile();
		email = userdto.getEmail();
		cardType = userdto.getCardType();
		roleId = userdto.getRoleId();
		roleName = userdto.getRoleName();
		status = userdto.getStatus();
		dob = DataUtil.convertDateToString(userdto.getDob());
		gender = userdto.getGender();
		mobile = userdto.getMobile();
		imagePath = userdto.getImagePath();
		groupId = userdto.getGroupId();
		otp = userdto.getOtp();
		userCompany = userdto.getUserCompany();
		companyType = userdto.getCompanyType();
		userCompanyId = userdto.getUserCompanyId();
		smsLimit = userdto.getSmsLimit();
		cardReferenceNo = userdto.getCardReferenceNo();
		super.populateCommon(userdto);
	}

}
