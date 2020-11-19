package com.example.AssuranceVie.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="distributeur")
public class Distributeur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String libelle;

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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Distributeur(Long id, String reference, String libelle) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
	}
	public Distributeur(String reference, String libelle) {
		super();
		this.reference = reference;
		this.libelle = libelle;
	}
	public Distributeur() {
		super();
	}
	
}
