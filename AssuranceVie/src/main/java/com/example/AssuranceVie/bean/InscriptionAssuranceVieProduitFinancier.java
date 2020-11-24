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

import javax.persistence.*;

@Entity
@Table(name="inscriptionassurancevieproduitfinancier")
public class InscriptionAssuranceVieProduitFinancier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="iav", nullable=false)
	private InscriptionAssuranceVie iAV;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produit", referencedColumnName = "id")
	private ProduitFinancier produit ;
	private String policeAssurance;
	@ManyToOne
	private Distributeur distributeur;
	private Double prix;
	@ManyToOne
	private Formule formule;
	@ManyToOne
	private EtatInscription etatInscription;
	

	
	public EtatInscription getEtatInscription() {
		return etatInscription;
	}
	public void setEtatInscription(EtatInscription etatInscription) {
		this.etatInscription = etatInscription;
	}
	public Formule getFormule() {
		return formule;
	}
	public void setFormule(Formule formule) {
		this.formule = formule;
	}
	public InscriptionAssuranceVie getiAV() {
		return iAV;
	}
	public void setiAV(InscriptionAssuranceVie iAV) {
		this.iAV = iAV;
	}
	public String getPoliceAssurance() {
		return policeAssurance;
	}
	public void setPoliceAssurance(String policeAssurance) {
		this.policeAssurance = policeAssurance;
	}
	public Distributeur getDistributeur() {
		return distributeur;
	}
	public void setDistributeur(Distributeur distributeur) {
		this.distributeur = distributeur;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public void setProduit(ProduitFinancier produit) {
		this.produit = produit;
	}
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
