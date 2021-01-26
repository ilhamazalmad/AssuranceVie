package com.example.AssuranceVie.ws.provided.dto;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class InscriptionAssuranceVieDto {
	private String id;
	private String reference;
	private ClientDto client;
	private String prix;
	private String dateInscription;
	private List<InscriptionAssuranceVieProduitFinancierDto> iAVPF;

    public InscriptionAssuranceVieDto(String ref3, String v, String s) {
    	this.reference=ref3;
    	this.prix=v;

    	this.dateInscription=s;
    }

	public InscriptionAssuranceVieDto(String id) {
    	this.id=id;
	}

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
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	public ClientDto getClient() {
		return client;
	}
	public void setClient(ClientDto client) {
		this.client = client;
	}
	public List<InscriptionAssuranceVieProduitFinancierDto> getiAVPF() {
		return iAVPF;
	}
	public void setiAVPF(List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		this.iAVPF = iAVPF;
	}
	public InscriptionAssuranceVieDto(String id, String reference, ClientDto client, String prix, String dateInscription,
			List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		super();
		this.id = id;
		this.reference = reference;
		this.client = client;
		this.prix = prix;
		this.dateInscription = dateInscription;
		this.iAVPF = iAVPF;
	}
	public InscriptionAssuranceVieDto() {
		super();
	}
	
	
	
}
