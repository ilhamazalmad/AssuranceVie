package com.example.AssuranceVie.ws;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.service.InscriptionAssuranceVieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("assurance-api/IAV")
public class InscriptionAssuranceVieRest {

	@Autowired
	InscriptionAssuranceVieService iAVService;
	
	@GetMapping("find/reference/{reference}")
	List<InscriptionAssuranceVie> findAllByReference(@PathVariable  String  reference){
		return iAVService.findByReference(reference);
	}
	@GetMapping("find/price/{price}")
	InscriptionAssuranceVie findAllByPrix(@PathVariable double price){
		return iAVService.findByPrix(price);
	}
	@GetMapping("find/all")
	List<InscriptionAssuranceVie> findAll(){
		return iAVService.findAll();
	}
	@PostMapping("/save")
	public int save(@RequestBody InscriptionAssuranceVie insav) {
		return iAVService.save(insav);
	}

	@GetMapping("/find/id/{id}")
	public Optional<InscriptionAssuranceVie> findById(@PathVariable Long id) {
		return iAVService.findById(id);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		iAVService.deleteById(id);
	}
	@PutMapping("update/{id}")
	public void update(@PathVariable Long id,@RequestBody InscriptionAssuranceVie inscriptionAssuranceVie) {
		iAVService.update(id, inscriptionAssuranceVie);
	}
	@GetMapping("/total/{id}")
	public Double total(@PathVariable Long id) {
		return iAVService.total(id);
	}
	@GetMapping("/totalConfirme/{id}")
	public Double totalConfirme(@PathVariable Long id) {
		return iAVService.totalConfirme(id);
	}
	@GetMapping("/totalAttente/{id}")
	public Double totalAttente(@PathVariable Long id) {
		return iAVService.totalAttente(id);
	}
	
	
	


}
