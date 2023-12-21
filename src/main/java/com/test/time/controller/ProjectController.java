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
import com.test.time.model.Group;
import com.test.time.model.Project;
import com.test.time.service.ClientService;
import com.test.time.service.GroupService;
import com.test.time.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ClientService indhu;
	@Autowired
	private ProjectService service;
	@Autowired
	private GroupService service1;
	String shiva1 = "";
	String sd = "";
	String ed = "";

	@RequestMapping("/newProject")
	public String addpro(Model m) {
		Project p = new Project();
		m.addAttribute("project", p);
		List<Client> shiva = indhu.listAll();
		m.addAttribute("shiva", shiva);
		List<Group> serv1 = service1.listAll();
		m.addAttribute("shiva1", serv1);
		return "project";

	}

	@PostMapping("/addproject")
	public String saveProduct(@ModelAttribute("project") Project p) {
		service.save(p);
		return "redirect:/ProjectList";
	}

	@RequestMapping("/ProjectList")
	public String viewHomePage(Model model) {
		Project p = new Project();
		model.addAttribute("project", p);
		List<Client> shiva = indhu.listAll();
		model.addAttribute("shiva", shiva);
		List<Group> serv1 = service1.listAll();
		model.addAttribute("shiva1", serv1);
		List<Project> client = service.listAll();
		model.addAttribute("project1", client);
		return "projectlist";
	}

	@RequestMapping("/deletepro/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/ProjectList";
	}

	@RequestMapping("/podash/{name}")
	@ResponseBody
	public String showPoNumber(@PathVariable("name") String name) {
		if (name != null) {
			return service.findPo(name).get(0).getPoamount();
		} else {
			return "";
		}
	}

	@RequestMapping("/podash1/{name}")
	@ResponseBody
	public String showSpoc(@PathVariable("name") String name) {
		if (name != null) {
			return service.findPo(name).get(0).getSpoc();
		} else {
			return "";
		}
	}

	@RequestMapping("editpro/podash/{name}")
	@ResponseBody
	public String showPoNumber1(@PathVariable("name") String name) {
		if (name != null) {
			return service.findPo(name).get(0).getPoamount();
		} else {
			return "";
		}
	}

	@RequestMapping("editpro/podash1/{name}")
	@ResponseBody
	public String showSpoc1(@PathVariable("name") String name) {
		if (name != null) {
			return service.findPo(name).get(0).getSpoc();
		} else {
			return "";
		}
	}

	@RequestMapping("/dash/{name}")
	@ResponseBody
	public String showValidDate(@PathVariable("name") String name) {
		if (name != null) {
			return service.dateProject(name).get(0).getStartdate();
		} else {
			return "";
		}
	}

	@RequestMapping("/dash1/{name}")
	@ResponseBody
	public String showValidDate1(@PathVariable("name") String name) {
		if (name != null) {
			return service.dateProject(name).get(0).getEnddate();
		} else {
			return "";
		}
	}

	@RequestMapping("edittimetracker/dash/{name}")
	@ResponseBody
	public String showValidDatee1(@PathVariable("name") String name) {
		if (name != null) {
			return service.dateProject(name).get(0).getStartdate();
		} else {
			return "";
		}
	}

	@RequestMapping("edittimetracker/dash1/{name}")
	@ResponseBody
	public String showValidDate11(@PathVariable("name") String name) {
		if (name != null) {
			return service.dateProject(name).get(0).getEnddate();
		} else {
			return "";
		}
	}

}
