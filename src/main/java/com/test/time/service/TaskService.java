package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.time.dao.TaskRepo;
import com.test.time.dao.TeamRepo;
import com.test.time.model.Task;
import com.test.time.model.Team;

@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskRepo repo;
	@Autowired
	private TeamRepo repo2;

	public List<Task> listAll() {
		return repo.findAll();
	}

	public void save(Task t) {
		repo.save(t);
	}

	public Task get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public List<Team> showViews(String name) {

		return repo2.findAllByEmail(name);

	}

}
