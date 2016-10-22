package com.sensemaya.medical.record;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sensemaya.medical.record.service.TokenCreatorConsumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatienceAdminApplicationTests {
	
	private Long idUserLegacy = 20l;
	private Long idLegacy = 11l;
	
	@Autowired
	TokenCreatorConsumer consumerToken;
	

	@Test
	public void createTokenSuccess(){
		boolean success = consumerToken.invoqueTokenCreator(22l, idLegacy);
		
		assertEquals(true, success);
	}
	
	@Test
	public void createTokenDoubleErrorExpected(){
		boolean success = consumerToken.invoqueTokenCreator(24l, idLegacy);
		assertEquals(true, success);
	}
	
	@Test
	public void createTokenAndValidateSuccess(){
			
			boolean success = consumerToken.invoqueTokenCreator(28l, idLegacy);
			boolean successLogin = consumerToken.validateLoginTokenRequest(28l, idLegacy,"2312312");
		
		assertEquals(true, success && successLogin);
		
	}
	
}
