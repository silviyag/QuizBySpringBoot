package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import myProject.Model.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Long> {
}
