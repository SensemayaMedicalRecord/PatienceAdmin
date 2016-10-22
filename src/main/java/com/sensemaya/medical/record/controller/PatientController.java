package com.sensemaya.medical.record.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.record.model.PatienceEntity;
import com.sensemaya.medical.record.model.PatienceRepository;
import com.sensemaya.medical.record.model.PatienceViewEntity;
import com.sensemaya.medical.record.model.PatienceViewRepository;
import com.sensemaya.medical.record.service.TokenCreatorConsumer;

/**
 * 
 * @author Paulino Mota Hernandez
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatienceRepository repository;
	
	@Autowired PatienceViewRepository viewRepository;
	
	@Autowired TokenCreatorConsumer tokenConsumer;
	
	private static final Logger log = Logger.getLogger(PatientController.class);
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(path={"","/"})
	public ResponseCommon getAllPatience(){
		ResponseCommon res = new ResponseCommon();
		
			res.setResult((List<PatienceEntity>) repository.findAll());
			
		return res;
	} 
	
	@RequestMapping(path={"{curp}", "/{curp}"})
	public ResponseCommon findPatientByCurp(@PathVariable("curp") String curp){
		ResponseCommon responseCommon = new ResponseCommon();
			try{
				responseCommon.setResultList(viewRepository.findByCurp(curp));
				if(responseCommon.getResultList().size() > 0){
					responseCommon.setCdUser(responseCommon.getResultList().get(0).getCdUserType());
				}				
				responseCommon.setSuccess(true);
				
			}catch(Exception e){
			}
		
		return responseCommon;
	}
	
	@RequestMapping(path={"token/{userId}","/token/{userId}"}, method=RequestMethod.PUT)
	public ResponseCommon requestToken(@PathVariable("userId") Long userId){
		ResponseCommon response = new ResponseCommon();
		
			response.setSuccess(tokenConsumer.invoqueTokenCreator(userId, 11l));
		
		return response;
	}

	@RequestMapping(path={"/validate/token/{userId}","/validate/token/{userId}/{token}"}, method=RequestMethod.POST)
	public ResponseCommon validate(@PathVariable("userId") Long userId,@PathVariable("token") String token){
		ResponseCommon response = new ResponseCommon();
			response.setSuccess(tokenConsumer.validateLoginTokenRequest(userId, 11l, token));
		return response;
	}
	
}

class ResponseToken{
	
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}

class ResponseCommon{
	
	private boolean success;
	private boolean finded;
	private String cdUser;
	private List<PatienceEntity> result;
	
	public String getCdUser() {
		return cdUser;
	}
	public void setCdUser(String cdUser) {
		this.cdUser = cdUser;
	}
	
	List<PatienceViewEntity> resultList = new ArrayList<PatienceViewEntity>();
	
	public ResponseCommon(){}
	public ResponseCommon(boolean success){
		this.success = success;
	}
	
	public List<PatienceViewEntity> getResultList() {
		return resultList;
	}
	public void setResultList(List<PatienceViewEntity> resultList) {
		this.resultList = resultList;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<PatienceEntity> getResult() {
		return result;
	}
	public void setResult(List<PatienceEntity> result) {
		this.result = result;
	}
	public boolean isFinded() {
		return this.result != null || this.resultList.size() > 0;
	}
	public void setFinded(boolean finded) {
		this.finded = finded;
	}
	
	
}
