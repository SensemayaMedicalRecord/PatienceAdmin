package com.sensemaya.medical.record.dao;

import java.util.List;

import com.sensemaya.medical.record.model.HistoryEntity;

public class WearableData {
	
	private String firstName;
	private String lastName;
	private String surName;
	private String emergencyContact;
	private String emergencyPhone;
	private Long idTokenBracelet;
	private Long idPatient;
	
	private List<HistoryEntity> history;
	
	public WearableData(){}
	public WearableData(
				String firstName,	
				String lastName, 
				String surName, 
				Long idTokenBracelet, 
				Long idPatient,
				String emergencyContact,
				String emergencyPhone){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.surName = surName;
		this.idTokenBracelet = idTokenBracelet;
		this.idPatient = idPatient;
		this.emergencyContact = emergencyContact;
		this.emergencyPhone = emergencyPhone;
		
	}
	
	
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmergencyPhone() {
		return emergencyPhone;
	}
	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	public Long getIdTokenBracelet() {
		return idTokenBracelet;
	}
	public void setIdTokenBracelet(Long idTokenBracelet) {
		this.idTokenBracelet = idTokenBracelet;
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
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public List<HistoryEntity> getHistory() {
		return history;
	}
	public void setHistory(List<HistoryEntity> history) {
		this.history = history;
	}
	
}
