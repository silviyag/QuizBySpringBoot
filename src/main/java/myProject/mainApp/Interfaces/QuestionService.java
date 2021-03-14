package myProject.mainApp.Interfaces;

import java.util.List;
import java.util.Optional;

import myProject.Model.Question;

public interface QuestionService {

	Optional<Question> findById(Long id);

	void deleteById(Long id);

	List<Question> findAll();
}
