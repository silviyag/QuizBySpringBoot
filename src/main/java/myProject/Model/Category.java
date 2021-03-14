package myProject.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	@ManyToOne
	private Match match;
	@OneToMany(mappedBy = "category") // bidirectional association. category is owner of this relationship
	private List<Question> questions;
	private String categoryTitle;

	public Category() {
		// default
	}

	public Category(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Vector<Question> questions) {
		this.questions = questions;
	}

	public String getCategoryTitle() {
		return this.categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
}
