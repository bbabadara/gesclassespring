package com.ecole221.spring1.gestionclasse.services;

import com.ecole221.spring1.gestionclasse.entities.Filiere;
import com.ecole221.spring1.gestionclasse.repositories.FiliereRepository;

import java.util.List;

public interface IFiliere {

    public Filiere addFiliere(Filiere filiere);

    public List<Filiere> getAll();
}
