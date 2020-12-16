package com.example.AssuranceVie.dto;

import java.util.List;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;

public class Inscription {

	InscriptionAssuranceVie assurance;
	private List<InscriptionAssuranceVieProduitFinancier> produits;
	public Inscription(InscriptionAssuranceVie assurance, List<InscriptionAssuranceVieProduitFinancier> produits) {
		super();
		this.assurance = assurance;
		this.produits = produits;
	}
	public Inscription() {
		super();
	}
	public InscriptionAssuranceVie getAssurance() {
		return assurance;
	}
	public void setAssurance(InscriptionAssuranceVie assurance) {
		this.assurance = assurance;
	}
	public List<InscriptionAssuranceVieProduitFinancier> getProduits() {
		return produits;
	}
	public void setProduits(List<InscriptionAssuranceVieProduitFinancier> produits) {
		this.produits = produits;
	}
	
	
	
}
