package myProject.mainApp;

import org.springframework.data.mongodb.repository.MongoRepository;

import myProject.Model.Employee;
import myProject.Model.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {
	}
