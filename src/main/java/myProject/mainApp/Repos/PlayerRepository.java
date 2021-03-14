package myProject.mainApp.Repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import myProject.Model.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

}
