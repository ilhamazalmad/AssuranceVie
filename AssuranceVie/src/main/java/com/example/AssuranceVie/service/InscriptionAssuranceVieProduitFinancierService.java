package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;

import java.util.List;

@Service
public class InscriptionAssuranceVieProduitFinancierService {

	@Autowired
	InscriptionAssuranceVieProduitFinancierDao  iAVPFDao;

	public List<InscriptionAssuranceVieProduitFinancier> findAll() {
		return iAVPFDao.findAll();	}
}
