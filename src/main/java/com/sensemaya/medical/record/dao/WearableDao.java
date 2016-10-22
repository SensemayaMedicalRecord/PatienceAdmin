package com.sensemaya.medical.record.dao;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sensemaya.medical.record.model.HistoryEntity;
import com.sensemaya.medical.record.model.HistoryEntityRepository;


@Component
public class WearableDao {

	private static final Logger log = Logger.getLogger(WearableData.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HistoryEntityRepository historyRepo;
	
	public WearableData getDataInformation(Long idTokenBracelet){
		
		WearableData data = jdbcTemplate.queryForObject(
				"SELECT USR.*, PAT.ID_TOKEN_BRACELET,PAT.ID_PATIENT, "
				+ "PAT.emergency_contact_name, pat.emergency_contact_phone"
				+ " FROM mr_admin.MR_USERS USR,  mr_admin.MR_USER_PATIENTS PAT "
				+ "WHERE PAT.ID_USER = USR.ID_USER "
				+ "AND PAT.ID_TOKEN_BRACELET = ?", 
				new Object[]{idTokenBracelet},
				(rs, row) -> {
					log.info("Row Information by id = " + idTokenBracelet + " get idpatient " + rs.getLong("ID_PATIENT"));
					rs.getLong("ID_PATIENT");
					return new WearableData(
							rs.getString("FIRST_NAME"), 
							rs.getString("LAST_NAME"),
							rs.getString("SUR_NAME"),
							rs.getLong("ID_TOKEN_BRACELET"),
							rs.getLong("ID_PATIENT"),
							StringUtils.defaultIfBlank(rs.getString("emergency_contact_name"), ""),
							StringUtils.defaultIfBlank(rs.getString("emergency_contact_phone"), "")
							);
				});
		
		data.setHistory(getHistoryPatience(data.getIdPatient()));
		
		return data;
	}
	
	private List<HistoryEntity> getHistoryPatience(Long idPatient){
		
		return historyRepo.findByIdPatient(idPatient);
	}
	
}
