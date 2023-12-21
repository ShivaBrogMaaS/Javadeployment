package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.time.dao.ClientRepo;
import com.test.time.dao.ProjectRepo;
import com.test.time.model.Client;
import com.test.time.model.Project;

@Service
@Transactional
public class ProjectService {
	@Autowired
	private ProjectRepo repo;
	@Autowired
	private ClientRepo repo1;

	public List<Project> listAll() {
		return repo.findAll();
	}

	public void save(Project p) {
		repo.save(p);
	}

	public Project get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public List<Client> findPo(String name) {
		return repo1.findAllByPo(name);

	}

	public List<Project> dateProject(String name) {
		return repo.findByProject(name);

	}

}
