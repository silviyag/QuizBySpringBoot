package myProject.mainApp.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import myProject.Model.Match;
import myProject.Model.Player;

@Repository
public interface MatchRepository extends MongoRepository<Match, String> {

	List<Match> findAllByPlayer(Player player);
}
