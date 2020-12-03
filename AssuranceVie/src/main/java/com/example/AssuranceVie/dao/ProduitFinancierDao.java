package com.example.AssuranceVie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.ProduitFinancier;


@Repository
public interface ProduitFinancierDao extends JpaRepository<ProduitFinancier,Long>{

	public ProduitFinancier findByLibelle(String libelle);
	public ProduitFinancier findByCode(String code);

}
