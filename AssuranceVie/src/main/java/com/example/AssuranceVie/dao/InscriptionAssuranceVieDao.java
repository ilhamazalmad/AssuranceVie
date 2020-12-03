package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;


import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface InscriptionAssuranceVieDao extends CrudRepository<InscriptionAssuranceVie,Long> {
	List<InscriptionAssuranceVie> findByDateInscription(Date datins);
	InscriptionAssuranceVie findInscriptionAssuranceVieByPrix(Double price);
    List<InscriptionAssuranceVie> findByReference(String Ref);
    Optional<InscriptionAssuranceVie> findById(Long ID);


}
