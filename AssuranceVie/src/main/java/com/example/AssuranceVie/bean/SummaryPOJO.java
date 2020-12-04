package com.example.AssuranceVie.bean;

import java.util.Date;
import java.util.List;

public class SummaryPOJO {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private Long telephone;
    private String cin;
    private Date dateNaissance;
    private String reference;
   // private List<IAVPFsimpl> prods;


    public SummaryPOJO(){
        super();
    }

    public SummaryPOJO(Long id, String nom, String prenom, String adresse, Long telephone, String CIN, Date dateNaissance, String reference) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.cin= CIN;
       this. dateNaissance = dateNaissance;

        this.reference = reference;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getTelephone() {
        return this.telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String CIN) {
        this.cin = CIN;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    /*public List<IAVPFsimpl> getProds() {
        return this.prods;
    }

    public void setProds(List<IAVPFsimpl> prods) {
        this.prods = prods;
    }*/
}
