package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import myProject.Model.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {
}
