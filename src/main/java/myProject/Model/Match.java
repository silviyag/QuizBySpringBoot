
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
	private Optional<Question> question; // selected questions

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

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addCatgory(Category category) {
		categories.add(category);
	}

	public void deleteCategoryByPosition(int position) {
		categories.remove(position);
	}

	public void deleteCategoryById(int categoryId) {
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getCategoryId() == categoryId) {
				categories.remove(i);
				break;
			}
		}
	}
	
	public Optional<Question> getQuestion() {
		return question;
	}
}
