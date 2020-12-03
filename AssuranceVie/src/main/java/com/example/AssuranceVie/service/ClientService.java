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

	public int save(Client client) {
		if(client != null && findByCin(client.getCin()) == null && findByTelephone(client.getTelephone()) == null ) {
			clientDao.save(client);
			return 1;
		}	 
		else return -1;
	}

	
	public Client findByCin(String cin) {
		return clientDao.findByCin(cin);
	}


	public Client findByTelephone(Long telephone) {
		return clientDao.findByTelephone(telephone);
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
