package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;


import java.util.Date;
import java.util.List;


@Repository
public interface InscriptionAssuranceVieDao extends CrudRepository<InscriptionAssuranceVie,Long> {
List<InscriptionAssuranceVie> findAllByDistributeur_Id(Long dID);
List<InscriptionAssuranceVie> findByDateInscription(Date datins);
InscriptionAssuranceVie findInscriptionAssuranceVieByPrix(Double price);
    List<InscriptionAssuranceVie> findByReference(String Ref);



}
