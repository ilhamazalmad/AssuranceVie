package com.example.AssuranceVie.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.dao.ClientDao;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

	@Autowired
	ClientDao clientDao;

	/*public int save(Client cli) {
		if (clientDao.findByCin(cli.getCin()) ==null)
		{
			clientDao.save(cli);
			return 1;
		}
		else
			return -1;
	}*/
	public Client findByCin(String cin) {
		return clientDao.findByCin(cin);
	}

	public int save(Client client) {
		if (client != null && findByCin(client.getCin()) == null && findByTelephone(client.getTelephone()) == null) {
			clientDao.save(client);
			return 1;
		} else return -1;
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

	public int loginorregister(Long tel, String cin) {
		int res=0;
		Client clie;
		if (tel == null || cin == null) {
			res = -1;
		}else if (clientDao.findByCin(cin) == null || clientDao.findByTelephone(tel) == null) {
			res = 1;
		}else if (clientDao.findByCin(cin) == null && clientDao.findByTelephone(tel) == null) {
			Client cli = new Client(cin, tel);
			clientDao.save(cli);
			res = 2;
		} else if (clientDao.findByCin(cin) != null && clientDao.findByTelephone(tel) != null) {
			clie = clientDao.findByTelephone(tel);
			res = 3;
		}

		return res;
	}
}
