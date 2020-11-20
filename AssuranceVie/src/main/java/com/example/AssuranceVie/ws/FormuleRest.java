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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api("")
@RestController
@RequestMapping("assurance-api/Formule")
public class FormuleRest {

	@Autowired
	FormuleService formuleService ;

	@ApiOperation("")
	@GetMapping("/find/reference/{reference}")
	public Formule findByReference(@PathVariable String reference) {
		return formuleService.findByReference(reference);
	}

	@ApiOperation("")
	@GetMapping("/find/libelle/{libelle}")
	public Formule findByLibelle(@PathVariable String libelle) {
		return formuleService.findByLibelle(libelle);
	}

	@ApiOperation("")
	@GetMapping("/find/produitFinancier")
	public List<Formule> findByProduitFinancier(@RequestBody ProduitFinancier produitFinancier) {
		return formuleService.findByProduitFinancier(produitFinancier);
	}

	@ApiOperation("")
	@PostMapping("/save/reference/{reference}/prix/{prix}")
	public void Modify(@PathVariable String reference, @PathVariable Double prix) {
		formuleService.Modify(reference, prix);
	}

	@ApiOperation("")
	@PostMapping("/save")
	public int save(@RequestBody Formule formule) {
		return formuleService.save(formule);
	}

	@ApiOperation("")
	@GetMapping("/find")
	public List<Formule> findAll() {
		return formuleService.findAll();
	}

	@ApiOperation("")
	@GetMapping("/find/id/{id}")
	public Optional<Formule> findById(@PathVariable Long id) {
		return formuleService.findById(id);
	}

	@ApiOperation("")
	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		formuleService.deleteById(id);
	}
	
	
}
