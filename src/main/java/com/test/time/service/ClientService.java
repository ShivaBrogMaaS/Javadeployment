package com.test.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.time.dao.ClientRepo;
import com.test.time.model.Client;

@Service
@Transactional
public class ClientService 
{

@Autowired
private ClientRepo repo;

public List<Client> listAll() {
	return repo.findAll();
}

public void save(Client c) {
	repo.save(c);
}

public Client get(int id) {
	return repo.findById(id).get();
}

public void delete(int id) {
	repo.deleteById(id);
}
}
