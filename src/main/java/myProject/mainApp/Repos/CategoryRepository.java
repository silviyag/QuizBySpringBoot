package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import myProject.Model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {
}
