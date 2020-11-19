package com.example.AssuranceVie.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.service.DistributeurService;

@RestController
@RequestMapping("assurance-api/Distributeur")
public class DistributeurRest {

	@Autowired
	DistributeurService distributeurService; 
}
