package com.example.AssuranceVie.service.facade;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.dao.EtatInscriptionDao;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;
import com.example.AssuranceVie.ws.provided.dto.IAVPFsimpl;
import com.example.AssuranceVie.ws.provided.dto.SummaryPOJO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@Service
public class InscriptionAssuranceVieProduitFinancierService {

    @Autowired
    InscriptionAssuranceVieProduitFinancierDao inscriptionAssuranceVieProduitFinancierDao;
	@Autowired
	EtatInscriptionDao etatInscriptionDao;
    @Autowired
    InscriptionAssuranceVieDao inscriptionAssuranceVieDao;

	public int save(InscriptionAssuranceVieProduitFinancier iavpf) {

        inscriptionAssuranceVieProduitFinancierDao.save(iavpf);
        return 1;
	}

    public List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(Long id) {
        return inscriptionAssuranceVieProduitFinancierDao.findByProduit_Id(id);
    }
   public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Reference(String ref){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Reference(ref);

    }

    public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Id(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Id(id);

    }

    public List<InscriptionAssuranceVieProduitFinancier> findByEtatInscription(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByEtatInscription(id);

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

    public InscriptionAssuranceVieProduitFinancier findById(Long id) {
        return inscriptionAssuranceVieProduitFinancierDao.findById(id).get();
    }



    @Transactional
    public void affilier(Long id, Long dist_id) {
		 inscriptionAssuranceVieProduitFinancierDao.affilier(id, dist_id);
	}

	public List<InscriptionAssuranceVieProduitFinancier> findAllForDistributeur(Long id) {
		return inscriptionAssuranceVieProduitFinancierDao.findAllForDistributeur(id);
	}

	@Transactional(propagation = Propagation.NESTED)
    public int deleteById(Long id) {
        if(etatInscriptionDao.etatOfProduit(id).getId()!=3) {
        	inscriptionAssuranceVieProduitFinancierDao.deleteById(id);
        	return 1;
        }
        else return -1;
    }

	public List<InscriptionAssuranceVieProduitFinancier> findByClient(Long id) {
		return inscriptionAssuranceVieProduitFinancierDao.findByClient(id);
	}
	
	
	
	



}
