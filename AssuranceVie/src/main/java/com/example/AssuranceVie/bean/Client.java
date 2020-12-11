package com.example.AssuranceVie.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private Long telephone;
	private String cin;
	private Date dateNaissance;
	private String copieCin;
	@OneToMany(mappedBy="client",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<InscriptionAssuranceVie> iAV;
 
	
	public Client(Long id, String nom, String prenom, String adresse, Long telephone, String cin, Date dateNaissance,
			String copieCin, List<InscriptionAssuranceVie> iAV) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.copieCin = copieCin;
		this.iAV = iAV;
	}
	public Client( String nom, String prenom, String adresse, Long telephone, String cin, Date dateNaissance,
				  String copieCin, List<InscriptionAssuranceVie> iAV) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.copieCin = copieCin;
		this.iAV = iAV;
	}
	public Client() {
		super();
	}

	public Client(Long i) {
		this.id = i;
	}

	public Client(String cin, Long tel) {
		this.cin=cin;
		this.telephone=tel;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCopieCin() {
		return copieCin;
	}
	public void setCopieCin(String copieCin) {
		this.copieCin = copieCin;
	}
	public List<InscriptionAssuranceVie> getiAV() {
		return iAV;
	}
	public void setiAV(List<InscriptionAssuranceVie> iAV) {
		this.iAV = iAV;
	}
	
	
	
}
