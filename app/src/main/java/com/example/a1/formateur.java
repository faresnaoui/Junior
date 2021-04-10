package com.example.a1;

public class formateur {
    String mail;
    String nom;
    String prenom;
    String telephone;
    String id;

    public formateur() {
    }

    public formateur(String mail,String nom,String prenom,String telephone){
        this.mail=mail;
        this.nom=nom;
        this.prenom=prenom;
        this.telephone=telephone;
        this.id="";

    }

    public formateur(String mail,String nom,String prenom,String telephone,String id){
        this.mail=mail;
        this.nom=nom;
        this.prenom=prenom;
        this.telephone=telephone;
        this.id=id;

    }
    public String getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setId(String id) {
        this.id = id;
    }
}
