package com.sensemaya.medical.record.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="MR_USER_PATIENTS")
public class PatienceEntity {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPatient;
	
	@Column(name="id_user")
	private Long idUser;
	private Long idTokenBracelet;
	private String userInserted;
	private Date dateInserted;
	private String cdStatus;
	
	
	@OneToMany
	@JoinColumn(name="id_patient")
	private List<HistoryEntity> history;
	
	public List<HistoryEntity> getHistory() {
		return history;
	}
	public void setHistory(List<HistoryEntity> history) {
		this.history = history;
	}
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdTokenBracelet() {
		return idTokenBracelet;
	}
	public void setIdTokenBracelet(Long idTokenBracelet) {
		this.idTokenBracelet = idTokenBracelet;
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
	public String getCdStatus() {
		return cdStatus;
	}
	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}
	
}
