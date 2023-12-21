package com.test.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.time.model.Client;
import com.test.time.model.Project;
import com.test.time.model.Task;
import com.test.time.model.Team;
import com.test.time.service.ClientService;
import com.test.time.service.ProjectService;
import com.test.time.service.TaskService;
import com.test.time.service.TeamService;

@Controller
public class TaskController {

	@Autowired
	private TaskService rajan;
	@Autowired
	private ClientService serv;
	@Autowired
	private ProjectService dhinesh;
	@Autowired
	private TeamService teamservice;

	@RequestMapping("/newTask")
	public String task(Model pramo) {
		List<Client> shiva = serv.listAll();
		pramo.addAttribute("shiva", shiva);
		List<Project> proname = dhinesh.listAll();
		pramo.addAttribute("proname", proname);
		List<Team> indhu = teamservice.listAll();
		pramo.addAttribute("indhu", indhu);
		Task t = new Task();
		pramo.addAttribute("task", t);
		return "Task";

	}

	@PostMapping("/addTask")
	public String addTask(@ModelAttribute("task") Task t) {
		rajan.save(t);
		return "redirect:/TaskList";

	}

	@RequestMapping("/TaskList")
	public String viewHomePage(Model model) {
		List<Client> shiva = serv.listAll();
		model.addAttribute("shiva", shiva);
		List<Project> proname = dhinesh.listAll();
		model.addAttribute("proname", proname);
		List<Team> indhu = teamservice.listAll();
		model.addAttribute("indhu", indhu);
		Task t = new Task();
		model.addAttribute("task", t);
		List<Task> client = rajan.listAll();
		model.addAttribute("task1", client);
		return "tasklist";
	}

	@RequestMapping("/deletetask/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		rajan.delete(id);
		return "redirect:/TaskList";
	}

	@RequestMapping("/podash2/{name}")
	@ResponseBody
	public String deleteProduct1(@PathVariable("name") String name) {
		if (name != null) {
			return rajan.showViews(name).get(0).getPhone();
		} else {
			return "";
		}

	}

	@RequestMapping("/podash3/{name}")
	@ResponseBody
	public String deleteProduct2(@PathVariable("name") String name) {
		if (name != null) {
			return rajan.showViews(name).get(0).getEmail();
		} else {
			return "";
		}

	}

	@RequestMapping("edittask/podash2/{name}")
	@ResponseBody
	public String deleteProduct3(@PathVariable("name") String name) {
		if (name != null) {
			return rajan.showViews(name).get(0).getPhone();
		} else {
			return "";
		}

	}

	@RequestMapping("edittask/podash3/{name}")
	@ResponseBody
	public String deleteProduct4(@PathVariable("name") String name) {
		if (name != null) {
			return rajan.showViews(name).get(0).getEmail();
		} else {
			return "";
		}

	}

}
