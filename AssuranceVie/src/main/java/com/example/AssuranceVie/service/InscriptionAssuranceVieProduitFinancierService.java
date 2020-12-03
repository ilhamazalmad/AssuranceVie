package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.dao.EtatInscriptionDao;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionAssuranceVieProduitFinancierService {

	@Autowired
    InscriptionAssuranceVieProduitFinancierDao inscriptionAssuranceVieProduitFinancierDao;
	@Autowired
	EtatInscriptionDao etatInscriptionDao;

	public int save(InscriptionAssuranceVieProduitFinancier iavpf) {

        inscriptionAssuranceVieProduitFinancierDao.save(iavpf);
        return 1;
	}

   public List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByProduit_Id(id);
    }
   public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Reference(String ref){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Reference(ref);

    }
   public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Id(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Id(id);

    }
   
   @Transactional
    public void updateEtat(Long id, Long etat) {
	inscriptionAssuranceVieProduitFinancierDao.updateEtat(id, etat);
}
   @Transactional(propagation = Propagation.NESTED)
	public void deleteByiAV_Id(Long id) {
	 inscriptionAssuranceVieProduitFinancierDao.deleteByiAV_Id(id);
}
	public List<InscriptionAssuranceVieProduitFinancier> findAllByDistributeur_Id(Long dID) {
	return inscriptionAssuranceVieProduitFinancierDao.findAllByDistributeur_Id(dID);
}
	
    public List<InscriptionAssuranceVieProduitFinancier> findAll() {
        return inscriptionAssuranceVieProduitFinancierDao.findAll();
    }

    public Optional<InscriptionAssuranceVieProduitFinancier> findById(Long id) {
        return inscriptionAssuranceVieProduitFinancierDao.findById(id);
    }
    
    

    @Transactional
    public void affilier(Long id, Long dist_id) {
		 inscriptionAssuranceVieProduitFinancierDao.affilier(id, dist_id);
	}

	public List<InscriptionAssuranceVieProduitFinancier> findAllForDistributeur(Long id) {
		return inscriptionAssuranceVieProduitFinancierDao.findAllForDistributeur(id);
	}

	@Transactional
    public int deleteById(Long id) {
        if(etatInscriptionDao.etatOfProduit(id).getId()!=3) {
        	inscriptionAssuranceVieProduitFinancierDao.deleteById(id);
        	return 1;
        }
        else return -1;
    }



}
