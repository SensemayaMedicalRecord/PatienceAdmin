package com.sensemaya.medical.record.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecordEntity, Long>{
	
	List<MedicalRecordEntity> findByIdPatient(Long idPatient);
	
}
