package com.test.time.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.time.model.Group;

public interface GroupRepo extends JpaRepository<Group, Integer> {

}
