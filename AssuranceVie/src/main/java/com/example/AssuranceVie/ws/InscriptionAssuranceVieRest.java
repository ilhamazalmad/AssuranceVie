package com.example.AssuranceVie.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;

@RestController
@RequestMapping("assurance-api/IAV")
public class InscriptionAssuranceVieRest {

	@Autowired
	InscriptionAssuranceVie iAVService;
}
