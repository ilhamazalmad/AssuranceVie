package com.example.AssuranceVie.service.facade;

import java.util.List;
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

	public int save(EtatInscription etatInscription) {
		if (findByReference(etatInscription.getReference())==null && findByLibelle(etatInscription.getLibelle())==null)
		{
			etatInscriptionDao.save(etatInscription);
			return 1;
		}
		else
			return -1;
	}
	
	
	
	public EtatInscription findByReference(String reference) {
		return etatInscriptionDao.findByReference(reference);
	}



	public EtatInscription findByLibelle(String libelle) {
		return etatInscriptionDao.findByLibelle(libelle);
	}



	public EtatInscription findById(Long id) {
		return etatInscriptionDao.findById(id).get();
	}

	public List<EtatInscription> findAll() {
		return etatInscriptionDao.findAll();
	}

	
	public EtatInscription etatOfProduit(Long id) {
		return etatInscriptionDao.etatOfProduit(id);
		
	}

	@Transactional
	public void deleteById(Long id) {
		etatInscriptionDao.deleteById(id);
	}
	
}
