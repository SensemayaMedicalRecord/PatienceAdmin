package com.sensemaya.medical.record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.record.model.MedicalRecordEntity;
import com.sensemaya.medical.record.service.MedicalRecordService;

@CrossOrigin
@RestController
@RequestMapping("medicalRecord")
public class MedicalRecordController {
	
	@Autowired
	private MedicalRecordService mrService;
	
	@RequestMapping(path={"","/"}, method=RequestMethod.POST)
	public CommonResponse createMedicalRecord(@RequestBody MedicalRecordEntity medicalRecord){
		CommonResponse res = new CommonResponse();
		
			mrService.createMedicalRecord(medicalRecord);
		
		return res;
	}
	
}

class CommonResponse{
	
	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}