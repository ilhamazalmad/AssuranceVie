package com.example.AssuranceVie.ws.provided.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DistributeurDto {

	private String id;
	private String reference;
	private String libelle;
	private String pwd;
	private List<InscriptionAssuranceVieProduitFinancierDto> iAVPF;
    public DistributeurDto(String r) {

    	this.reference=r;
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<InscriptionAssuranceVieProduitFinancierDto> getiAVPF() {
		return iAVPF;
	}

	public void setiAVPF(List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		this.iAVPF = iAVPF;
	}

	public DistributeurDto(String id, String reference, String libelle, String pwd,
			List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.pwd = pwd;
		this.iAVPF = iAVPF;
	}

	public DistributeurDto(String reference, String libelle, String pwd,
			List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		super();
		this.reference = reference;
		this.libelle = libelle;
		this.pwd = pwd;
		this.iAVPF = iAVPF;
	}

	public DistributeurDto() {
		super();
	}

	
	
}
