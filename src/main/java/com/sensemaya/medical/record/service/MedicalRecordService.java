package com.sensemaya.medical.record.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensemaya.medical.record.model.MedicalRecordEntity;
import com.sensemaya.medical.record.model.MedicalRecordRepository;

@Component
public class MedicalRecordService {

	@Autowired 
	private MedicalRecordRepository repository;
	
	public void createMedicalRecord(MedicalRecordEntity entity){
		
		entity.setDateInserted(new Date());
		entity.setUserInserted("ADMIN");
		
		repository.save(entity);
		
	}
	
	
}
