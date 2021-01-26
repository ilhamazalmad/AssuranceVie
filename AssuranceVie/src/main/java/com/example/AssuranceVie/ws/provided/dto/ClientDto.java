package com.example.AssuranceVie.ws.provided.dto;

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

public class ClientDto {
	
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String cin;
	private String dateNaissance;
	private String copieCin;
	private String pwd;
	
	private List<InscriptionAssuranceVieDto> iAV;
 

	
	public ClientDto(String id, String nom, String prenom, String adresse, String telephone, String cin, String dateNaissance,
			String copieCin, String pwd, List<InscriptionAssuranceVieDto> iAV) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.copieCin = copieCin;
		this.pwd = pwd;
		this.iAV = iAV;
	}
	
	public ClientDto(String nom, String prenom, String adresse, String telephone, String cin, String dateNaissance,
			String copieCin, String pwd, List<InscriptionAssuranceVieDto> iAV) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.copieCin = copieCin;
		this.pwd = pwd;
		this.iAV = iAV;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public ClientDto() {
		super();
	}

	public ClientDto(String id) {
		this.id = id;
	}

	public ClientDto(String cin, String pwd) {
		this.cin=cin;
		this.pwd=pwd;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCopieCin() {
		return copieCin;
	}
	public void setCopieCin(String copieCin) {
		this.copieCin = copieCin;
	}
	public List<InscriptionAssuranceVieDto> getiAV() {
		return iAV;
	}
	public void setiAV(List<InscriptionAssuranceVieDto> iAV) {
		this.iAV = iAV;
	}
	
	
	
}
