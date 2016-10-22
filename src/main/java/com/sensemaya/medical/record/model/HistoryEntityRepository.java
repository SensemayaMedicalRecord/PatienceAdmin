package com.sensemaya.medical.record.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HistoryEntityRepository extends CrudRepository<HistoryEntity, Long>{
	
	List<HistoryEntity> findByIdPatient(Long idPatient);
	
}
