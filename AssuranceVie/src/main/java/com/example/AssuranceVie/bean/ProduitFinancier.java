package com.example.AssuranceVie.bean;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="produitfinancier")
public class ProduitFinancier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private String code;

	@OneToMany(mappedBy="produitFinancier",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List <Formule> formules;
	@OneToMany(mappedBy="produit",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<InscriptionAssuranceVieProduitFinancier> iAVPF;

	public ProduitFinancier(long id) {
		this.id=id;
	}

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
	
	
	public List<InscriptionAssuranceVieProduitFinancier> getiAVPF() {
		return iAVPF;
	}

	public void setiAVPF(List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		this.iAVPF = iAVPF;
	}

	public ProduitFinancier(Long id, String libelle, String code, List<Formule> formules,
			List<InscriptionAssuranceVieProduitFinancier> iAVPF) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.formules = formules;
		this.iAVPF = iAVPF;
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
