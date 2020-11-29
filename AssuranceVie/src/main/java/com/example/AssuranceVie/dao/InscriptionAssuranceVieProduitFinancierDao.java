package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;

import java.util.List;


@Repository
public interface InscriptionAssuranceVieProduitFinancierDao extends JpaRepository<InscriptionAssuranceVieProduitFinancier,Long>{
	List<InscriptionAssuranceVieProduitFinancier> findAllByDistributeur_Id(Long dID);
	List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(Long id);
	List<InscriptionAssuranceVieProduitFinancier> findByiAV_Reference(String ref);
	
	@Query(value="Select * from inscriptionassurancevieproduitfinancier where iav=:id", nativeQuery = true)
	List<InscriptionAssuranceVieProduitFinancier> findByiAV_Id(@Param("id")Long id);
	
	@Modifying
	//	@Query("Update InscriptionAssuranceVieProduitFinancier i set i.etatInscription = :etatInscription where i.id=:id")
	@Query(value="Update inscriptionassurancevieproduitfinancier set etat_inscription = :etat_inscription where id=:id",nativeQuery = true)
	 void updateEtat(@Param("id")Long id,@Param("etat_inscription")Long etat_inscription);
	@Modifying
	@Query(value="Delete from inscriptionassurancevieproduitfinancier where iav=:id", nativeQuery = true)
	void deleteByiAV_Id(@Param("id")Long id);
	

}
