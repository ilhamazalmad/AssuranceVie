package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;

import java.util.List;


@Repository
public interface InscriptionAssuranceVieDao extends JpaRepository<InscriptionAssuranceVie,Long>{
List<InscriptionAssuranceVie> findAllByDistributeur(int dID);
}
