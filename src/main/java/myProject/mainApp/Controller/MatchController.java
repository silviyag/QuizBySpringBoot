package myProject.mainApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import myProject.Model.Match;
import myProject.mainApp.Repos.MatchRepository;

@Controller
public class MatchController {

	MatchRepository matchRepository;

	public MatchController(MatchRepository matchRepository) {
		this.matchRepository = matchRepository;
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
}
