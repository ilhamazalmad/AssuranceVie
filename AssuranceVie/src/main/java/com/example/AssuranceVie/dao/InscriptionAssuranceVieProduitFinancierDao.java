package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;


@Repository
public interface InscriptionAssuranceVieProduitFinancierDao extends JpaRepository<InscriptionAssuranceVieProduitFinancier,Long>{

}
