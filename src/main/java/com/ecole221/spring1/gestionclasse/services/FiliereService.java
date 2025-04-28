package com.ecole221.spring1.gestionclasse.services;

import com.ecole221.spring1.gestionclasse.entities.Filiere;
import com.ecole221.spring1.gestionclasse.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere addFiliere(Filiere filiere) {
        if (filiereRepository.existsByLibelle(filiere.getLibelle())) {
            throw new RuntimeException("Le libellé de la filière existe déjà.");
        }
        return filiereRepository.save(filiere);
    }

    public List<Filiere> getAll() {
        return filiereRepository.findAll();
    }
}
