package com.example.AssuranceVie.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.dao.EtatInscriptionDao;

@Service
public class EtatInscriptionService {

	@Autowired
		EtatInscriptionDao etatInscriptionDao;

	public EtatInscription save(EtatInscription etatInscription) {
		return etatInscriptionDao.save(etatInscription);
	}

	public Optional<EtatInscription> findById(Long id) {
		return etatInscriptionDao.findById(id);
	}

	public Iterable<EtatInscription> findAll() {
		return etatInscriptionDao.findAll();
	}

	@Transactional
	public void deleteById(Long id) {
		etatInscriptionDao.deleteById(id);
	}
	
}
