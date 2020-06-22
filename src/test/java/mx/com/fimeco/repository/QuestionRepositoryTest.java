package mx.com.fimeco.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import mx.com.fimeco.entity.Question;

@Log4j2
@SpringBootTest
class QuestionRepositoryTest {

	@Autowired
	QuestionRepository repository;
	
	@Test
	void testSave() {
		log.info(" # Executing {}", new Object(){}.getClass().getEnclosingMethod().getName());
		
		Question question = new Question();
		question.setText("New Question . is Created : . ; , ?");
		question.setPoints(1);
		question.setActive(Boolean.TRUE);				
		question = repository.save(question);
		log.info("ID = {}", question.getId());
		
		Assertions.assertTrue(repository.findById(question.getId()).isPresent());
	}

	@Test
	void testCount() {
		log.info(" # Executing {}", new Object(){}.getClass().getEnclosingMethod().getName());
	
		long count = repository.count();
		log.info("COUNT = {}", count);
		
		Assertions.assertTrue(count > 0);
	}

	@Test
	void testFindByActive() {
		log.info(" # Executing {}", new Object(){}.getClass().getEnclosingMethod().getName());
		
		List<Question> activeQuestions = repository.findByActive(Boolean.TRUE);
		activeQuestions.forEach(item -> log.info(item));
		
		Assertions.assertTrue(activeQuestions.size() > 0);
	}

}
