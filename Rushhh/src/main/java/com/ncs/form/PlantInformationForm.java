package com.ncs.form;

import javax.persistence.Column;

import org.eclipse.jetty.server.handler.HandlerCollection;

import com.itextpdf.text.pdf.RadioCheckField;
import com.ncs.dto.MessageDTO;
import com.ncs.dto.PlantInformationDTO;
import com.nenosystems.common.dto.BaseDTO;
import com.nenosystems.common.form.BaseForm;

public class PlantInformationForm extends BaseForm {

	private Long userId;
	private String imagePath;

	// Freezing Type
	private String iqf;
	private String ammoniaBlast;
	private String freonBlast;

	// Water Used

	private String boreWell;
	private String corporation;
	private String openWell;

	// Cold StoarageSystems

	private String racksystem;
	private String racksystemDOC;
	private String openSystem;
	private String openSystemDOC;

	// waterDesposalFacility

	private String waterDesposalFacility;

	// Raw Matrail
	private String rawMaterial;
	private String rawMaterialDistrict;
	private String rawMaterialCity;

	// Lab Facility

	private String labFacility;
	private String labFacilityName;
	private String labFacilityAddress;

	// FrequencyMaterial
	private String frequencyMaterial;

	// WaterTreatmentFacility
	private String waterTreatmentFacility;

	// WaterTestingFrequency
	private String waterTestingFrequency;

	// Coled Stoarage Capacity
	private String coledStoarageCapacity;
	private String coledStoarageCapacityValue;

	// PowerBackupAvailable
	private String powerBackupAvailable;

	// ImportExportCertificate
	private String importExportCertificate;
	private String importExportCertificateDOC;

	// POLLUTION_CONTROL_BOARD_CERTIFICATE
	private String pollutionControlBoardCertificate;
	private String pollutionControlBoardCertificateDOC;

	// Certifications

	// ISO 9000
	private String iso9000;
	private String iso9000DOC;

	// ISO 22000
	private String iso22000;
	private String iso22000DOC;

	// HALAL
	private String halal;
	private String halalDOC;

	// BRC
	private String brc;
	private String brcDOC;

	// OTHER
	private String other;
	private String otherName;
	private String otherDOC;

	// GMP
	private String gmp;
	private String gmpDOC;

	// KOSHER
	private String kosher;
	private String kosherDOC;

	
	
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

	@Override
	public BaseDTO makeDto() {
		// TODO Auto-generated method stub
		PlantInformationDTO plantInformationDTO = new PlantInformationDTO();
		super.makeDto(plantInformationDTO);
		plantInformationDTO.setUserId(userId);
		
		plantInformationDTO.setIqf(iqf);
		plantInformationDTO.setAmmoniaBlast(ammoniaBlast);
		plantInformationDTO.setFreonBlast(freonBlast);
		plantInformationDTO.setBoreWell(boreWell);
		plantInformationDTO.setCorporation(corporation);
		
		plantInformationDTO.setOpenWell(openWell);
		plantInformationDTO.setRacksystem(racksystem);
		plantInformationDTO.setRacksystemDOC(racksystemDOC);
		plantInformationDTO.setOpenSystem(openSystem);
		plantInformationDTO.setOpenSystemDOC(openSystemDOC);
		
		
		
		plantInformationDTO.setWaterDesposalFacility(waterDesposalFacility);
		
		plantInformationDTO.setRawMaterial(rawMaterial);
		plantInformationDTO.setRawMaterialDistrict(rawMaterialDistrict);
		plantInformationDTO.setRawMaterialCity(rawMaterialCity);
		
		plantInformationDTO.setLabFacility(labFacility);
		plantInformationDTO.setLabFacilityName(labFacilityName);
		plantInformationDTO.setLabFacilityAddress(labFacilityAddress);
		
		
		
		plantInformationDTO.setFrequencyMaterial(frequencyMaterial);
		
		
		plantInformationDTO.setWaterTreatmentFacility(waterTreatmentFacility);
		plantInformationDTO.setWaterTestingFrequency(waterTestingFrequency);
		
		
		plantInformationDTO.setColedStoarageCapacity(coledStoarageCapacity);
		plantInformationDTO.setColedStoarageCapacityValue(coledStoarageCapacityValue);
		
		
		
		
		plantInformationDTO.setPowerBackupAvailable(powerBackupAvailable);
		
		plantInformationDTO.setImportExportCertificate(importExportCertificate);
		plantInformationDTO.setImportExportCertificate(importExportCertificate);
		
		
		plantInformationDTO.setPollutionControlBoardCertificate(pollutionControlBoardCertificate);
		plantInformationDTO.setPollutionControlBoardCertificateDOC(pollutionControlBoardCertificateDOC);
		
		
		
		plantInformationDTO.setOther(other);
		plantInformationDTO.setOtherDOC(otherDOC);
		plantInformationDTO.setOtherName(otherName);
		
		
		plantInformationDTO.setGmp(gmp);
		plantInformationDTO.setGmpDOC(gmpDOC);
		
		
		plantInformationDTO.setKosher(kosher);
		plantInformationDTO.setKosherDOC(kosherDOC);
		
		
		plantInformationDTO.setHalal(halal);
		plantInformationDTO.setHalalDOC(halalDOC);
		
		
		plantInformationDTO.setBrc(brc);
		plantInformationDTO.setBrcDOC(brcDOC);
		
		
		
		plantInformationDTO.setIso9000(iso9000);
		plantInformationDTO.setIso9000(iso9000DOC);

		plantInformationDTO.setIso22000(iso22000);
		plantInformationDTO.setIso22000DOC(iso22000DOC);
		
		plantInformationDTO.setImagePath(imagePath);

		plantInformationDTO.setHalal(halal);
		plantInformationDTO.setHalalDOC(halalDOC);
		
		return plantInformationDTO;
	}

