package com.example.AssuranceVie.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.service.FormuleService;

@RestController
@RequestMapping("assurance-api/Formule")
public class FormuleRest {

	@Autowired
	FormuleService formuleService ;
}
