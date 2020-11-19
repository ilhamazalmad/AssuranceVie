package com.example.AssuranceVie.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.service.ProduitFinancierService;

@RestController
@RequestMapping("assurance-api/Produit")
public class ProduitFinancierRest {

	@Autowired
	ProduitFinancierService produitFinancierService;

}
