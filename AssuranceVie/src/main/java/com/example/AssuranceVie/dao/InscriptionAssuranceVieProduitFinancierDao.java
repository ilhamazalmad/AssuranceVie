package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;

import java.util.List;


@Repository
public interface InscriptionAssuranceVieProduitFinancierDao extends JpaRepository<InscriptionAssuranceVieProduitFinancier,Long>{
List<InscriptionAssuranceVieProduitFinancier> findAllByDistributeur_Id(Long dID);
List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(Long id);
List<InscriptionAssuranceVieProduitFinancier> findByiAV_Reference(String ref);
    List<InscriptionAssuranceVieProduitFinancier> findByiAV_Id(Long id);


}
