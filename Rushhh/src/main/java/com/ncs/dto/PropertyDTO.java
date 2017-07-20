package com.ncs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "PROPERTY")
public class PropertyDTO extends BaseDTO {

	@Column(name = "PERSON_TYPE", length = 100)
	private String personType;
	@Column(name = "PERSON_FIRST_NAME", length = 100)
	private String personFirstName;
	@Column(name = "PERSON_LAST_NAME", length = 100)
	private String personLastName;
	@Column(name = "PERSON_EMAIL", length = 100)
	private String personEmail;
	@Column(name = "PERSON_MOBILENO", length = 50)
	private String personMobileNo;

	@Column(name = "PROPERTY_BRIEF_DESCIPTION", length = 1000)
	private String propertyBriefDesciption;
	@Column(name = "PROPERTY_STATUS", length = 1000)
	private String propertyStatus;

	@Column(name = "PROPERTY_TYPE", length = 100)
	private String propertyType;
	@Column(name = "PROPERTY_FOR", length = 100)
	private String propertyFor;
	@Column(name = "PROPERTY_DESCRIPTION_TYPE", length = 100)
	private String propertyDescriptionType;

	@Column(name = "CITY_ID", length = 100)
	private Long cityId;
	@Column(name = "CITY_NAME", length = 100)
	private String cityName;
	@Column(name = "STATE_ID", length = 100)
	private Long stateId;
	@Column(name = "STATE_NAME", length = 100)
	private String stateName;
	@Column(name = "PINCODE", length = 100)
	private Long pincode;
	@Column(name = "LATITUDE", length = 100)
	private Double latitude;
	@Column(name = "LONGITUDE", length = 100)
	private Double longitude;

	@Column(name = "LOCALITY", length = 100)
	private String locality;
	@Column(name = "SUBLOCALITY", length = 100)
	private String sublocality;
	@Column(name = "NAME_OF_SOCIETY", length = 100)
	private String nameOfSociety;
	@Column(name = "ADDRESS", length = 100)
	private String address;
	@Column(name = "LANDMARK", length = 100)
	private String landmark;

	@Column(name = "AREA", length = 100)
	private String area;
	@Column(name = "AREA_TYPE", length = 100)
	private String areaType;

	@Column(name = "CARPET_AREA", length = 100)
	private String carpetArea;
	@Column(name = "CARPET_AREA_TYPE", length = 100)
	private String carpetAreaType;

	@Column(name = "BEDROOMS", length = 100)
	private String bedrooms;
	@Column(name = "BATHROOMS", length = 100)
	private String bathrooms;
	@Column(name = "BALCONIES", length = 100)
	private String balconies;

	@Column(name = "PENTRIES", length = 100)
	private String pentries;
	@Column(name = "CAFETERIA", length = 100)
	private String cafeteria;

	@Column(name = "FURNISHING_TYPE", length = 100)
	private String furnishingType;

	@Column(name = "TOTAL_FLOORS", length = 100)
	private Integer totalFloors;
	@Column(name = "DIRECTION_FACING", length = 100)
	private String directionFacing;

	@Column(name = "PROPERTY_PRICE", length = 100)
	private Double propertyPrice;

	@Column(name = "IMAGE_PATH_1", length = 100)
	private String imagePath1;
	@Column(name = "IMAGE_PATH_2", length = 100)
	private String imagePath2;
	@Column(name = "IMAGE_PATH_3", length = 100)
	private String imagePath3;
	@Column(name = "IMAGE_PATH_4", length = 100)
	private String imagePath4;
	@Column(name = "IMAGE_PATH_5", length = 100)
	private String imagePath5;

	@Column(name = "DESCRIPTION", length = 10000)
	private String description;
	@Column(name = "STATUS", length = 100)
	private String status;

	@Column(name = "NO_OF_OPEN_SIDES", length = 100)
	private Integer noOfOpenSides;
	@Column(name = "WIDTH_OF_REAL_FACING", length = 100)
	private Double widthOfRealFacing;
	@Column(name = "BOUNDARY_WALL", length = 100)
	private String boundaryWall;
	@Column(name = "PLOT_AREA", length = 100)
	private Double plotArea;
	@Column(name = "PLOT_AREA_TYPE", length = 100)
	private String plotAreaType;
	@Column(name = "PLOT_LENGTH", length = 100)
	private Double plotLength;
	@Column(name = "PLOT_BREADTH", length = 100)
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

	public String getPersonMobileNo() {
		return personMobileNo;
	}

	public void setPersonMobileNo(String personMobileNo) {
		this.personMobileNo = personMobileNo;
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

}
