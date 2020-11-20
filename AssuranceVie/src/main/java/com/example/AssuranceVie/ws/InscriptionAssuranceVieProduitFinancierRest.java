package com.example.AssuranceVie.ws;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.service.InscriptionAssuranceVieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssuranceVie.service.InscriptionAssuranceVieProduitFinancierService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("assurance-api/IAVPF")
public class InscriptionAssuranceVieProduitFinancierRest {


    InscriptionAssuranceVieProduitFinancierService inscriptionAssuranceVieProduitFinancierService;

}
