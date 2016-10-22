package com.sensemaya.medical.record.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatienceViewRepository extends CrudRepository<PatienceViewEntity, Long>{

	List<PatienceViewEntity> findByCurp(String curp);
	List<PatienceViewEntity> findByFirstNameAndLastNameAndSurName(String fitstName, String lastName, String surName);
	
}
