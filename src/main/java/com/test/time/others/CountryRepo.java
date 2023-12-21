package com.test.time.others;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepo extends JpaRepository<Country, Integer> {

	@Query(value = "select * from countries where name= ?1", nativeQuery = true)
	List<Country> findAllById(@Param("name") String name);

}
