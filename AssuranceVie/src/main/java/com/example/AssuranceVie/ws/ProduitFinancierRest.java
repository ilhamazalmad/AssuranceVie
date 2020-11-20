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
import com.example.AssuranceVie.service.ProduitFinancierService;

@RestController
@RequestMapping("assurance-api/Produit")
public class ProduitFinancierRest {


	@Autowired
	ProduitFinancierService produitFinancierService;
	@GetMapping("find/libelle/{libelle}")
	public ProduitFinancier findByLibelle(@PathVariable String libelle) {
		return produitFinancierService.findByLibelle(libelle);
	}

	@GetMapping("find/code/{code}")
	public ProduitFinancier findByCode(@PathVariable String code) {
		return produitFinancierService.findByCode(code);
	}

	/*@PostMapping("/save/id/{id}")
	public void addFormule(@PathVariable Long id, @RequestBody Formule formule) {
		produitFinancierService.addFormule(id, formule);
	}*/

	@PostMapping("/save")
	public int save(@RequestBody ProduitFinancier produitFinancier) {
		return produitFinancierService.save(produitFinancier);
	}

	@GetMapping("/find")
	public List<ProduitFinancier> findAll() {
		return produitFinancierService.findAll();
	}

	@GetMapping("/find/id/{id}")
	public Optional<ProduitFinancier> findById(@PathVariable Long id) {
		return produitFinancierService.findById(id);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		produitFinancierService.deleteById(id);
	}


}
