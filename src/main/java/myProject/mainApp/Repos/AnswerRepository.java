package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import myProject.Model.Answer;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, Long> {
}
