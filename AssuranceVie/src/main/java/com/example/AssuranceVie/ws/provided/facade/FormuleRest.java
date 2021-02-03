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
import com.example.AssuranceVie.service.facade.FormuleService;
import com.example.AssuranceVie.ws.provided.converter.FormuleConverter;
import com.example.AssuranceVie.ws.provided.converter.ProduitConverter;
import com.example.AssuranceVie.ws.provided.dto.FormuleDto;
@RestController
@RequestMapping("assurance-api/Formule")
@CrossOrigin(origins="http://localhost:4200")

public class FormuleRest {

	@Autowired
	FormuleService formuleService ;
	@Autowired
	FormuleConverter formuleConverter;
	@Autowired
	ProduitConverter produitConverter; 
	
	@GetMapping("/find/reference/{reference}")
	public FormuleDto findByReference(@PathVariable String reference) {
		return formuleConverter.toVo(formuleService.findByReference(reference));
	}

	@GetMapping("/find/libelle/{libelle}")
	public FormuleDto findByLibelle(@PathVariable String libelle) {
		return formuleConverter.toVo(formuleService.findByLibelle(libelle));
	}

	
	@GetMapping("/find/produitFinancier/{produitFinancier}")
	public List<FormuleDto> findByProduitFinancier(@PathVariable Long produitFinancier) {
		formuleConverter.setProduit(true);
		produitConverter.setFormules(false);
		produitConverter.setiAVPF(false);
		return formuleConverter.toVo(formuleService.findByProduitFinancier(produitFinancier));
	}

	@PostMapping("/save")
	public int save(@RequestBody FormuleDto formule) {

		return formuleService.save(formuleConverter.toBean(formule));
	}

	@GetMapping("/find")
	public List<FormuleDto> findAll() {
		return formuleConverter.toVo(formuleService.findAll());
	}

	@GetMapping("/find/id/{id}")
	public FormuleDto findById(@PathVariable Long id) {
		return formuleConverter.toVo(formuleService.findById(id));
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		formuleService.deleteById(id);
	}
	
	
}
