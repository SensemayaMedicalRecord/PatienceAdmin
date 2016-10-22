package com.sensemaya.medical.record.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensemaya.medical.record.dao.WearableData;
import com.sensemaya.medical.record.service.BraceletInformationService;


@RestController
@RequestMapping("wearable")
public class WearableController {

	private static final Logger log = Logger.getLogger(WearableController.class);
	
	@Autowired
	private BraceletInformationService serviceInformation;
	
	@RequestMapping(path={"{idTokenBracelet}","/{idTokenBracelet}"})
	public WearableResponse testJdbc(@PathVariable("idTokenBracelet") Long idTokenBracelet){
		WearableResponse a = new WearableResponse();
		log.info("INVOCE GET WEARABLE");
			try{
				WearableData res = serviceInformation.getPatientInformationByToken(idTokenBracelet);
					a.setResult(res);
					a.setSuccess(true);
			}catch(Exception e){
				a.setMessage(a.getMessage());
				log.error(e.getMessage());
			}
		return a;
	}
	
}

class WearableResponse{
	
	private boolean success;
	private String message;
	private WearableData result;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public WearableData getResult() {
		return result;
	}
	public void setResult(WearableData result) {
		this.result = result;
	}
	
}
