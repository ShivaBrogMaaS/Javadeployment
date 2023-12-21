package com.test.time.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.time.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}
