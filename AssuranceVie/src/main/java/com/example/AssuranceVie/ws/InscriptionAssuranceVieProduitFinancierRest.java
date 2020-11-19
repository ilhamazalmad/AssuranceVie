package com.example.AssuranceVie.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.service.InscriptionAssuranceVieProduitFinancierService;

@RestController
@RequestMapping("assurance-api/IAVPF")
public class InscriptionAssuranceVieProduitFinancierRest {

	@Autowired
	InscriptionAssuranceVieProduitFinancierService 	iAVPFService;
@GetMapping("/getall")
public List<InscriptionAssuranceVieProduitFinancier> getAll(){
	return iAVPFService.findAll();
}
}
