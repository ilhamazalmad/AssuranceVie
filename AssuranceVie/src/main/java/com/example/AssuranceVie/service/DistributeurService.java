package com.example.AssuranceVie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.DistributeurDao;

@Service
public class DistributeurService {

	@Autowired
	DistributeurDao distributeurDao;
	
}
