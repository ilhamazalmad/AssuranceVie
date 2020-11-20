package com.example.AssuranceVie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.dao.ProduitFinancierDao;

@Service
public class ProduitFinancierService {

	@Autowired
	ProduitFinancierDao produitFinancierDao;

	public ProduitFinancier findByLibelle(String libelle) {
		return produitFinancierDao.findByLibelle(libelle);
	}

	public ProduitFinancier findByCode(String code) {
		return produitFinancierDao.findByCode(code);
	}

	public void addFormule(Long idProd, Formule formule) {
		Optional<ProduitFinancier> produit = findById(idProd);
		List<Formule> formules = produit.get().getFormules();
		formules.add(formule);
		produit.get().setFormules(formules);
		produitFinancierDao.save(produit.get());
	}

	public int save(ProduitFinancier produitFinancier) {
		if (findByCode(produitFinancier.getCode())==null && findByLibelle(produitFinancier.getLibelle())==null)
		{
			produitFinancierDao.save(produitFinancier);
			return 1;
		}
		else
			return -1;
	}

	public List<ProduitFinancier> findAll() {
		return produitFinancierDao.findAll();
	}

	public Optional<ProduitFinancier> findById(Long id) {
		return produitFinancierDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {		
		produitFinancierDao.deleteById(id);
	}
	
}
