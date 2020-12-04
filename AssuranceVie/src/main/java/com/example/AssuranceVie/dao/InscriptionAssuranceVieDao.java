package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface InscriptionAssuranceVieDao extends JpaRepository<InscriptionAssuranceVie,Long> {
	
	
	List<InscriptionAssuranceVie> findByDateInscription(Date datins);
	InscriptionAssuranceVie findInscriptionAssuranceVieByPrix(Double price);
    List<InscriptionAssuranceVie> findByReference(String Ref);
    Optional<InscriptionAssuranceVie> findById(Long ID);


	@Query(value="Select sum(p.prix) from inscriptionassurancevieproduitfinancier p where p.iav=:id", nativeQuery = true)
	public Double total(@Param("id")Long id) ;
	@Query(value="Select sum(p.prix) from inscriptionassurancevieproduitfinancier p where p.iav=:id and etat_inscription=3", nativeQuery = true)
	public Double totalConfirme(@Param("id")Long id) ;
	@Query(value="Select sum(p.prix) from inscriptionassurancevieproduitfinancier p where p.iav=:id and etat_inscription != 2", nativeQuery = true)
	public Double totalAttente(@Param("id")Long id) ;

}
