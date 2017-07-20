package com.ncs.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nenosystems.common.dto.BaseDTO;

@Entity
@Table(name = "PLANT_INFORMATION")

public class PlantInformationDTO extends BaseDTO implements Serializable {

	@Column(name = "USER_ID", length = 50)
	private Long userId;
	@Column(name = "IMAGE_PATH", length = 200)
	private String imagePath;
	
	
//Freezing Type	
	@Column(name = "IQF")
	private String iqf;
	@Column(name = "AMMONIA_BLAST")
	private String ammoniaBlast;
	@Column(name = "FREON_BLAST")
	private String freonBlast;
	
//Water Used	
	
	@Column(name = "BORE_WELL")
	private String boreWell;
	@Column(name = "CORPORATION")
	private String corporation;
	@Column(name = "OPEN_WELL")
	private String openWell;
	
	
	//Cold StoarageSystems
	
	@Column(name = "RACK_SYSTEM")
	private String racksystem;
	@Column(name = "RACK_SYSTEM_DOC")
	private String racksystemDOC;
	@Column(name = "OPEN_SYSTEM")
	private String openSystem;
	@Column(name = "OPEN_SYSTEM_DOC")
	private String openSystemDOC;

	
	
	
	
	//waterDesposalFacility

	@Column(name = "WATER_DESPOSAL_FACILITY")
	private String waterDesposalFacility;
	
	
	//Raw Matrail
	@Column(name = "RAW_MATERIAL")
	private String rawMaterial;
	@Column(name = "RAW_MATERIAL_DISTRICT")
	private String rawMaterialDistrict;
	@Column(name = "RAW_MATERIAL_CITY")
	private String rawMaterialCity;
	
	
	//Lab Facility
	
	@Column(name = "LAB_FACILITY")
	private String labFacility;
	@Column(name = "LAB_FACILITY_NAME")
	private String labFacilityName;
	@Column(name = "LAB_FACILITY_ADDRESSS")
	private String labFacilityAddress;
	
	
	
	//FrequencyMaterial
	@Column(name = "FREQUENCY_MATERIAL")
	private String frequencyMaterial;
	
	
	//WaterTreatmentFacility
	@Column(name = "WATER_TREATMENT_FACILITY")
	private String waterTreatmentFacility;
	
	
	//WaterTestingFrequency
	@Column(name = "WATER_TESTING_FREQUENCY")
	private String waterTestingFrequency;
	
	//Coled Stoarage Capacity
	@Column(name = "COLED_STOARAGE_CAPACITY")
	private String coledStoarageCapacity;
	@Column(name = "COLED_STOARAGE_CAPACITY_VALUE")
	private String coledStoarageCapacityValue;
	
	
	//PowerBackupAvailable
	@Column(name = "POWER_BACKUP_AVAILABLE")
	private String powerBackupAvailable;
	

	//ImportExportCertificate
	@Column(name = "IMPORT_EXPORT_CERTIFICATE")
	private String importExportCertificate;
	@Column(name = "IMPORT_EXPORT_CERTIFICATE_DOC")
	private String importExportCertificateDOC;
	
	//POLLUTION_CONTROL_BOARD_CERTIFICATE
	@Column(name = "POLLUTION_CONTROL_BOARD_CERTIFICATE")
	private String pollutionControlBoardCertificate;
	@Column(name = "POLLUTION_CONTROL_BOARD_CERTIFICATE_DOC")
	private String pollutionControlBoardCertificateDOC;
	
	
	//Certifications
	
	
	//ISO 9000
	@Column(name = "ISO_9")
	private String iso9000;
	@Column(name = "ISO_9_DOC")
	private String iso9000DOC;
	
	
	//ISO 22000
	@Column(name = "ISO_2")
	private String iso22000;
	@Column(name = "ISO_2_DOC")
	private String iso22000DOC;
	
	//HALAL
	@Column(name = "HALAL")
	private String halal;
	@Column(name = "HALAL_DOC")
	private String halalDOC;
	
