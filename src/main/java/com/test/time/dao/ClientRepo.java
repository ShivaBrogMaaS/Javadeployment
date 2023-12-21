package com.test.time.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.time.model.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>
{
@Query(value = "select * from sys.client  where name =?1", nativeQuery = true)
List<Client> findAllByPo(@Param("name") String name);
}
