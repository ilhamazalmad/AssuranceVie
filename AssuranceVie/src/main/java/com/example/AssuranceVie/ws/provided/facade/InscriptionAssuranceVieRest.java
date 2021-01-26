package com.example.AssuranceVie.ws.provided.facade;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.service.facade.InscriptionAssuranceVieService;
import com.example.AssuranceVie.ws.provided.converter.IAVConverter;
import com.example.AssuranceVie.ws.provided.converter.IAVPFConverter;
import com.example.AssuranceVie.ws.provided.dto.InscriptionAssuranceVieDto;
import com.example.AssuranceVie.ws.provided.dto.InscriptionAssuranceVieProduitFinancierDto;
import com.example.AssuranceVie.ws.provided.dto.InscriptionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("assurance-api/IAV")
public class InscriptionAssuranceVieRest {

	@Autowired
	InscriptionAssuranceVieService iAVService;
	@Autowired
	IAVConverter iAVConverter;
	@Autowired
    IAVPFConverter iAVPFConverter;
	
	@GetMapping("find/reference/{reference}")
	List<InscriptionAssuranceVieDto> findAllByReference(@PathVariable  String  reference){
		return iAVConverter.toVo(iAVService.findByReference(reference));
	}
	@GetMapping("find/price/{price}")
	InscriptionAssuranceVieDto findAllByPrix(@PathVariable double price){
		return iAVConverter.toVo(iAVService.findByPrix(price));
	}
	@GetMapping("find/all")
	List<InscriptionAssuranceVieDto> findAll(){
		return iAVConverter.toVo(iAVService.findAll());
	}
	@PostMapping("/save")
	public int save(@RequestBody InscriptionAssuranceVieDto insav) throws Exception{
		return iAVService.save(iAVConverter.toBean(insav));
	}

	@GetMapping("/find/id/{id}")
	public InscriptionAssuranceVieDto findById(@PathVariable Long id) {
		return iAVConverter.toVo(iAVService.findById(id));
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		iAVService.deleteById(id);
	}
	@PutMapping("update/{id}")
	public int update(@PathVariable Long id,@RequestBody  List<InscriptionAssuranceVieProduitFinancierDto> produits) {
		return iAVService.update(id, iAVPFConverter.toBean(produits));
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
