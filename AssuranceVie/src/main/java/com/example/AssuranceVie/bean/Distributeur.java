package com.example.AssuranceVie.bean;

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

@Entity
@Table(name="distributeur")
public class Distributeur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String libelle;
	@OneToMany(mappedBy="distributeur",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<InscriptionAssuranceVieProduitFinancier> iAVPF;
    public Distributeur(String r) {

    	this.reference=r;
    }

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
	
	public List<InscriptionAssuranceVieProduitFinancier> getiAVPF() {
		return iAVPF;
	}

	public void setiAVPF(List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		this.iAVPF = iAVPF;
	}

	public Distributeur(Long id, String reference, String libelle,
			List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		super();
		this.id = id;
		this.reference = reference;
		this.libelle = libelle;
		this.iAVPF = iAVPF;
	}

	public Distributeur() {
		super();
	}
	
}
