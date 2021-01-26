package com.example.AssuranceVie.ws.provided.dto;

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

public class InscriptionAssuranceVieProduitFinancierDto {

	private String id;
	private InscriptionAssuranceVieDto iAV;
	private ProduitFinancierDto produit ;
	private String policeAssurance;
	private DistributeurDto distributeur;
	private String prix;
	private FormuleDto formule;
	private EtatInscriptionDto etatInscription;
	
	
	public InscriptionAssuranceVieProduitFinancierDto(String id, InscriptionAssuranceVieDto iAV, ProduitFinancierDto produit,
			String policeAssurance, DistributeurDto distributeur, String prix, FormuleDto formule,
			EtatInscriptionDto etatInscription) {
		super();
		this.id = id;
		this.iAV = iAV;
		this.produit = produit;
		this.policeAssurance = policeAssurance;
		this.distributeur = distributeur;
		this.prix = prix;
		this.formule = formule;
		this.etatInscription = etatInscription;
	}
	public EtatInscriptionDto getEtatInscription() {
		return etatInscription;
	}
	public void setEtatInscription(EtatInscriptionDto etatInscription) {
		this.etatInscription = etatInscription;
	}
	public FormuleDto getFormule() {
		return formule;
	}
	public void setFormule(FormuleDto formule) {
		this.formule = formule;
	}
	public InscriptionAssuranceVieDto getiAV() {
		return iAV;
	}
	public void setiAV(InscriptionAssuranceVieDto iAV) {
		this.iAV = iAV;
	}
	public String getPoliceAssurance() {
		return policeAssurance;
	}
	public void setPoliceAssurance(String policeAssurance) {
		this.policeAssurance = policeAssurance;
	}
	public DistributeurDto getDistributeur() {
		return distributeur;
	}
	public void setDistributeur(DistributeurDto distributeur) {
		this.distributeur = distributeur;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public void setProduit(ProduitFinancierDto produit) {
		this.produit = produit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public InscriptionAssuranceVieDto getIAV() {
		return iAV;
	}
	public void setIAV(InscriptionAssuranceVieDto iAV) {
		this.iAV = iAV;
	}
	public ProduitFinancierDto getProduit() {
		return produit;
	}
	public void setProduitFinancier(ProduitFinancierDto produit) {
		this.produit = produit;
	}
	
	
	public InscriptionAssuranceVieProduitFinancierDto(String id, InscriptionAssuranceVieDto iAV,
			ProduitFinancierDto produit) {
		super();
		this.id = id;
		this.iAV = iAV;
		this.produit = produit;
	}
	public InscriptionAssuranceVieProduitFinancierDto(InscriptionAssuranceVieDto iAV,
			ProduitFinancierDto produit) {
		super();
		this.iAV = iAV;
		this.produit = produit;
	}
	public InscriptionAssuranceVieProduitFinancierDto() {
		super();
	}
	
	
}
