package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InscriptionAssuranceVieService {

	@Autowired
	InscriptionAssuranceVieDao iAVDao;
	@Autowired
	InscriptionAssuranceVieProduitFinancierDao iAVPFDao;

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
	@Transactional(propagation = Propagation.NESTED)
	public int save(InscriptionAssuranceVie ins){
	try{
		InscriptionAssuranceVie inscription = iAVDao.save(ins);
		for(InscriptionAssuranceVieProduitFinancier iProduit : ins.getiAVPF()) {
			iProduit.setiAV(inscription);
			iAVPFDao.save(iProduit);
		}
		//iAVDao.save(ins);
		return 1;
		}
		catch (Exception e) {
			System.out.print(e);
			return -1;
		}
	}

	@Transactional
	public void update(Long id, InscriptionAssuranceVie inscriptionAssuranceVie) {
		inscriptionAssuranceVie.setId(id);
		iAVPFDao.deleteByiAV_Id(id);
		for(InscriptionAssuranceVieProduitFinancier iProduit : inscriptionAssuranceVie.getiAVPF()) {
			iProduit.setiAV(inscriptionAssuranceVie);
			iAVPFDao.save(iProduit);
		}
		save(inscriptionAssuranceVie);
}


	public Optional<InscriptionAssuranceVie> findById(Long id){
		return iAVDao.findById(id);
	}

	@Transactional
	public void deleteById(Long id) {
		iAVDao.deleteById(id);
	}



}
