package mx.com.fimeco.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j2;
import mx.com.fimeco.dto.SurveyData;
import mx.com.fimeco.service.SolvedSurveyProcessorService;
import mx.com.fimeco.service.SurveyGeneratorService;

@Log4j2
@Controller
public class NavigationController {

	private static final String INDEX_VIEW = "index";
	private static final String SHOW_SURVEY_VIEW = "show-survey";
	
	@Autowired
	private SurveyGeneratorService surveyGeneratorService;
	@Autowired
	private SolvedSurveyProcessorService solvedSurveyProcessorService;
	
	/**
	 * Returns Main view: index
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String showIndex(Model model) {
		return INDEX_VIEW;
	}
	

	/**
	 * Generates a Default Survey and sendit to View
	 * @param model
	 * @return
	 */
	@GetMapping("/show-survey")
	public String showSurvey(Model model) {
		log.info("Generating Survey ......");
		model.addAttribute("surveyData",surveyGeneratorService.generateDefaultSurvey());
		return SHOW_SURVEY_VIEW;
	}
	
	/**
	 * Generates a Default Survey and sendit to View
	 * @param model
	 * @return
	 */
	@PostMapping("/submitData")
	public String submitSurveyResponses(@Valid @ModelAttribute SurveyData surveyData, BindingResult result, Model model) {
		if(result.hasErrors()) {
			log.info("hasErrors");
			result.getAllErrors().forEach(log::info);
			model.addAttribute("surveyData",surveyData);
			return SHOW_SURVEY_VIEW;
		}
		
		log.info("Survey Responses:");
		surveyData.getQuestionList().forEach(log::info);
		
		boolean serviceResult = solvedSurveyProcessorService.sendData(surveyData);

		if(serviceResult)
			model.addAttribute("showMessage", Boolean.TRUE);
		return INDEX_VIEW;
	}
}
