package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.time.dao.GroupRepo;
import com.test.time.model.Group;

@Service
@Transactional
public class GroupService {
	@Autowired
	private GroupRepo repo;

	public List<Group> listAll() {
		return repo.findAll();
	}

	public void save(Group c) {
		repo.save(c);
	}

	public Group get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}
