package com.example.AssuranceVie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.EtatInscription;

@Repository
public interface EtatInscriptionDao extends CrudRepository<EtatInscription,Long> {

}
