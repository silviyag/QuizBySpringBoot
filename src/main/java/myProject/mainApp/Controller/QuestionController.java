package myProject.mainApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import myProject.Model.Question;
import myProject.mainApp.Interfaces.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController implements QuestionService {

	private QuestionService questionRepositoy;

	@GetMapping
	public List<Question> findAll() {
		return questionRepositoy.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Question> findById(@PathVariable("id") Long id) {
		return questionRepositoy.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		questionRepositoy.deleteById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	}
}
