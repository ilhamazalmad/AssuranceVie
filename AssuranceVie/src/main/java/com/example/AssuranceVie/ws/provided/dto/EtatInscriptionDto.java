package com.example.AssuranceVie.ws.provided.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EtatInscriptionDto {

	private String id;
	private String reference;
	private String libelle;
	private List<InscriptionAssuranceVieProduitFinancierDto> iAVPF;
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
	
	public List<InscriptionAssuranceVieProduitFinancierDto> getiAVPF() {
		return iAVPF;
	}
	public void setiAVPF(List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		this.iAVPF = iAVPF;
	}
	public EtatInscriptionDto() {
		super();
	}
	public EtatInscriptionDto(String id, String reference, String libelle,
			List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.iAVPF = iAVPF;
	}
	public EtatInscriptionDto(String reference, String libelle,
			List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.iAVPF = iAVPF;
	}
	
}
