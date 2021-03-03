package myProject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long playerId;
	private String playerName;
	@OneToOne(mappedBy = "player")
	private Match currentMatch;
	private int matchesPlayed;
	private int score;

	public Player() {
		//
	}
	
	public Player(long id, String name) {
		super();
		this.playerId = id;
		this.playerName = name;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long id) {
		playerId = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String name) {
		playerName = name;
	}

	public Match getCurrentMatch() {
		return currentMatch;
	}

	public void setCurrentMatch(Match match) {
		currentMatch = match;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matches) {
		matchesPlayed = matches;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Player [id=" + playerId + ", firstName=" + playerName + "]";
	}
}
