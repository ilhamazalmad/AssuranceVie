package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InscriptionAssuranceVieService {

	@Autowired
	InscriptionAssuranceVieDao iAVDao;
	
public List<InscriptionAssuranceVie> findByDateInscription(Date Dins){
		return iAVDao.findByDateInscription(Dins);

}
   public  List<InscriptionAssuranceVie> findByReference(String ref){
		return iAVDao.findByReference(ref);
	 }
	public  InscriptionAssuranceVie findByPrix(Double pr){
		return iAVDao.findInscriptionAssuranceVieByPrix(pr);
	 }
	public  List<InscriptionAssuranceVie> findAll(){
		return (List<InscriptionAssuranceVie>) iAVDao.findAll();
}
	public int save(InscriptionAssuranceVie ins){
	try{
		iAVDao.save(ins);
		return 1;
	}
	catch (Exception e) {
		return -1;

	}
}

	public Optional<InscriptionAssuranceVie> findById(Long id) {
		return iAVDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		iAVDao.deleteById(id);
	}



}
