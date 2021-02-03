package com.example.AssuranceVie.ws.provided.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.service.facade.ProduitFinancierService;
import com.example.AssuranceVie.ws.provided.converter.ProduitConverter;
import com.example.AssuranceVie.ws.provided.dto.ProduitFinancierDto;

@RestController
@RequestMapping("assurance-api/Produit")
@CrossOrigin(origins="http://localhost:4200")

public class ProduitFinancierRest {


	@Autowired
	ProduitFinancierService produitFinancierService;
	@Autowired
	ProduitConverter produitConverter;
	
	@GetMapping("find/libelle/{libelle}")
	public ProduitFinancierDto findByLibelle(@PathVariable String libelle) {
		produitConverter.setFormules(false);
		produitConverter.setiAVPF(false);
		return produitConverter.toVo(produitFinancierService.findByLibelle(libelle));
	}

	@GetMapping("find/code/{code}")
	public ProduitFinancierDto findByCode(@PathVariable String code) {
		return produitConverter.toVo(produitFinancierService.findByCode(code));
	}

	@PostMapping("/save")
	public int save(@RequestBody ProduitFinancierDto produitFinancier) {
		return produitFinancierService.save(produitConverter.toBean(produitFinancier));
	}

	@GetMapping("/find")
	public List<ProduitFinancierDto> findAll() {
		return produitConverter.toVo(produitFinancierService.findAll());
	}

	@GetMapping("/find/id/{id}")
	public ProduitFinancierDto findById(@PathVariable Long id) {
		return produitConverter.toVo(produitFinancierService.findById(id));
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		produitFinancierService.deleteById(id);
	}


	/*
	@PutMapping("/save/id/{id}")
	public void addFormule(@PathVariable Long id, @RequestBody Formule formule) {
		produitFinancierService.addFormule(id, formule);
	}*/

}
