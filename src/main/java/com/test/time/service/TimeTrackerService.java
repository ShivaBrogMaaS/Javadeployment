package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.time.dao.TimeTrackerRepo;
import com.test.time.model.TimeTracker;

@Service
@Transactional
public class TimeTrackerService {
	@Autowired
	private TimeTrackerRepo repo;

	public List<TimeTracker> listAll() {
		return repo.findAll();
	}

	public void save(TimeTracker tt) {
		repo.save(tt);
	}

	public TimeTracker get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}