	@Override
	public void populate(BaseDTO dto) {
		// TODO Auto-generated method stub
		PlantInformationDTO plantInformationDTO = (PlantInformationDTO) dto;

		// UserId
		userId = plantInformationDTO.getUserId();

		// Freezing Type
		iqf = plantInformationDTO.getIqf();
		ammoniaBlast = plantInformationDTO.getAmmoniaBlast();
		freonBlast = plantInformationDTO.getFreonBlast();

		// Water Userd
		boreWell = plantInformationDTO.getBoreWell();
		corporation = plantInformationDTO.getCorporation();
		openWell = plantInformationDTO.getOpenWell();

		racksystem = plantInformationDTO.getRacksystem();
		racksystemDOC = plantInformationDTO.getRacksystemDOC();

		openSystem = plantInformationDTO.getOpenSystem();
		openSystemDOC = plantInformationDTO.getOpenSystemDOC();

		waterDesposalFacility = plantInformationDTO.getWaterDesposalFacility();

		rawMaterial = plantInformationDTO.getRawMaterial();
		rawMaterialCity = plantInformationDTO.getRawMaterialCity();
		rawMaterialDistrict = plantInformationDTO.getRawMaterialDistrict();

		labFacility = plantInformationDTO.getLabFacility();
		labFacilityName = plantInformationDTO.getLabFacilityName();
		labFacilityAddress = plantInformationDTO.getLabFacilityAddress();

		frequencyMaterial = plantInformationDTO.getFrequencyMaterial();

		waterTreatmentFacility = plantInformationDTO.getWaterTreatmentFacility();
		waterTestingFrequency = plantInformationDTO.getWaterTestingFrequency();

		coledStoarageCapacity = plantInformationDTO.getColedStoarageCapacity();
		coledStoarageCapacityValue = plantInformationDTO.getColedStoarageCapacityValue();

	
		powerBackupAvailable = plantInformationDTO.getPowerBackupAvailable();
		
		
		
		importExportCertificate = plantInformationDTO.getImportExportCertificate();
		importExportCertificateDOC=plantInformationDTO.getImportExportCertificateDOC();
		
		
		pollutionControlBoardCertificate = plantInformationDTO.getPollutionControlBoardCertificate();
		pollutionControlBoardCertificateDOC=plantInformationDTO.getPollutionControlBoardCertificateDOC();
		
		gmp = plantInformationDTO.getGmp();
		gmpDOC=plantInformationDTO.getGmpDOC();
		
		
		iso9000DOC = plantInformationDTO.getIso9000();
		iso9000DOC = plantInformationDTO.getIso9000();
		
		halal = plantInformationDTO.getHalal();
		halalDOC = plantInformationDTO.getHalalDOC();
		
		brc = plantInformationDTO.getBrc();
		brcDOC = plantInformationDTO.getBrcDOC();
		
		other = plantInformationDTO.getOther();
		otherDOC = plantInformationDTO.getOtherDOC();
		
		iso22000 = plantInformationDTO.getIso22000();
		imagePath = plantInformationDTO.getImagePath();
		iso22000DOC = plantInformationDTO.getIso22000();
		
		
	
		

		super.populateCommon(dto);
	}

}
