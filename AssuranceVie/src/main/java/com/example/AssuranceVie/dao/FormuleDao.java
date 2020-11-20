package com.example.AssuranceVie.dao;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.ProduitFinancier;


@Repository
public interface FormuleDao extends JpaRepository<Formule,Long>{

	public Formule findByReference(String reference);
	
	public Formule findByLibelle(String libelle);
			
	@Query (value="Select * from formule f where f.produit_financier=:produitFinancier",nativeQuery = true)
	public List<Formule> findByProduitFinancier(@Param("produitFinancier") Long produitFinancier);
	
	
	
	
	
}
