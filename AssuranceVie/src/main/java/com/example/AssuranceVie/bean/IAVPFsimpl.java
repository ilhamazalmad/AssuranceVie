package com.example.AssuranceVie.bean;

public class IAVPFsimpl {
    private String distributeur;
    private String etat;
    private String formule;
    private String produit;
    private Double montant;
    private String police;

    public IAVPFsimpl() {
    }

    public IAVPFsimpl(String distributeur, String etat, String formule, String produit, Double montant, String police) {
        distributeur = distributeur;
        etat = etat;
        formule = formule;
        produit = produit;
        montant = montant;
        police = police;
    }

    public String getDistributeur() {
        return distributeur;
    }

    public void setDistributeur(String distributeur) {
        this.distributeur = distributeur;
    }

    public String getEtat() {
        return this.etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getFormule() {
        return formule;
    }

    public void setFormule(String formule) {
        this.formule = formule;
    }

    public String getProduit() {
        return this.produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Double getMontant() {
        return this.montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getPolice() {
        return this.police;
    }

    public void setPolice(String police) {
        this.police = police;
    }
}
