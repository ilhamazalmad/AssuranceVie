package com.example.AssuranceVie.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InscriptionAssuranceVie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	//private produit;
	private Double prix;
	private Date dateInscription;
	private Distributeur distributeur;
	private List<InscriptionAssuranceVieProduitFinancier> iAVPF;
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
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public Distributeur getDistributeur() {
		return distributeur;
	}
	public void setDistributeur(Distributeur distributeur) {
		this.distributeur = distributeur;
	}
	public List<InscriptionAssuranceVieProduitFinancier> getIAVPF() {
		return iAVPF;
	}
	public void setIAVPF(
			List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		this.iAVPF = iAVPF;
	}
	public InscriptionAssuranceVie(Long id, String reference, Double prix, Date dateInscription,
			Distributeur distributeur,List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		super();
		this.id = id;
		this.reference = reference;
		this.prix = prix;
		this.dateInscription = dateInscription;
		this.distributeur = distributeur;
		this.iAVPF = iAVPF;
	}
	public InscriptionAssuranceVie() {
		super();
	}
	public InscriptionAssuranceVie(String reference, Double prix, Date dateInscription,
			Distributeur distributeur,
			List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		super();
		this.reference = reference;
		this.prix = prix;
		this.dateInscription = dateInscription;
		this.distributeur = distributeur;
		this.iAVPF = iAVPF;
	}
	
	
}
