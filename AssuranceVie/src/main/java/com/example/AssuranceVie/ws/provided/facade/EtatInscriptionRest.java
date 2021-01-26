package com.example.AssuranceVie.ws.provided.facade;

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

import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.service.facade.EtatInscriptionService;
import com.example.AssuranceVie.ws.provided.converter.EtatConverter;
import com.example.AssuranceVie.ws.provided.dto.EtatInscriptionDto;

@RestController
@RequestMapping("assurance-api/Etat")
public class EtatInscriptionRest {

	@Autowired
	EtatInscriptionService etatInscriptionService;
	@Autowired
	EtatConverter etatConverter;

	@PostMapping("/save")
	public int save(@RequestBody EtatInscriptionDto etatInscription) {
		return etatInscriptionService.save(etatConverter.toBean(etatInscription));
	}

	@GetMapping("/find/{id}")
	public EtatInscriptionDto findById(@PathVariable Long id) {
		return etatConverter.toVo(etatInscriptionService.findById(id));
	}

	@GetMapping("/find")
	public List<EtatInscriptionDto> findAll() {
		return etatConverter.toVo(etatInscriptionService.findAll());
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		etatInscriptionService.deleteById(id);
	}
	@GetMapping("/find/produit/{id}")
	public EtatInscriptionDto etatOfProduit(@PathVariable Long id) {
		return etatConverter.toVo(etatInscriptionService.etatOfProduit(id));
	}
	
	
}
