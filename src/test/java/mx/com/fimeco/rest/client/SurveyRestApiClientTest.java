package mx.com.fimeco.rest.client;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import mx.com.fimeco.dto.SurveyData;
import mx.com.fimeco.repository.QuestionRepository;

@Log4j2
@SpringBootTest
class SurveyRestApiClientTest {
	private final static String DUMMY_RESPONSE = "DUMMY RESPONSE";
	@Autowired
	QuestionRepository repository;
	
	@Autowired
	SurveyRestApiClient surveyRestApiClient;
	
	@Test
	void testSendSolvedSurvey() {
		log.info(" # Executing {}", new Object(){}.getClass().getEnclosingMethod().getName());
		SurveyData surveyData = new SurveyData();
		surveyData.setQuestionList(repository.findAll());
		surveyData.getQuestionList().forEach(item -> item.setUserResponse(DUMMY_RESPONSE));
		boolean result = surveyRestApiClient.sendSolvedSurvey(surveyData, surveyRestApiClient.getAuthorizationToken());
		Assertions.assertTrue(result);
		
	}

}
