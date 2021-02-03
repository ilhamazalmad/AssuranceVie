package com.example.AssuranceVie.ws.provided.facade;

import java.util.List;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.service.facade.DistributeurService;
import com.example.AssuranceVie.ws.provided.converter.DistributeurConverter;
import com.example.AssuranceVie.ws.provided.dto.ClientDto;
import com.example.AssuranceVie.ws.provided.dto.DistributeurDto;

@RestController
@RequestMapping("assurance-api/Distributeur")
@CrossOrigin(origins="http://localhost:4200")

public class DistributeurRest {

	
	@Autowired
	DistributeurService distributeurService;
	@Autowired
	DistributeurConverter distributeurConverter;

	@GetMapping("/find/reference/{reference}")
	public DistributeurDto findByReference(@PathVariable String reference) {
		return distributeurConverter.toVo(distributeurService.findByReference(reference));
	}

	@GetMapping("/find/libelle/{libelle}")
	public DistributeurDto findByLibelle(@PathVariable String libelle) {
		return distributeurConverter.toVo(distributeurService.findByLibelle(libelle));
	}

	@PostMapping("/save")
	public int save(@RequestBody DistributeurDto distributeur) {
		distributeurConverter.setiAVPF(false);
		return distributeurService.save(distributeurConverter.toBean(distributeur));
		
	}

	@GetMapping("/find")
	public List<DistributeurDto> findAll() {
		distributeurConverter.setiAVPF(false);
		return distributeurConverter.toVo(distributeurService.findAll());
	}

	@GetMapping("/find/id/{id}")
	public DistributeurDto findById(@PathVariable Long id) {
		return distributeurConverter.toVo(distributeurService.findById(id));
	}
	@GetMapping("/login/reference/{reference}/pwd/{pwd}")
	public DistributeurDto login(@PathVariable String reference ,@PathVariable String pwd) {
		return distributeurConverter.toVo(distributeurService.login(reference ,pwd));
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Long id) {
		distributeurService.deleteById(id);
	} 
	
}
