package com.sensemaya.medical.record.model;

import org.springframework.data.repository.CrudRepository;

public interface PatienceRepository extends CrudRepository<PatienceEntity, Long>{

	PatienceEntity findByIdPatient(Long idPatient);
	PatienceEntity findByIdUser(Long idUser);
	
}
