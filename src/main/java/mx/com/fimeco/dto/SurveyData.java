package mx.com.fimeco.dto;

import java.util.List;

import javax.validation.Valid;

import lombok.Data;
import mx.com.fimeco.entity.Question;

@Data
public class SurveyData {

	@Valid
	User user;
	
	@Valid
	List<Question> questionList;
	
}
