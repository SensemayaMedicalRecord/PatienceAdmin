package com.sensemaya.medical.record.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensemaya.medical.record.dao.WearableDao;
import com.sensemaya.medical.record.dao.WearableData;

@Component
public class BraceletInformationService {

	@Autowired
	private WearableDao dao;
	
	public WearableData getPatientInformationByToken(Long idTokenBracelet){
		
			WearableData dataWearable = dao.getDataInformation(idTokenBracelet);
		
		return dataWearable;
	}
	
}
