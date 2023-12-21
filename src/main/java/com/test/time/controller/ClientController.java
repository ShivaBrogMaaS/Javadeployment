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
import com.test.time.service.ClientService;

@Controller
public class ClientController
{
	@Autowired
	private ClientService indhu;

	@RequestMapping("/ClientList")
	public String viewHomePage(Model model) {
		Client c = new Client();
		model.addAttribute("shiva", c);
		List<Client> client = indhu.listAll();
		model.addAttribute("client", client);

		return "clientlist";
	}

	@RequestMapping("/newclient")
	public String home(Model mv) {
		Client c = new Client();
		mv.addAttribute("client", c);
		return "client";
	}

	@PostMapping("/addclient")
	public String addClient(@ModelAttribute("client") Client c) {
		// System.out.println(c);
		indhu.save(c);
		return "redirect:/ClientList";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		indhu.delete(id);
		return "redirect:/ClientList";
	}

}
