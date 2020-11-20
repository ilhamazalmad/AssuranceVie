package com.example.AssuranceVie.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Formule")
public class Formule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String libelle;
	private Double prix;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produitFinancier", referencedColumnName = "id")
	private ProduitFinancier produitFinancier;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public ProduitFinancier getProduitFinancier() {
		return produitFinancier;
	}
	public void setProduitFinancier(ProduitFinancier produitFinancier) {
		this.produitFinancier = produitFinancier;
	}
	public Formule(Long id, String reference, String libelle, Double prix, ProduitFinancier produitFinancier) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.produitFinancier = produitFinancier;
	}
	public Formule() {
		super();
	}
	public Formule(String reference, String libelle, Double prix, ProduitFinancier produitFinancier) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.prix = prix;
		this.produitFinancier = produitFinancier;
	}
	
}
