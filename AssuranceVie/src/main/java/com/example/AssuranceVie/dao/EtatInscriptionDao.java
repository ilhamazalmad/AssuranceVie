package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.EtatInscription;

@Repository
public interface EtatInscriptionDao extends JpaRepository<EtatInscription,Long> {

	@Query(value="Select e.* from inscriptionassurancevieproduitfinancier i,etat_inscription e "
			+ "where i.id=:id and i.etat_inscription=e.id", nativeQuery = true)
	public EtatInscription etatOfProduit(@Param("id") Long id);
	public EtatInscription findByReference(String reference);
	public EtatInscription findByLibelle(String libelle);
}
