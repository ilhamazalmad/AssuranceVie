package com.example.AssuranceVie.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.service.FormuleService;
@RestController
@RequestMapping("assurance-api/Formule")
public class FormuleRest {

	@Autowired
	FormuleService formuleService ;

	@GetMapping("/find/reference/{reference}")
	public Formule findByReference(@PathVariable String reference) {
		return formuleService.findByReference(reference);
	}

	@GetMapping("/find/libelle/{libelle}")
	public Formule findByLibelle(@PathVariable String libelle) {
		return formuleService.findByLibelle(libelle);
	}

	/*
	@GetMapping("/find/produitFinancier")
	public List<Formule> findByProduitFinancier(@RequestBody ProduitFinancier produitFinancier) {
		return formuleService.findByProduitFinancier(produitFinancier);
	}

	@PostMapping("/save/reference/{reference}/prix/{prix}")
	public void Modify(@PathVariable String reference, @PathVariable Double prix) {
		formuleService.Modify(reference, prix);
	}*/

	@PostMapping("/save")
	public int save(@RequestBody Formule formule) {
		return formuleService.save(formule);
	}

	@GetMapping("/find")
	public List<Formule> findAll() {
		return formuleService.findAll();
	}

	@GetMapping("/find/id/{id}")
	public Optional<Formule> findById(@PathVariable Long id) {
		return formuleService.findById(id);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		formuleService.deleteById(id);
	}
	
	
}
