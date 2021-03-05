package myProject.mainApp.Repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import myProject.Model.Match;
import myProject.Model.Player;

public interface MatchRepository extends MongoRepository<Match, String> {
	
	 List<Match> findAllByPlayer(Player player);
}
