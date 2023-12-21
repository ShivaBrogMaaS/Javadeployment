package com.test.time.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.time.model.User;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByName(String name);

	@Modifying
	@Query(value = "update sys.user set password =?1 where email =?2", nativeQuery = true)
	void findByPassword(@Param("password") String password, @Param("email") String email);

	@Modifying
	@Query(value = "update sys.user set password =?1 where password =?2", nativeQuery = true)
	void findByNewPassword(@Param("password") String password, @Param("password") String oldpassword);

	@Query(value = "select * from sys.user  where email =?1", nativeQuery = true)
	List<User> findByEmail(@Param("email") String email);

	@Query(value = "select * from sys.user  where name =?1", nativeQuery = true)
	List<User> findByNameStan(@Param("name") String name);

}
