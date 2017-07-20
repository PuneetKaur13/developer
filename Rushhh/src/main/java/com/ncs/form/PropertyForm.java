package com.ncs.form;

import com.ncs.dto.PropertyDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class PropertyForm extends BaseForm {

	private String personType;
	private String personFirstName;
	private String personLastName;
	private String personEmail;
	private String personMobileNo;

	private String propertyBriefDesciption;
	private String propertyStatus;
	private String propertyType;
	private String propertyFor;
	private String propertyDescriptionType;

	private Long cityId;
	private String cityName;
	private Long stateId;
	private String stateName;
	private Long pincode;
	private Double latitude;
	private Double longitude;

	private String locality;
	private String sublocality;
	private String nameOfSociety;
	private String address;
	private String landmark;

	private String area;
	private String areaType;

	private String carpetArea;
	private String carpetAreaType;

	private String bedrooms;
	private String bathrooms;
	private String balconies;

	private String pentries;
	private String cafeteria;

	private String furnishingType;

	private Integer totalFloors;
	private String directionFacing;

	private Double propertyPrice;

	private String imagePath1;
	private String imagePath2;
	private String imagePath3;
	private String imagePath4;
	private String imagePath5;

	private String description;
	private String status;

	private Integer noOfOpenSides;
	private Double widthOfRealFacing;
	private String boundaryWall;
	private Double plotArea;
	private String plotAreaType;
	private Double plotLength;
	private Double plotBreadth;

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getPersonFirstName() {
		return personFirstName;
	}

	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getPropertyBriefDesciption() {
		return propertyBriefDesciption;
	}

	public void setPropertyBriefDesciption(String propertyBriefDesciption) {
		this.propertyBriefDesciption = propertyBriefDesciption;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getPersonMobileNo() {
		return personMobileNo;
	}

	public void setPersonMobileNo(String personMobileNo) {
		this.personMobileNo = personMobileNo;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyFor() {
		return propertyFor;
	}

	public void setPropertyFor(String propertyFor) {
		this.propertyFor = propertyFor;
	}

	public String getPropertyDescriptionType() {
		return propertyDescriptionType;
	}

	public void setPropertyDescriptionType(String propertyDescriptionType) {
		this.propertyDescriptionType = propertyDescriptionType;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getSublocality() {
		return sublocality;
	}

	public void setSublocality(String sublocality) {
		this.sublocality = sublocality;
	}

	public String getNameOfSociety() {
		return nameOfSociety;
	}

	public void setNameOfSociety(String nameOfSociety) {
		this.nameOfSociety = nameOfSociety;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getCarpetArea() {
		return carpetArea;
	}

	public void setCarpetArea(String carpetArea) {
		this.carpetArea = carpetArea;
	}

	public String getCarpetAreaType() {
		return carpetAreaType;
	}

	public void setCarpetAreaType(String carpetAreaType) {
		this.carpetAreaType = carpetAreaType;
	}

	public String getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(String bedrooms) {
		this.bedrooms = bedrooms;
	}

	public String getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(String bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getBalconies() {
		return balconies;
	}

	public void setBalconies(String balconies) {
		this.balconies = balconies;
	}

	public String getPentries() {
		return pentries;
	}

	public void setPentries(String pentries) {
		this.pentries = pentries;
	}

	public String getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(String cafeteria) {
		this.cafeteria = cafeteria;
	}

	public String getFurnishingType() {
		return furnishingType;
	}

	public void setFurnishingType(String furnishingType) {
		this.furnishingType = furnishingType;
	}

	public Integer getTotalFloors() {
		return totalFloors;
	}

	public void setTotalFloors(Integer totalFloors) {
		this.totalFloors = totalFloors;
	}

	public String getDirectionFacing() {
		return directionFacing;
	}

	public void setDirectionFacing(String directionFacing) {
		this.directionFacing = directionFacing;
	}

	public Double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(Double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public String getImagePath1() {
		return imagePath1;
	}

	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}

	public String getImagePath2() {
		return imagePath2;
	}

	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}

	public String getImagePath3() {
		return imagePath3;
	}

	public void setImagePath3(String imagePath3) {
		this.imagePath3 = imagePath3;
	}

	public String getImagePath4() {
		return imagePath4;
	}

	public void setImagePath4(String imagePath4) {
		this.imagePath4 = imagePath4;
	}

	public String getImagePath5() {
		return imagePath5;
	}

	public void setImagePath5(String imagePath5) {
		this.imagePath5 = imagePath5;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNoOfOpenSides() {
		return noOfOpenSides;
	}

	public void setNoOfOpenSides(Integer noOfOpenSides) {
		this.noOfOpenSides = noOfOpenSides;
	}

	public Double getWidthOfRealFacing() {
		return widthOfRealFacing;
	}

	public void setWidthOfRealFacing(Double widthOfRealFacing) {
		this.widthOfRealFacing = widthOfRealFacing;
	}

	public String getBoundaryWall() {
		return boundaryWall;
	}

	public void setBoundaryWall(String boundaryWall) {
		this.boundaryWall = boundaryWall;
	}

	public Double getPlotArea() {
		return plotArea;
	}

	public void setPlotArea(Double plotArea) {
		this.plotArea = plotArea;
	}

	public String getPlotAreaType() {
		return plotAreaType;
	}

	public void setPlotAreaType(String plotAreaType) {
		this.plotAreaType = plotAreaType;
	}

	public Double getPlotLength() {
		return plotLength;
	}

	public void setPlotLength(Double plotLength) {
		this.plotLength = plotLength;
	}

	public Double getPlotBreadth() {
		return plotBreadth;
	}

	public void setPlotBreadth(Double plotBreadth) {
		this.plotBreadth = plotBreadth;
	}

	@Override
	public BaseDTO makeDto() {
		PropertyDTO propertyDTO = new PropertyDTO();
		super.makeDto(propertyDTO);

		propertyDTO.setPersonType(personType);
		propertyDTO.setPersonFirstName(personFirstName);
		propertyDTO.setPersonLastName(personLastName);
		propertyDTO.setPersonEmail(personEmail);
		propertyDTO.setPersonMobileNo(personMobileNo);

		propertyDTO.setPropertyType(propertyType);
		propertyDTO.setPropertyFor(propertyFor);
		propertyDTO.setPropertyDescriptionType(propertyDescriptionType);
		propertyDTO.setPropertyBriefDesciption(propertyBriefDesciption);
		propertyDTO.setPropertyStatus(propertyStatus);

		propertyDTO.setCityId(cityId);
		propertyDTO.setCityName(cityName);
		propertyDTO.setStateId(stateId);
		propertyDTO.setStateName(stateName);
		propertyDTO.setPincode(pincode);
		propertyDTO.setLatitude(latitude);
		propertyDTO.setLongitude(longitude);

		propertyDTO.setLocality(locality);
		propertyDTO.setSublocality(sublocality);
		propertyDTO.setNameOfSociety(nameOfSociety);
		propertyDTO.setAddress(address);
		propertyDTO.setAddress(address);
		propertyDTO.setAddress(address);
		propertyDTO.setLandmark(landmark);

		propertyDTO.setArea(area);
		propertyDTO.setAreaType(areaType);
		propertyDTO.setCarpetArea(carpetArea);
		propertyDTO.setCarpetAreaType(carpetAreaType);

		propertyDTO.setBedrooms(bedrooms);
		propertyDTO.setBathrooms(bathrooms);
		propertyDTO.setBalconies(balconies);
		propertyDTO.setPentries(pentries);
		propertyDTO.setCafeteria(cafeteria);

		propertyDTO.setFurnishingType(furnishingType);
		propertyDTO.setTotalFloors(totalFloors);
		propertyDTO.setDirectionFacing(directionFacing);
		propertyDTO.setPropertyPrice(propertyPrice);

		propertyDTO.setImagePath1(imagePath1);
		propertyDTO.setImagePath2(imagePath2);
		propertyDTO.setImagePath3(imagePath3);
		propertyDTO.setImagePath4(imagePath4);
		propertyDTO.setImagePath5(imagePath5);

		propertyDTO.setDescription(description);
		propertyDTO.setStatus(status);

		propertyDTO.setNoOfOpenSides(noOfOpenSides);
		propertyDTO.setWidthOfRealFacing(widthOfRealFacing);
		propertyDTO.setBoundaryWall(boundaryWall);
		propertyDTO.setPlotArea(plotArea);
		propertyDTO.setPlotAreaType(plotAreaType);
		propertyDTO.setPlotLength(plotLength);
		propertyDTO.setPlotBreadth(plotBreadth);
		return propertyDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		PropertyDTO propertyDTO = (PropertyDTO) dto;
		personType = propertyDTO.getPersonType();
		personFirstName = propertyDTO.getPersonFirstName();
		personLastName = propertyDTO.getPersonLastName();
		personEmail = propertyDTO.getPersonEmail();
		personMobileNo = propertyDTO.getPersonMobileNo();

		propertyType = propertyDTO.getPropertyType();
		propertyFor = propertyDTO.getPropertyFor();
		propertyDescriptionType = propertyDTO.getPropertyDescriptionType();
		propertyBriefDesciption = propertyDTO.getPropertyBriefDesciption();
		propertyStatus = propertyDTO.getPropertyStatus();

		cityId = propertyDTO.getCityId();
		cityName = propertyDTO.getCityName();
		stateId = propertyDTO.getStateId();
		stateName = propertyDTO.getStateName();
		pincode = propertyDTO.getPincode();
		latitude = propertyDTO.getLatitude();
		longitude = propertyDTO.getLongitude();

		address = propertyDTO.getAddress();
		landmark = propertyDTO.getLandmark();

		area = propertyDTO.getArea();
		areaType = propertyDTO.getAreaType();

		carpetArea = propertyDTO.getCarpetArea();
		carpetAreaType = propertyDTO.getCarpetAreaType();

		bedrooms = propertyDTO.getBedrooms();
		bathrooms = propertyDTO.getBathrooms();
		balconies = propertyDTO.getBalconies();

		pentries = propertyDTO.getPentries();
		cafeteria = propertyDTO.getCafeteria();

		furnishingType = propertyDTO.getFurnishingType();

		totalFloors = propertyDTO.getTotalFloors();
		directionFacing = propertyDTO.getDirectionFacing();

		propertyPrice = propertyDTO.getPropertyPrice();

		imagePath1 = propertyDTO.getImagePath1();
		imagePath2 = propertyDTO.getImagePath2();
		imagePath3 = propertyDTO.getImagePath3();
		imagePath4 = propertyDTO.getImagePath4();
		imagePath5 = propertyDTO.getImagePath5();

		description = propertyDTO.getDescription();
		status = propertyDTO.getStatus();

		noOfOpenSides = propertyDTO.getNoOfOpenSides();
		widthOfRealFacing = propertyDTO.getWidthOfRealFacing();
		boundaryWall = propertyDTO.getBoundaryWall();
		plotArea = propertyDTO.getPlotArea();
		plotAreaType = propertyDTO.getPlotAreaType();
		plotLength = propertyDTO.getPlotLength();
		plotBreadth = propertyDTO.getPlotBreadth();
		super.populateCommon(dto);
	}

	@Override
	public String toString() {
		return "PropertyForm [personType=" + personType + ", personFirstName=" + personFirstName + ", personLastName="
				+ personLastName + ", personEmail=" + personEmail + ", personMobileNo=" + personMobileNo
				+ ", propertyType=" + propertyType + ", propertyFor=" + propertyFor + ", propertyDescriptionType="
				+ propertyDescriptionType + ", cityId=" + cityId + ", cityName=" + cityName + ", stateId=" + stateId
				+ ", stateName=" + stateName + ", pincode=" + pincode + ", latitude=" + latitude + ", longitude="
				+ longitude + ", address=" + address + ", landmark=" + landmark + ", area=" + area + ", areaType="
				+ areaType + ", carpetArea=" + carpetArea + ", carpetAreaType=" + carpetAreaType + ", bedrooms="
				+ bedrooms + ", bathrooms=" + bathrooms + ", balconies=" + balconies + ", pentries=" + pentries
				+ ", cafeteria=" + cafeteria + ", furnishingType=" + furnishingType + ", totalFloors=" + totalFloors
				+ ", directionFacing=" + directionFacing + ", propertyPrice=" + propertyPrice + ", imagePath1="
				+ imagePath1 + ", imagePath2=" + imagePath2 + ", imagePath3=" + imagePath3 + ", imagePath4="
				+ imagePath4 + ", imagePath5=" + imagePath5 + ", description=" + description + ", status=" + status
				+ ", noOfOpenSides=" + noOfOpenSides + ", widthOfRealFacing=" + widthOfRealFacing + ", boundaryWall="
				+ boundaryWall + ", plotArea=" + plotArea + ", plotAreaType=" + plotAreaType + ", plotLength="
				+ plotLength + ", plotBreadth=" + plotBreadth + "]";
	}

}
