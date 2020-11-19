package com.example.AssuranceVie.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InscriptionAssuranceVieProduitFinancier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private InscriptionAssuranceVie iAV;
	private ProduitFinancier produit ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InscriptionAssuranceVie getIAV() {
		return iAV;
	}
	public void setIAV(InscriptionAssuranceVie iAV) {
		this.iAV = iAV;
	}
	public ProduitFinancier getProduit() {
		return produit;
	}
	public void setProduitFinancier(ProduitFinancier produit) {
		this.produit = produit;
	}
	public InscriptionAssuranceVieProduitFinancier(Long id, InscriptionAssuranceVie iAV,
			ProduitFinancier produit) {
		super();
		this.id = id;
		this.iAV = iAV;
		this.produit = produit;
	}
	public InscriptionAssuranceVieProduitFinancier(InscriptionAssuranceVie iAV,
			ProduitFinancier produit) {
		super();
		this.iAV = iAV;
		this.produit = produit;
	}
	public InscriptionAssuranceVieProduitFinancier() {
		super();
	}
	
	
}
