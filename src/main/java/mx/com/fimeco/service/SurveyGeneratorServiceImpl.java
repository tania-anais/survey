package mx.com.fimeco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.fimeco.dto.SurveyData;
import mx.com.fimeco.repository.QuestionRepository;

/**
 * Survey Provider
 *
 */
@Service
public class SurveyGeneratorServiceImpl implements SurveyGeneratorService {

	@Autowired
	private QuestionRepository questionRepository;
	
	/**
	 * Generate a Survey with active questions. 
	 * In a real application we should limit the results.
	 * @return
	 */
	public SurveyData generateDefaultSurvey() {
		SurveyData data = new SurveyData();
		data.setQuestionList(questionRepository.findByActive(Boolean.TRUE));
		return data;
	}
}
