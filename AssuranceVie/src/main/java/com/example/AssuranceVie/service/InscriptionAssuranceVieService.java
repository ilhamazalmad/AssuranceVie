package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;

import java.util.List;

@Service
public class InscriptionAssuranceVieService {

	@Autowired
	InscriptionAssuranceVieDao iAVDao;
	public List<InscriptionAssuranceVie> findAllByDistributeur(int id){
		return iAVDao.findAllByDistributeur(id);
	}
}
