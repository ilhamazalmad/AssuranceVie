package com.example.AssuranceVie.service.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.dao.DistributeurDao;

@Service
public class DistributeurService {

	@Autowired DistributeurDao distributeurDao;
	
	
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
		return (List<Distributeur>) distributeurDao.findAll();
	}

	public Distributeur findById(Long id) {
		if(distributeurDao.findById(id).get()!=null)
		return distributeurDao.findById(id).get();
		else 
			return new Distributeur(null);
	}

	public Distributeur findByReference(String reference) {
		if(distributeurDao.findByReference(reference)!=null)
		return distributeurDao.findByReference(reference);
		else 
			return new Distributeur(null);
	}

	public Distributeur findByLibelle(String libelle) {
		if(distributeurDao.findByLibelle(libelle)!=null)
		return distributeurDao.findByLibelle(libelle);
		else 
			return new Distributeur(null);
	}
	
	@Transactional
	public void deleteById(Long id) {
		distributeurDao.deleteById(id);
	}
	
	public Distributeur login(String reference, String pwd) {
		int res=0;
		Distributeur login = null;
		if (empty(pwd) == 1 || empty(reference) == 1 || distributeurDao.findByReference(reference) == null ) {
			login = null;
		} else if (distributeurDao.findByReference(reference) != null ) {
			login= distributeurDao.findByReference(reference);
			if(!login.getPwd().equals(pwd))
				login = null;
		}
		return login;
	}
	
	public int empty(String text) {
		if(text==null || text.isEmpty()) 
			return 1;
		else return -1;
	}



}
