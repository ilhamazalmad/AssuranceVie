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
		
	//public void Modify(String reference,Double prix);
	
	//@Query ("Select p.Formule from ProduitFinancier p where p.id=p.id")
	//public List<Formule> findByProduitFinancier(ProduitFinancier produitFinancier);
	
	
	
	
	
}
