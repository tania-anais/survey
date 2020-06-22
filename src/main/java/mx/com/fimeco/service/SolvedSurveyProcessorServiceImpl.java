package mx.com.fimeco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.fimeco.dto.SurveyData;
import mx.com.fimeco.rest.client.SurveyRestApiClient;

/**
 * Survey Processor
 *
 */
@Service
public class SolvedSurveyProcessorServiceImpl implements SolvedSurveyProcessorService {

	@Autowired
	SurveyRestApiClient surveyRestApiClient;
	
	/**
	 * This method is only a proxy between view layer and rest client
	 */
	public boolean sendData(SurveyData surveyData) {
		return surveyRestApiClient.sendSolvedSurvey(surveyData, surveyRestApiClient.getAuthorizationToken());
	}
}
