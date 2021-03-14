package myProject.mainApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import myProject.Model.Match;
import myProject.mainApp.Interfaces.AnswerService;
import myProject.mainApp.Interfaces.CategoryService;
import myProject.mainApp.Interfaces.MatchService;
import myProject.mainApp.Interfaces.PlayerService;
import myProject.mainApp.Interfaces.QuestionService;
import myProject.mainApp.Reader.CSVReader;

@SpringBootConfiguration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class MainApp implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MatchService matchService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private PlayerService playerService;

	CSVReader csv = new CSVReader();
	private static final Logger log = LoggerFactory.getLogger(MainApp.class);

	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// @todo save data while reading
		csv.readCSV();// read data
		prepareData();
	}

	public void prepareData() {
		randomCategory();
		Long questionId = randomQuestion();

		// add player
		// find question by id
		// save questiion into a match

		game(questionId);
	}

	void randomCategory() { // simulate selection of category
		String cat1 = csv.getAllCategories(3);// @todo use random to select categories
		// save category 1
		String cat2 = csv.getAllCategories(6);// @todo use random to select categories
		// save category 2
	}

	protected Long randomQuestion() {// simulate selection of question, it answers and correct answer
		// 1. find all categories and random one category from the list
		// 2. find this in the hashmap csv.getHmText() and get the id oft the question
		Long questionId = null;
		int correctAnswer = 0;
		// 3. getQuestion(), getAnswers(), getCorrectAnswer()
		// 4. save question ,category,answers and correct answer into Question Object
		// save answer (Answer object) with  questionId
		return questionId;
	}

	public void game(Long questionId) {
		// find all amtches
		// find question by id
		// check if founded matches contains questionId
		Match match = null;
		// get match with this questionId
		// find question into the match and display answers
		// select correct answer
		int correctAnswer = 0;
		answerTest(correctAnswer, questionId, match);
	}

	private void answerTest(int answer, Long questionId, Match match) {
		// get correct answer from match and check it
	}
}