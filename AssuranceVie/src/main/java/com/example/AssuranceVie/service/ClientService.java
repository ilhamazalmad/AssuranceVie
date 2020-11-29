package com.example.AssuranceVie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.ClientDao;

@Service
public class ClientService {
	
	@Autowired ClientDao clientDao;

}