	//BRC
	@Column(name = "BRC")
	private String brc;
	@Column(name = "BRC_DOC")
	private String brcDOC;
	
	
	//OTHER
	@Column(name = "Other")
	private String other;
	@Column(name = "Other_NAME")
	private String otherName;
	@Column(name = "Other_DOC")
	private String otherDOC;
	
	//GMP
	@Column(name = "GMP")
	private String gmp;
	@Column(name = "GMP_DOC")
	private String gmpDOC;
	
	//KOSHER
	@Column(name = "KOSHER")
	private String kosher;
	@Column(name = "KOSHER_DOC")
	private String kosherDOC;
	
	
	//HACCP
	@Column(name = "HACCP")
	private String haccp;
	@Column(name = "HACCP_DOC")
	private String haccpDOC;
	
	
	
	
	
	public String getHaccp() {
		return haccp;
	}
	public void setHaccp(String haccp) {
		this.haccp = haccp;
	}
	public String getHaccpDOC() {
		return haccpDOC;
	}
	public void setHaccpDOC(String haccpDOC) {
		this.haccpDOC = haccpDOC;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getIqf() {
		return iqf;
	}
	public void setIqf(String iqf) {
		this.iqf = iqf;
	}
	public String getAmmoniaBlast() {
		return ammoniaBlast;
	}
	public void setAmmoniaBlast(String ammoniaBlast) {
		this.ammoniaBlast = ammoniaBlast;
	}
	public String getFreonBlast() {
		return freonBlast;
	}
	public void setFreonBlast(String freonBlast) {
		this.freonBlast = freonBlast;
	}
	public String getBoreWell() {
		return boreWell;
	}
	public void setBoreWell(String boreWell) {
		this.boreWell = boreWell;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getOpenWell() {
		return openWell;
	}
	public void setOpenWell(String openWell) {
		this.openWell = openWell;
	}
	public String getRacksystem() {
		return racksystem;
	}
	public void setRacksystem(String racksystem) {
		this.racksystem = racksystem;
	}
	public String getRacksystemDOC() {
		return racksystemDOC;
	}
	public void setRacksystemDOC(String racksystemDOC) {
		this.racksystemDOC = racksystemDOC;
	}
	public String getOpenSystem() {
		return openSystem;
	}
	public void setOpenSystem(String openSystem) {
		this.openSystem = openSystem;
	}
	public String getOpenSystemDOC() {
		return openSystemDOC;
	}
	public void setOpenSystemDOC(String openSystemDOC) {
		this.openSystemDOC = openSystemDOC;
	}
	public String getWaterDesposalFacility() {
		return waterDesposalFacility;
	}
	public void setWaterDesposalFacility(String waterDesposalFacility) {
		this.waterDesposalFacility = waterDesposalFacility;
	}
	public String getRawMaterial() {
		return rawMaterial;
	}
	public void setRawMaterial(String rawMaterial) {
		this.rawMaterial = rawMaterial;
	}
	public String getRawMaterialDistrict() {
		return rawMaterialDistrict;
	}
	public void setRawMaterialDistrict(String rawMaterialDistrict) {
		this.rawMaterialDistrict = rawMaterialDistrict;
	}
	public String getRawMaterialCity() {
		return rawMaterialCity;
	}
	public void setRawMaterialCity(String rawMaterialCity) {
		this.rawMaterialCity = rawMaterialCity;
	}
	public String getLabFacility() {
		return labFacility;
	}
	public void setLabFacility(String labFacility) {
		this.labFacility = labFacility;
	}
	public String getLabFacilityName() {
		return labFacilityName;
	}
	public void setLabFacilityName(String labFacilityName) {
		this.labFacilityName = labFacilityName;
	}
	public String getLabFacilityAddress() {
		return labFacilityAddress;
	}
	public void setLabFacilityAddress(String labFacilityAddress) {
		this.labFacilityAddress = labFacilityAddress;
	}
	public String getFrequencyMaterial() {
		return frequencyMaterial;
	}
	public void setFrequencyMaterial(String frequencyMaterial) {
		this.frequencyMaterial = frequencyMaterial;
	}
	public String getWaterTreatmentFacility() {
		return waterTreatmentFacility;
	}
	public void setWaterTreatmentFacility(String waterTreatmentFacility) {
		this.waterTreatmentFacility = waterTreatmentFacility;
	}
	public String getWaterTestingFrequency() {
		return waterTestingFrequency;
	}
	public void setWaterTestingFrequency(String waterTestingFrequency) {
		this.waterTestingFrequency = waterTestingFrequency;
	}
	public String getColedStoarageCapacity() {
		return coledStoarageCapacity;
	}
	public void setColedStoarageCapacity(String coledStoarageCapacity) {
		this.coledStoarageCapacity = coledStoarageCapacity;
	}
	public String getColedStoarageCapacityValue() {
		return coledStoarageCapacityValue;
	}
	public void setColedStoarageCapacityValue(String coledStoarageCapacityValue) {
		this.coledStoarageCapacityValue = coledStoarageCapacityValue;
	}
	public String getPowerBackupAvailable() {
		return powerBackupAvailable;
	}
	public void setPowerBackupAvailable(String powerBackupAvailable) {
		this.powerBackupAvailable = powerBackupAvailable;
	}
	public String getImportExportCertificate() {
		return importExportCertificate;
	}
	public void setImportExportCertificate(String importExportCertificate) {
		this.importExportCertificate = importExportCertificate;
	}
	public String getImportExportCertificateDOC() {
		return importExportCertificateDOC;
	}
	public void setImportExportCertificateDOC(String importExportCertificateDOC) {
		this.importExportCertificateDOC = importExportCertificateDOC;
	}
	public String getPollutionControlBoardCertificate() {
		return pollutionControlBoardCertificate;
	}
	public void setPollutionControlBoardCertificate(String pollutionControlBoardCertificate) {
		this.pollutionControlBoardCertificate = pollutionControlBoardCertificate;
	}
	public String getPollutionControlBoardCertificateDOC() {
		return pollutionControlBoardCertificateDOC;
	}
	public void setPollutionControlBoardCertificateDOC(String pollutionControlBoardCertificateDOC) {
		this.pollutionControlBoardCertificateDOC = pollutionControlBoardCertificateDOC;
	}
	public String getIso9000() {
		return iso9000;
	}
	public void setIso9000(String iso9000) {
		this.iso9000 = iso9000;
	}
	public String getIso9000DOC() {
		return iso9000DOC;
	}
	public void setIso9000DOC(String iso9000doc) {
		iso9000DOC = iso9000doc;
	}
	public String getIso22000() {
		return iso22000;
	}
	public void setIso22000(String iso22000) {
		this.iso22000 = iso22000;
	}
	public String getIso22000DOC() {
		return iso22000DOC;
	}
	public void setIso22000DOC(String iso22000doc) {
		iso22000DOC = iso22000doc;
	}
	public String getHalal() {
		return halal;
	}
	public void setHalal(String halal) {
		this.halal = halal;
	}
	public String getHalalDOC() {
		return halalDOC;
	}
	public void setHalalDOC(String halalDOC) {
		this.halalDOC = halalDOC;
	}
	public String getBrc() {
		return brc;
	}
	public void setBrc(String brc) {
		this.brc = brc;
	}
	public String getBrcDOC() {
		return brcDOC;
	}
	public void setBrcDOC(String brcDOC) {
		this.brcDOC = brcDOC;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getOtherDOC() {
		return otherDOC;
	}
	public void setOtherDOC(String otherDOC) {
		this.otherDOC = otherDOC;
	}
	public String getGmp() {
		return gmp;
	}
	public void setGmp(String gmp) {
		this.gmp = gmp;
	}
	public String getGmpDOC() {
		return gmpDOC;
	}
	public void setGmpDOC(String gmpDOC) {
		this.gmpDOC = gmpDOC;
	}
	public String getKosher() {
		return kosher;
	}
	public void setKosher(String kosher) {
		this.kosher = kosher;
	}
	public String getKosherDOC() {
		return kosherDOC;
	}
	public void setKosherDOC(String kosherDOC) {
		this.kosherDOC = kosherDOC;
	}

}
