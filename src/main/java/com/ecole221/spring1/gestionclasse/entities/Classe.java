package com.ecole221.spring1.gestionclasse.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le code ne doit pas être vide.")
    private String code;

    @NotBlank(message = "Le libellé ne doit pas être vide.")
    private String libelle;

    @Min(value = 50000, message = "Le montant d'inscription doit être au moins 50 000.")
    private double montantInscription;

    @Min(value = 40000, message = "La mensualité doit être au moins 40 000.")
    private double mensualite;

    @Min(value = 8000, message = "Les autres frais doivent être au moins 8 000.")
    private double autresFrais;

    @NotNull(message = "La filière est obligatoire.")
    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getMontantInscription() {
        return montantInscription;
    }

    public void setMontantInscription(double montantInscription) {
        this.montantInscription = montantInscription;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }

    public double getAutresFrais() {
        return autresFrais;
    }

    public void setAutresFrais(double autresFrais) {
        this.autresFrais = autresFrais;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
