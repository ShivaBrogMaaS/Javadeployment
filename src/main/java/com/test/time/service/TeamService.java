package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.time.dao.TeamRepo;
import com.test.time.model.Team;

@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepo repo;

	public List<Team> listAll() {
		return repo.findAll();
	}

	public void save(Team t) {
		repo.save(t);
	}

	public Team get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public String name(String name) {
		return repo.findByEmail(name).getEmail();

	}
}
