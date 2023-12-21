package com.test.time.others;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepo extends JpaRepository<City, Integer> {

	@Query(value = "select * from cities where state_id= ?1", nativeQuery = true)
	List<City> findCity(@Param("state_id") int state_id);

}
