package mx.com.fimeco.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.fimeco.entity.Question;

@Repository
@Scope("singleton")
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	public List<Question> findByActive(Boolean isActive);
}
