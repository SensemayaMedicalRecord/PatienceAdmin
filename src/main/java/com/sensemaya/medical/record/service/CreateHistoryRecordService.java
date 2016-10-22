package com.sensemaya.medical.record.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensemaya.medical.record.model.HistoryEntity;
import com.sensemaya.medical.record.model.HistoryEntityRepository;

@Component
public class CreateHistoryRecordService {

	private static final Logger log = Logger.getLogger(CreateHistoryRecordService.class);
	
	@Autowired
	private HistoryEntityRepository historyRepo;

	public void createHistoryRecord(HistoryEntity history){
		
		history.setUserInserted("AMD");
		log.info(history);
		
		historyRepo.save(history);
		
	}
	
}
