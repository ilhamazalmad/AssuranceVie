package com.example.AssuranceVie.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.dao.ClientDao;

@Service
public class ClientService {
	
	@Autowired ClientDao clientDao;

	public Client save(Client client) {
		return clientDao.save(client);
	}

	public Optional<Client> findById(Long id) {
		return clientDao.findById(id);
	}

	public Iterable<Client> findAll() {
		return clientDao.findAll();
	}

	@Transactional
	public void deleteById(Long id) {
		clientDao.deleteById(id);
	}

	
	
	

}
