package com.test.time.others;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/maincountry/api")
public class ConMainController {
	@Autowired
	private CountryRepo repo1;
	@Autowired
	private StateRepo repo2;
	@Autowired
	private CityRepo repo3;
	String s = "";

	@RequestMapping("/country")
	public String showCountry(Model mv) {
		List<Country> shiva = repo1.findAll();
		mv.addAttribute("shiva", shiva);
		return "country";
	}

	@RequestMapping("/countryId/{name}")
	@ResponseBody
	public int getId(@PathVariable("name") String name) {
		int as = repo1.findAllById(name).get(0).getId();
		return as;
	}

	@GetMapping("/stateWithId/{country_id}")
	@ResponseBody
	public List<State> getStateId(@PathVariable("country_id") int country_id, Model mv) {
		List<State> rs = new ArrayList<State>();
		rs = repo2.findState(country_id);
		return rs;
	}

	@RequestMapping("/stateId/{name}")
	@ResponseBody
	public int showMainCity(@PathVariable("name") String name) {
		return repo2.findStateName(name).get(0).getId();

	}

	@GetMapping("/cityWithId/{state_id}")
	@ResponseBody
	public List<City> getStateId1(@PathVariable("state_id") int state_id) {
		List<City> rs1 = new ArrayList<City>();
		rs1 = repo3.findCity(state_id);
		return rs1;
	}

}
