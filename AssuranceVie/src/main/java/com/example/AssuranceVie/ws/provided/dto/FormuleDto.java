package com.example.AssuranceVie.ws.provided.dto;


import javax.persistence.CascadeType;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class FormuleDto {

	private String id;
	private String reference;
	private String libelle;
	private String prix;

	private ProduitFinancierDto produitFinancier;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public ProduitFinancierDto getProduitFinancier() {
		return produitFinancier;
	}
	public void setProduitFinancier(ProduitFinancierDto produitFinancier) {
		this.produitFinancier = produitFinancier;
	}
	public FormuleDto(String id, String reference, String libelle, String prix, ProduitFinancierDto produitFinancier) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.produitFinancier = produitFinancier;
	}
	public FormuleDto() {
		super();
	}
	public FormuleDto(String reference, String libelle, String prix, ProduitFinancierDto produitFinancier) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.produitFinancier = produitFinancier;
	}
	
}
