package myProject.mainApp.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import myProject.Model.Match;
import myProject.mainApp.Interfaces.MatchService;

@Controller
public class MatchController implements MatchService{

	MatchService matchRepository;

	public MatchController(MatchService matchRepository) {
		this.matchRepository = matchRepository;
	}

	@GetMapping
	public List<Match> findAll() {
		return matchRepository.findAll();
	}
	
	@GetMapping("/match")
	public String getMatch(Model model) {
		model.addAttribute("match", new Match());
		return "matches/match_form";
	}

	@PostMapping(value = "/match")
	public String submitMatch(Match match, Model model) {
		Match result = this.matchRepository.save(match);
		model.addAttribute("submitted", true);
		model.addAttribute("match", result);
		return "matches/match_form";
	}

	@GetMapping("/matches")
	public String getMatches(Model model) {
		return "matches/match_list";
	}

	@Override
	public Match save(Match match) {
		// TODO Auto-generated method stub
		return null;
	}
}
