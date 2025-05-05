package com.ecole221.spring1.gestionclasse.services;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import com.ecole221.spring1.gestionclasse.exceptions.ScolariteException;

import java.util.List;

public interface IClasse {
    public Classe saveClasse(Classe classe) throws ScolariteException;

    public List<Classe> getAll();


    public List<Classe> getAllClasses();

    public Classe getClasseById(Long id);



    public void deleteClasse(Long id);
}
