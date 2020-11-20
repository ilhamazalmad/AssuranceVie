package com.example.AssuranceVie.ws;

import java.util.List;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.service.DistributeurService;

@RestController
@RequestMapping("assurance-api/Distributeur")
public class DistributeurRest {

	
	@Autowired
	DistributeurService distributeurService;

	@GetMapping("/find/reference/{reference}")
	public Distributeur findByReference(@PathVariable String reference) {
		return distributeurService.findByReference(reference);
	}

	@GetMapping("/find/libelle/{libelle}")
	public Distributeur findByLibelle(@PathVariable String libelle) {
		return distributeurService.findByLibelle(libelle);
	}

	@PostMapping("/save")
	public int save(@RequestBody Distributeur distributeur) {
		return distributeurService.save(distributeur);
	}

	@GetMapping("/find")
	public List<Distributeur> findAll() {
		return distributeurService.findAll();
	}

	@GetMapping("/find/id/{id}")
	public Optional<Distributeur> findById(@PathVariable Long id) {
		return distributeurService.findById(id);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		distributeurService.deleteById(id);
	} 
	
}
