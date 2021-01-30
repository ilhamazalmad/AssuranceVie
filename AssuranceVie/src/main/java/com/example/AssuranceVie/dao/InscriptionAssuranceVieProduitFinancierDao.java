package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;

import java.util.List;


@Repository
public interface InscriptionAssuranceVieProduitFinancierDao extends JpaRepository<InscriptionAssuranceVieProduitFinancier,Long>{
	List<InscriptionAssuranceVieProduitFinancier> findByProduit_Id(Long id);
	List<InscriptionAssuranceVieProduitFinancier> findByiAV_Reference(String ref);
	public List<InscriptionAssuranceVieProduitFinancier> findAllByDistributeur_Id(Long id);

	
	@Modifying
	//	@Query("Update InscriptionAssuranceVieProduitFinancier i set i.etatInscription = :etatInscription where i.id=:id")
	@Query(value="Update inscriptionassurancevieproduitfinancier set etat_inscription = :etat_inscription where id=:id",nativeQuery = true)
	 void updateEtat(@Param("id")Long id,@Param("etat_inscription")Long etat_inscription);
	@Modifying
	@Query(value="Delete from inscriptionassurancevieproduitfinancier where iav=:id", nativeQuery = true)
	void deleteByiAV_Id(@Param("id")Long id);
	
	@Query(value="Select i.* from inscriptionassurancevieproduitfinancier i "
			+ "where i.etat_inscription=2 or (i.etat_inscription=3 and  i.distributeur=:id)", nativeQuery = true)
	public List<InscriptionAssuranceVieProduitFinancier> findAllForDistributeur(@Param("id") Long id);
	
	@Modifying
	@Query(value="Update inscriptionassurancevieproduitfinancier "
			+ "set dist_id =:dist_id , etat_inscription=3	where id=:id",nativeQuery = true)
	public void affilier(@Param("id")Long id,@Param("dist_id") Long dist_id);

	@Query(value="Select * from inscriptionassurancevieproduitfinancier where iav=:id", nativeQuery = true)
	List<InscriptionAssuranceVieProduitFinancier> findByiAV_Id(@Param("id")Long id);
	
	@Query(value="Select * from inscriptionassurancevieproduitfinancier where etat_inscription=:id", nativeQuery = true)
	List<InscriptionAssuranceVieProduitFinancier> findByEtatInscription(@Param("id")Long id);
	
}
