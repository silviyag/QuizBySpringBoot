package myProject.mainApp.Interfaces;

import java.util.List;

import myProject.Model.Match;

public interface MatchService  {

	List<Match> findAll();

	Match save(Match match);
	
}
