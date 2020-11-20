package com.example.AssuranceVie.service;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionAssuranceVieProduitFinancierService {

	@Autowired
    InscriptionAssuranceVieProduitFinancierDao inscriptionAssuranceVieProduitFinancierDao;


   public List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByProduit_Id(id);
    }
   public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Reference(String ref){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Reference(ref);

    }
   public List<InscriptionAssuranceVieProduitFinancier> findByIAV_Id(Long id){
        return inscriptionAssuranceVieProduitFinancierDao.findByiAV_Id(id);

    }

    public int save(InscriptionAssuranceVieProduitFinancier iavpf) {

            inscriptionAssuranceVieProduitFinancierDao.save(iavpf);
            return 1;

    }

    public List<InscriptionAssuranceVieProduitFinancier> findAll() {
        return inscriptionAssuranceVieProduitFinancierDao.findAll();
    }

    public Optional<InscriptionAssuranceVieProduitFinancier> findById(Long id) {
        return inscriptionAssuranceVieProduitFinancierDao.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        inscriptionAssuranceVieProduitFinancierDao.deleteById(id);
    }



}
