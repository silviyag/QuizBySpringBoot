
package myProject.Model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matches")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matchId;
	@OneToOne
	private Player player;
	@OneToMany(mappedBy = "match")
	private List<Category> categories; // selected categories
	private Optional<Question> question; // selected question to one category

	public Match() {
		// default
	}

	public Match(Player player) {
		this.player = player;
	}

	public Match(List<Category> categories) {
		this.categories = categories;
	}

	public Match(Optional<Question> question) {
		this.question = question;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public void  setCategories(List<Category>categories) {
		 this.categories=categories;
	}

	public Optional<Question> getQuestion() {
		return question;
	}
	
	public void getQuestion(Optional<Question> question) {
		 this.question=question;
	}
}
