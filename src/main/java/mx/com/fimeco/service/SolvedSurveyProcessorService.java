package mx.com.fimeco.service;

import mx.com.fimeco.dto.SurveyData;

/**
 * Survey Processor
 *
 */
public interface SolvedSurveyProcessorService {


	/**
	 * This method is only a proxy between view layer and rest client
	 */
	public boolean sendData(SurveyData surveyData);
}
