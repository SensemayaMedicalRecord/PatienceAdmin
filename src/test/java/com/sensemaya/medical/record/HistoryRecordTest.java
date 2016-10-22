package com.sensemaya.medical.record;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sensemaya.medical.record.model.HistoryEntity;
import com.sensemaya.medical.record.model.HistoryEntityRepository;
import com.sensemaya.medical.record.service.CreateHistoryRecordService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryRecordTest {

	@Autowired
	private HistoryEntityRepository repoHistory;
	
	@Autowired
	private CreateHistoryRecordService createHistoryService;
	
	@Before
	public void setup(){
		repoHistory.deleteAll();
	}
	
	@Test
	public void crateRowHistory(){
		HistoryEntity entity = new HistoryEntity(); 
		
			entity.setCdStatus("A");
			entity.setIdPatient(167l);
			entity.setIdDoctor(165l);
			entity.setHereditaryDiseases("HEREDIAN DESESES");
			entity.setBackgroundNonPatology("NON PATOLOGY");
			entity.setBackgroundPatology("TEY PATOLOGY");
		
			List<HistoryEntity> result = repoHistory.findByIdPatient(167l);
			
		createHistoryService.createHistoryRecord(entity);
		assertEquals(1, result.size());
		
	}
	
	
	
}
