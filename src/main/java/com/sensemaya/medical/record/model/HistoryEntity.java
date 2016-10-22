package com.sensemaya.medical.record.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MR_PATIENT_HISTORY")
public class HistoryEntity {

	@Id @GeneratedValue
	private Long idHistory;
	private String cdStatus;
	
	@Column(name="id_patient")
	private Long idPatient;
	private Date dateRecordHistory;
	private String hereditaryDiseases;
	
	private String backgroundPatology;
	private String backgroundNonPatology;
	private Long idDoctor;	
	
	private String userInserted;
	private Date dateInserted = new Date();
	
	public String getBackgroundNonPatology() {
		return backgroundNonPatology;
	}
	public void setBackgroundNonPatology(String backgroundNonPatology) {
		this.backgroundNonPatology = backgroundNonPatology;
	}
	
	
	public Long getIdHistory() {
		return idHistory;
	}
	public void setIdHistory(Long idHistory) {
		this.idHistory = idHistory;
	}
	public String getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public Date getDateRecordHistory() {
		return dateRecordHistory;
	}
	public void setDateRecordHistory(Date dateRecordHistory) {
		this.dateRecordHistory = dateRecordHistory;
	}
	public String getHereditaryDiseases() {
		return hereditaryDiseases;
	}
	public void setHereditaryDiseases(String hereditaryDiseases) {
		this.hereditaryDiseases = hereditaryDiseases;
	}
	public String getBackgroundPatology() {
		return backgroundPatology;
	}
	public void setBackgroundPatology(String backgroundPatology) {
		this.backgroundPatology = backgroundPatology;
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
	public Date getDateInserted() {
		return dateInserted;
	}
	public void setDateInserted(Date dateInserted) {
		this.dateInserted = dateInserted;
	}
	
}
