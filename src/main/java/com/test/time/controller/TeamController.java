package com.test.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.time.model.Team;
import com.test.time.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService shobana;

	@RequestMapping("/newTeam")
	public String showView(Model pramo) {
		Team t = new Team();
		pramo.addAttribute("team", t);
		return "Team";
	}

	@PostMapping("/addTeam")
	public String addNewTeam(@ModelAttribute("team") Team t) {
		shobana.save(t);
		return "redirect:/TeamList";
	}

	@RequestMapping("/TeamList")
	public String viewHomePage(Model model) {
		Team t = new Team();
		model.addAttribute("team", t);
		List<Team> c = shobana.listAll();
		model.addAttribute("team1", c);
		return "teamlist";
	}

	@RequestMapping("/deleteteam/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		shobana.delete(id);
		return "redirect:/TeamList";
	}

}
