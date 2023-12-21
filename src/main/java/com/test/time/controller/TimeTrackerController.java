package com.test.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.time.model.Client;
import com.test.time.model.Project;
import com.test.time.model.Task;
import com.test.time.model.Team;
import com.test.time.model.TimeTracker;
import com.test.time.service.ClientService;
import com.test.time.service.ProjectService;
import com.test.time.service.TaskService;
import com.test.time.service.TeamService;
import com.test.time.service.TimeTrackerService;

@Controller
public class TimeTrackerController {

	@Autowired
	private TimeTrackerService dhinesh;
	@Autowired
	private ClientService serv;
	@Autowired
	private ProjectService ironman;
	@Autowired
	private TaskService thor;
	@Autowired
	private TeamService cap;

	@RequestMapping("/newTimeTracker")
	public String viewTime(Model indhu) {
		List<Client> shiva = serv.listAll();
		indhu.addAttribute("shiva", shiva);
		List<Project> tony = ironman.listAll();
		indhu.addAttribute("tony", tony);
		List<Task> tho = thor.listAll();
		indhu.addAttribute("tho", tho);
		List<Team> thanos = cap.listAll();
		indhu.addAttribute("thanos", thanos);
		TimeTracker tt = new TimeTracker();
		indhu.addAttribute("timetracker", tt);
		return "timetracker";

	}

	@PostMapping("/addTimeTracker")
	public String addTimeTracker(@ModelAttribute("timetracker") TimeTracker tt) {
		dhinesh.save(tt);
		return "redirect:/TimeTrackerList";
	}

	@RequestMapping("/TimeTrackerList")
	public String viewHomePage(Model model) {
		List<TimeTracker> client = dhinesh.listAll();
		model.addAttribute("timetracker1", client);
		List<Client> shiva = serv.listAll();
		model.addAttribute("shiva", shiva);
		List<Project> tony = ironman.listAll();
		model.addAttribute("tony", tony);
		List<Task> tho = thor.listAll();
		model.addAttribute("tho", tho);
		List<Team> thanos = cap.listAll();
		model.addAttribute("thanos", thanos);
		TimeTracker tt = new TimeTracker();
		model.addAttribute("timetracker", tt);
		return "timetrackerlist";
	}

	@RequestMapping("/deletetimetracker/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		dhinesh.delete(id);
		return "redirect:/TimeTrackerList";
	}

}
