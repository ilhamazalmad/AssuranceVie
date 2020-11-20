package com.example.AssuranceVie.ws;

import com.example.AssuranceVie.service.InscriptionAssuranceVieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("assurance-api/IAV")
public class InscriptionAssuranceVieRest {

	@Autowired
	InscriptionAssuranceVieService iAVService;
	@GetMapping("/distID")
	List<InscriptionAssuranceVie> findAllByDistributeur(@PathParam("distID") int id){
		return iAVService.findAllByDistributeur(id);
	}
}
