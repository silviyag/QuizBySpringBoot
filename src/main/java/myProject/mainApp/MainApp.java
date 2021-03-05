package myProject.mainApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import myProject.Model.Category;
import myProject.Model.Match;
import myProject.Model.Player;
import myProject.Model.Question;
import myProject.mainApp.Reader.CSVReader;
import myProject.mainApp.Repos.CategoryRepository;
import myProject.mainApp.Repos.MatchRepository;
import myProject.mainApp.Repos.PlayerRepository;
import myProject.mainApp.Repos.QuestionRepository;

@SpringBootConfiguration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class MainApp implements CommandLineRunner {

	@Autowired(required = true)
	private PlayerRepository playerRepository;
	@Autowired(required = true)
	private QuestionRepository questionRepository;
	@Autowired(required = true)
	private CategoryRepository categoryRepository;
	@Autowired(required = true)
	private MatchRepository matchRepository;
	CSVReader csv = new CSVReader();
	private static final Logger log = LoggerFactory.getLogger(MainApp.class);

	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		playerRepository.deleteAll();
		questionRepository.deleteAll();
		categoryRepository.deleteAll();
		matchRepository.deleteAll();
		
		readCsv();
		startMatch();
	}

	public void readCsv() {
		List<Question> questions = csv.readCSV();
	}

	public void startMatch() {

		playerRepository.save(new Player(1, "Sissi"));
		categoryRepository.save(new Category(2));
		questionRepository.save(new Question(2));
		
		categoryRepository.findAll();
		matchRepository.save(new Match(categoryRepository.findAll()));

		chooseCategory(2, 2);
		//analyseStart();
	}

	void chooseCategory(int numberOfCategories, int numberOfQuestions) {

		int index = 0;
		String choose;
		List<String> choosenCategory = new ArrayList<String>();
		Random random = new Random(); // zufaellige Zahl, um eine Kategorien auszuwaehlen

		while (index != numberOfCategories) {
			choose = csv.getAllCategories(random.nextInt(numberOfCategories + 1));// in den Klammern steht die Anzahl
																					// der Zahlen aus denen eine
																					// Zufällige ermittelt werden soll.
			choosenCategory.add(choose);
			index++;
		}

		game(choosenCategory, numberOfQuestions);
		// Optional: analyse Ergebnisse ausgeben
	}

	public void game(List<String> choosenCategory, int numberOfQuestions) {

		for (String choosen : choosenCategory) {
			for (Map.Entry<Integer, String> entry : csv.getHmText().entrySet()) {
				if (numberOfQuestions == 0) {
					break;// @toDo Warning ausgeben
				}

				if (entry.getValue().equals(choosen)) {
					int key = entry.getKey();
					for (int j = 0; j < csv.getQuesstion().size(); j++) {

						if (csv.getQuesstion().get(j).contains(String.valueOf(key))) {
							System.out.println(csv.getQuesstion().get(j));
							String answers = csv.getAnswers().get(j).substring(5, csv.getAnswers().get(j).length())
									.trim();
							System.out.println(answers);
							int answer = 1;

							answerTest(answer, key);// ob die Antwort richtig war
//							numberOfQuestions--;
							break;
						}
					}
				}
			}
		}
	}

	private void answerTest(int answer, int key) {

		int index = 1;
		for (int i = 0; i < csv.getCorrectAnswers().size(); i++) {
			String temp = csv.getCorrectAnswers().get(i)
					.substring(csv.getCorrectAnswers().get(i).length() - 2, csv.getCorrectAnswers().get(i).length())
					.trim();// right answer
			String temp2 = csv.getCorrectAnswers().get(i).substring(0, csv.getCorrectAnswers().get(i).length() - 1)
					.trim();// id of the question

			if (temp2.equals(String.valueOf(key))) {
				if (temp.equals(String.valueOf(answer))) {
					System.out.println("Richtig");
					index++;
					break;
				} else {
					System.out.println("Falsch");
					index--;
					break;
				}
			}
		}

//        String playerIdData = String.valueOf(getPlayer().getPlayerId());
//        indexOfAnswers.add(String.valueOf(index) + " " + playerIdData);
//        analyse.setIndexOfAnswers(indexOfAnswers);
		// new Analyse(index, player.getPlayerId());
	}
}