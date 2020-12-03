package com.example.AssuranceVie.ws;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.service.EtatInscriptionService;

@RestController
@RequestMapping("assurance-api/Etat")
public class EtatInscriptionRest {

	@Autowired
	EtatInscriptionService etatInscriptionService;

	@PostMapping("/save")
	public EtatInscription save(@RequestBody EtatInscription etatInscription) {
		return etatInscriptionService.save(etatInscription);
	}

	@GetMapping("/find/{id}")
	public Optional<EtatInscription> findById(@PathVariable Long id) {
		return etatInscriptionService.findById(id);
	}

	@GetMapping("/find")
	public Iterable<EtatInscription> findAll() {
		return etatInscriptionService.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		etatInscriptionService.deleteById(id);
	}
	@GetMapping("/find/produit/{id}")
	public EtatInscription etatOfProduit(@PathVariable Long id) {
		return etatInscriptionService.etatOfProduit(id);
	}
	
	
}
