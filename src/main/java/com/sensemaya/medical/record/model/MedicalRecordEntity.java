package com.sensemaya.medical.record.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name="MR_CLINICAL_RECORDS")
public class MedicalRecordEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRecord;
	
	@NotNull
	private Long idPatient;
	
	private String cdStatus;
	private String cdRecordType;
	private String objective;
	private String subjective;
	private String diagnostic;
	private String medicalTreatment;
	private boolean swAnalysis;
	private String cdAnalysis;
	private String currentAilment;
	
	@NotNull
	private Long idDoctor;

	private String userInserted;
	private String userUpdated;
	@Column
	@Type(type="date")
	private Date dateInserted;
	private Date dateUpdated;
	public Long getIdRecord() {
		return idRecord;
	}
	public void setIdRecord(Long idRecord) {
		this.idRecord = idRecord;
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public String getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}
	public String getCdRecordType() {
		return cdRecordType;
	}
	public void setCdRecordType(String cdRecordType) {
		this.cdRecordType = cdRecordType;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getSubjective() {
		return subjective;
	}
	public void setSubjective(String subjective) {
		this.subjective = subjective;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public String getMedicalTreatment() {
		return medicalTreatment;
	}
	public void setMedicalTreatment(String medicalTreatment) {
		this.medicalTreatment = medicalTreatment;
	}
	public String getCurrentAilment() {
		return currentAilment;
	}
	public void setCurrentAilment(String currentAilment) {
		this.currentAilment = currentAilment;
	}
	public boolean isSwAnalysis() {
		return swAnalysis;
	}
	public void setSwAnalysis(boolean swAnalysis) {
		this.swAnalysis = swAnalysis;
	}
	public String getCdAnalysis() {
		return cdAnalysis;
	}
	public void setCdAnalysis(String cdAnalysis) {
		this.cdAnalysis = cdAnalysis;
	}
	public Long getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getUserInserted() {
		return userInserted;
	}
	public void setUserInserted(String userInserted) {
		this.userInserted = userInserted;
	}
	public String getUserUpdated() {
		return userUpdated;
	}
	public void setUserUpdated(String userUpdated) {
		this.userUpdated = userUpdated;
	}
	public Date getDateInserted() {
		return dateInserted;
	}
	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
}
