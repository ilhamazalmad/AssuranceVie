package com.example.AssuranceVie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.dao.FormuleDao;

@Service
public class FormuleService {

	@Autowired
	FormuleDao formuleDao;

	public Formule findByReference(String reference) {
		return formuleDao.findByReference(reference);
	}

	public Formule findByLibelle(String libelle) {
		return formuleDao.findByLibelle(libelle);
	}

	public List<Formule> findByProduitFinancier(ProduitFinancier produitFinancier) {
		return formuleDao.findByProduitFinancier(produitFinancier);
	}
	
	public void Modify(String reference, Double prix) {
		Formule formule = findByReference(reference);
		formule.setPrix(prix);
		formuleDao.save(formule);
	}

	public int save(Formule formule) {
		if (findByReference(formule.getReference())==null && findByLibelle(formule.getLibelle())==null)
		{
			formuleDao.save(formule);
			return 1;
		}
		else
			return -1;
	}

	public List<Formule> findAll() {
		return formuleDao.findAll();
	}

	public Optional<Formule> findById(Long id) {
		return formuleDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		formuleDao.deleteById(id);
	}
	
}
