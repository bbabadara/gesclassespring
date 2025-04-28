package com.ecole221.spring1.gestionclasse.services;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import com.ecole221.spring1.gestionclasse.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public Classe addClasse(Classe classe) {
        if (classeRepository.existsByCode(classe.getCode())) {
            throw new RuntimeException("Le code de la classe existe déjà.");
        }

        if (classeRepository.existsByLibelle(classe.getLibelle())) {
            throw new RuntimeException("Le libellé de la classe existe déjà.");
        }

        if (classe.getMontantInscription() < 50000) {
            throw new RuntimeException("Montant d'inscription trop bas (min 50 000).");
        }

        if (classe.getMensualite() < 40000) {
            throw new RuntimeException("Mensualité trop basse (min 40 000).");
        }

        if (classe.getAutresFrais() < 8000) {
            throw new RuntimeException("Autres frais trop bas (min 8 000).");
        }

        return classeRepository.save(classe);
    }

    public List<Classe> getAll() {
        return classeRepository.findAll();
    }



    public List<com.ecole221.spring1.gestionclasse.entities.Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public com.ecole221.spring1.gestionclasse.entities.Classe getClasseById(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    public com.ecole221.spring1.gestionclasse.entities.Classe saveClasse(com.ecole221.spring1.gestionclasse.entities.Classe classe) {
        return classeRepository.save(classe);
    }

    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}
