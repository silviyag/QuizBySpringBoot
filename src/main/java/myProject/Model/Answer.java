 
package myProject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // to configure the way of increment of the specified column(field).
													// Get the next unique primary key for the entities
	private int answerId;
	@ManyToOne
	private Question question;// many answer to one question
	private Long questionId;// many answer to one question
	private String answerText;
	private int correctAnswer;

	public Answer() {
		// default
	}

	public Answer(String answer) {
		this.answerText = answer;
	}

	public Answer(Long questionId, int correctAnswer) {
		this.correctAnswer = correctAnswer;
		this.questionId = questionId;
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int id) {
		this.answerId = id;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String text) {
		answerText = text;
	}
}
