package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.EtatInscription;

@Repository
public interface EtatInscriptionDao extends JpaRepository<EtatInscription,Long> {

}
