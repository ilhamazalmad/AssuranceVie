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

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.service.ClientService;

@RestController
@RequestMapping("assurance-api/Client")
public class ClientRest {

	@Autowired
	ClientService clientService;

	@PostMapping("/save")
	public int  save(@RequestBody Client client) {
		return clientService.save(client);
	}

	@GetMapping("/find/cin/{cin}")
	public Client findByCin(@PathVariable String cin) {
		return clientService.findByCin(cin);
	}

	@GetMapping("/find/telephone/{telephone}")
	public Client findByTelephone(@PathVariable Long telephone) {
		return clientService.findByTelephone(telephone);
	}


	@GetMapping("/find")
	public Iterable<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping("/find/{id}")
	public Optional<Client> findById(@PathVariable Long id) {
		return clientService.findById(id);
	}

	@DeleteMapping("/find//{id}")
	public void deleteById(@PathVariable Long id) {
		clientService.deleteById(id);
	}
	
}
