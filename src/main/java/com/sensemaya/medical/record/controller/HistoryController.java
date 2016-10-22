package com.sensemaya.medical.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.record.model.HistoryEntity;
import com.sensemaya.medical.record.model.HistoryEntityRepository;
import com.sensemaya.medical.record.model.MedicalRecordEntity;
import com.sensemaya.medical.record.model.MedicalRecordRepository;
import com.sensemaya.medical.record.model.PatienceEntity;
import com.sensemaya.medical.record.model.PatienceRepository;
import com.sensemaya.medical.record.service.CreateHistoryRecordService;
import com.sensemaya.medical.record.service.TokenCreatorConsumer;

@CrossOrigin
@RestController
@RequestMapping("history")
public class HistoryController {

	@Autowired
	private HistoryEntityRepository repository;
	
	@Autowired
	private CreateHistoryRecordService historyRecordService;
	
	@Autowired
	private TokenCreatorConsumer tokenCreatorConsumer;
	
	@Autowired
	private PatienceRepository patientRepo;
	
	@Autowired
	private MedicalRecordRepository medicalRepository;
	
	@RequestMapping(path={"{idPatient}/{token}","/{idPatient}/{token}"})
	public HistoryResponse getHistoryByPatience(
			@PathVariable(name="idPatient") Long idPatience, 
			@PathVariable(name="token") String token
			  
			){
		HistoryResponse res = new HistoryResponse();
		PatienceEntity pEntity= patientRepo.findByIdUser(idPatience);
		
		if((null == pEntity) || 
				!tokenCreatorConsumer
				.validateLoginTokenRequest(idPatience, 11l, token)){
			
			return res;
		}
		
		res.setPatience(pEntity);
		//res.setHistory((List<HistoryEntity>)repository.findByIdPatient(pEntity.getIdPatient()));
		res.setMedicalRecord(medicalRepository.findByIdPatient(pEntity.getIdPatient()));
		
		res.setSuccess(true);
		
		return res;
	}
	
	@RequestMapping(path={"","/"}, method=RequestMethod.POST)
	public HistoryResponse createHistoryRecord(@RequestBody HistoryEntity history){
		HistoryResponse res = new HistoryResponse();
			
		historyRecordService.createHistoryRecord(history);
			
		res.setSuccess(true);
		
		return res;
	}
	
}

class HistoryResponse{
	private boolean success;
	private List<HistoryEntity> history;
	private List<MedicalRecordEntity> medicalRecord;
	private PatienceEntity patience;
	
	
	public PatienceEntity getPatience() {
		return patience;
	}
	public void setPatience(PatienceEntity patience) {
		this.patience = patience;
	}
	public List<MedicalRecordEntity> getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(List<MedicalRecordEntity> medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<HistoryEntity> getHistory() {
		return history;
	}
	public void setHistory(List<HistoryEntity> history) {
		this.history = history;
	}
	
}