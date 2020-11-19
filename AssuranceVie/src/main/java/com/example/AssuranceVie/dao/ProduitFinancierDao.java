package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.ProduitFinancier;


@Repository
public interface ProduitFinancierDao extends JpaRepository<ProduitFinancier,Long>{

}
