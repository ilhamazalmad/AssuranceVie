package com.example.AssuranceVie.bean;

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
@Table(name="EtatInscription")
public class EtatInscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String libelle;
	@OneToMany(mappedBy="etatInscription",cascade = CascadeType.MERGE)
	@JsonIgnore
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
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public EtatInscription(Long id, String reference, String libelle) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
	}
	public EtatInscription(String reference, String libelle) {
		super();
		this.reference = reference;
		this.libelle = libelle;
	}
	public EtatInscription() {
		super();
	}
	
}
