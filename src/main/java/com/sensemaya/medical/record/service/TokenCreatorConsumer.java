package com.sensemaya.medical.record.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/** Class helper to invoce TokenRestServices
 * 
 * @author Paulino Mota Hernandez
 *
 */
@Component
public class TokenCreatorConsumer {

	
	
	/**
	 * 
	 * @param idUser id de usuario dentro del legado al que pertence
	 * @return
	 */
	public boolean invoqueTokenCreator(Long idUser, Long idLegacy){
		RestTemplate rtCReator = new RestTemplate();
			
			CommonResponse commonResponse = rtCReator.getForObject("http://localhost:8390/token/" + idLegacy + "/" + idUser, CommonResponse.class);
		
		return commonResponse.isSuccess();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean validateLoginTokenRequest(Long idUserLegacy, Long idSystem, String idToken){
		RestTemplate rtValidate = new RestTemplate();
		RequestTokenLogin request = new RequestTokenLogin(idUserLegacy, idSystem, idToken);
			
		CommonResponse response = rtValidate.postForObject("http://localhost:8390/token/", request, CommonResponse.class);
		
		return response.isSuccess();
	}
	
}

class RequestTokenLogin{
	private String token;
	private Long idSystem;
	private Long idUserLegacy;
	
	public RequestTokenLogin(Long idUserLegacy, Long idSystem, String idToken){
		this.token = idToken;
		this.idSystem = idSystem;
		this.idUserLegacy = idUserLegacy;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getIdSystem() {
		return idSystem;
	}
	public void setIdSystem(Long idSystem) {
		this.idSystem = idSystem;
	}
	public Long getIdUserLegacy() {
		return idUserLegacy;
	}
	public void setIdUserLegacy(Long idUserLegacy) {
		this.idUserLegacy = idUserLegacy;
	}
	
}

class CommonResponse{
	
	private boolean success;
	private String message;
	
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
	
}