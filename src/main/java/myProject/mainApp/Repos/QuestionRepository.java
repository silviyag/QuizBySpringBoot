package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import myProject.Model.Player;
import myProject.Model.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {
}

