package com.example.AssuranceVie.service.facade;

import java.util.List;


import java.util.Optional;

import javax.transaction.Transactional;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	

	public Client findByPwd(String pwd) {
		return clientDao.findByPwd(pwd);
	}


	public int save(Client client) {
		try{
			if (client != null && empty(client.getCin()) == -1 && findByCin(client.getCin()) == null
					&& findByTelephone(client.getTelephone()) == null) {
			clientDao.save(client);
			return 1;
			}
			else return -1;
		}catch (Exception e) {
			// TODO: handle exception
			 return -2;
		}
	}

	
	public Client findByTelephone(Long telephone) {
		return clientDao.findByTelephone(telephone);
	}


	public Client findById(Long id) {
		return clientDao.findById(id).get();
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Transactional
	public void deleteById(Long id) {
		clientDao.deleteById(id);
	}

	public Client loginorregister(String cin, String pwd) {
		//String cin = client.getCin();
		//String pwd = client.getPwd();
		int res=0;
		Client loginClient = null;
		if (empty(pwd) == 1 || empty(cin) == 1 ) {
			loginClient = null;//res = -2;
		}else if (clientDao.findByCin(cin) == null ) {
			Client registerClient = new Client(cin,pwd);
			clientDao.save(registerClient);
			loginClient = registerClient;//res = 1;
		} else if (clientDao.findByCin(cin) != null ) {
			loginClient= clientDao.findByCin(cin);
			if(!loginClient.getPwd().equals(pwd))
				loginClient = null;//res = -1;
		}
		return loginClient;
	}
	
	public int empty(String text) {
		if(text==null || text.isEmpty()) 
			return 1;
		else return -1;
	}
	
}
