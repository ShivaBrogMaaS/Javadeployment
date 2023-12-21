package com.test.time.others;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StateRepo extends JpaRepository<State, Integer> {
	@Query(value = "select * from states where country_id= ?1", nativeQuery = true)
	List<State> findState(@Param("country_id") int country_id);

	@Query(value = "select * from states where name= ?1", nativeQuery = true)
	List<State> findStateName(@Param("name") String name);

}
