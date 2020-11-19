package com.example.AssuranceVie.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="ProduitFinancier")

public class ProduitFinancier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String code;
	private List <Formule> formules;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public List<Formule> getFormules() {
		return formules;
	}
	public void setFormules(List<Formule> formules) {
		this.formules = formules;
	}
	public ProduitFinancier(Long id, String libelle, String code, List<Formule> formules) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.formules = formules;
	}
	public ProduitFinancier() {
		super();
	}
	public ProduitFinancier(String libelle, String code, List<Formule> formules) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.formules = formules;
	}
	
}
