package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import myProject.Model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
}

