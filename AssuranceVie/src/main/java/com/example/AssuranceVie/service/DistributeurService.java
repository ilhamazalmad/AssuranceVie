package com.example.AssuranceVie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.dao.DistributeurDao;

@Service
public class DistributeurService {

	@Autowired DistributeurDao distributeurDao;
	
	public Distributeur findByReference(String reference) {
		return distributeurDao.findByReference(reference);
	}

	public Distributeur findByLibelle(String libelle) {
		return distributeurDao.findByLibelle(libelle);
	}
	
	public int save(Distributeur distributeur) {
		if (findByReference(distributeur.getReference())==null && findByLibelle(distributeur.getLibelle())==null)
		{
			distributeurDao.save(distributeur);
			return 1;
		}
		else
			return -1;
	}
	

	public List<Distributeur> findAll() {
		return distributeurDao.findAll();
	}

	public Optional<Distributeur> findById(Long id) {
		return distributeurDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		distributeurDao.deleteById(id);
	}
	
	
}
