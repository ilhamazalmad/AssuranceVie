package com.example.AssuranceVie.ws.provided.facade;

import java.util.List;
import java.util.Optional;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.service.facade.ClientService;
import com.example.AssuranceVie.ws.provided.converter.ClientConverter;
import com.example.AssuranceVie.ws.provided.dto.ClientDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.AssuranceVie.bean.Client;

@RestController
@RequestMapping("assurance-api/Client")
@CrossOrigin(origins="http://localhost:4200")
public class ClientRest {

	@Autowired
	ClientService clientService;
	@Autowired
	ClientConverter clientConverter;

	@PostMapping("/register")
	public ClientDto  save(@RequestBody ClientDto client) {
		clientConverter.setiAV(false);
		return clientConverter.toVo(clientService.save(clientConverter.toBean(client)));
	}

	@GetMapping("/find/cin/{cin}")
	public ClientDto findByCin(@PathVariable String cin) {
		return clientConverter.toVo(clientService.findByCin(cin));
	}

	@GetMapping("/find/telephone/{telephone}")
	public ClientDto findByTelephone(@PathVariable Long telephone) {
		return clientConverter.toVo(clientService.findByTelephone(telephone));
	}


	@GetMapping("/find")
	public List<ClientDto> findAll() {
		return clientConverter.toVo(clientService.findAll());
	}

	@GetMapping("/find/{id}")
	public ClientDto findById(@PathVariable Long id) {
		return clientConverter.toVo(clientService.findById(id));
	}
	/*@GetMapping("/login")
	public Client loginclient(@RequestBody UserLogin userLogin) {
		return clientService.loginorregister(new Client(userLogin.getUser(),userLogin.getPwd()));
	}*/
	@GetMapping("/login/cin/{cin}/pwd/{pwd}")
	public ClientDto login(@PathVariable String cin ,@PathVariable String pwd) {
		return clientConverter.toVo(clientService.loginorregister(cin ,pwd));
	}

	@DeleteMapping("/find//{id}")
	public void deleteById(@PathVariable Long id) {
		clientService.deleteById(id);
	}

}
