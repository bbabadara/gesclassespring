package com.ecole221.spring1.gestionclasse.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
