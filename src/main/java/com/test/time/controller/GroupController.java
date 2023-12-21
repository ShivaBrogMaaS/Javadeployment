package com.test.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.time.model.Group;
import com.test.time.model.Team;
import com.test.time.service.GroupService;
import com.test.time.service.TeamService;

@Controller
public class GroupController {
	@Autowired
	private TeamService serv;
	@Autowired
	private GroupService serv1;

	@RequestMapping("/newMemb")
	public String home(Model mv) {
		List<Team> t = serv.listAll();
		mv.addAttribute("team", t);
		Group g = new Group();
		mv.addAttribute("Group", g);
		return "group";
	}

	@PostMapping("/addGroup")
	public String addGroup(@ModelAttribute("Group") Group g) {
		serv1.save(g);
		return "redirect:/GroupList";

	}

	@RequestMapping("/GroupList")
	public String viewHomePage(Model model) {
		List<Team> t = serv.listAll();
		model.addAttribute("team", t);
		Group g = new Group();
		model.addAttribute("Group", g);
		List<Group> c = serv1.listAll();
		model.addAttribute("Group1", c);
		return "grouplist";
	}

	@RequestMapping("/deletegro/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		serv1.delete(id);
		return "redirect:/GroupList";
	}

}
