package com.test.time.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.time.model.TimeTracker;

public interface TimeTrackerRepo extends JpaRepository<TimeTracker, Integer> {

}
