package mx.com.fimeco.service;

import mx.com.fimeco.dto.SurveyData;

/**
 * Survey Provider
 *
 */
public interface SurveyGeneratorService {

	/**
	 * Generate a Survey with active questions. 
	 * In a real application we should limit the results.
	 * @return
	 */
	public SurveyData generateDefaultSurvey();
}
