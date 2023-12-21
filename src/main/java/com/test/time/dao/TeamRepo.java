package com.test.time.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.time.model.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
	@Query(value = "select * from team where name= ?1", nativeQuery = true)
	Team findByEmail(@Param("name") String name);

	@Query(value = "select * from team where name= ?1", nativeQuery = true)
	List<Team> findAllByEmail(@Param("name") String name);

}
