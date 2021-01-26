package com.example.AssuranceVie.ws.provided.dto;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

public class ProduitFinancierDto {

	private String id;
	private String libelle;
	private String code;

	private List <FormuleDto> formules;
	private List<InscriptionAssuranceVieProduitFinancierDto> iAVPF;

	public ProduitFinancierDto(String id) {
		this.id=id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<FormuleDto> getFormules() {
		return formules;
	}
	public void setFormules(List<FormuleDto> formules) {
		this.formules = formules;
	}
	
	
	public List<InscriptionAssuranceVieProduitFinancierDto> getiAVPF() {
		return iAVPF;
	}

	public void setiAVPF(List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		this.iAVPF = iAVPF;
	}

	public ProduitFinancierDto(String id, String libelle, String code, List<FormuleDto> formules,
			List<InscriptionAssuranceVieProduitFinancierDto> iAVPF) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.formules = formules;
		this.iAVPF = iAVPF;
	}

	public ProduitFinancierDto() {
		super();
	}
	public ProduitFinancierDto(String libelle, String code, List<FormuleDto> formules) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.formules = formules;
	}
	
}
