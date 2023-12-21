package com.test.time.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.time.model.Project;

@Repository()
public interface ProjectRepo extends JpaRepository<Project, Integer> {
	@Query(value = "select * from sys.project  where projectname =?1", nativeQuery = true)
	List<Project> findByProject(@Param("projectname") String projectname);
}
