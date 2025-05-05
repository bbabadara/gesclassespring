package com.ecole221.spring1.gestionclasse.services;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import com.ecole221.spring1.gestionclasse.exceptions.ScolariteException;
import com.ecole221.spring1.gestionclasse.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService implements IClasse{

    @Autowired
    private ClasseRepository classeRepository;

    public Classe saveClasse(Classe classe) throws ScolariteException {
        if (classeRepository.findByCode(classe.getCode())!=null)  {
            throw new ScolariteException("Le code de la classe existe déjà.");
        }

        if (classeRepository.findByLibelle(classe.getLibelle())!=null) {
            throw new ScolariteException("Le libellé de la classe existe déjà.");
        }

        String message= validerMontant("Montant inscription",classe.getMontantInscription(),50000);
        message += !message.isEmpty()?"<br>"+ validerMontant("Mensualité",classe.getMensualite(),40000):"";
        message += !message.isEmpty()?"<br>"+ validerMontant("Autres frais",classe.getAutresFrais(),8000):"";

        if (message.isEmpty()){
            return classeRepository.save(classe);
        }
        throw new ScolariteException(message);

    }

    private String validerMontant(String fieldName,double value,int seuil){
        if (value<seuil) {
            return fieldName + " trop bas (min "+seuil+").";
        }
        return "";
    }

    public List<Classe> getAll() {
        return classeRepository.findAll();
    }



    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Classe getClasseById(Long id) {
        return classeRepository.findById(id).orElse(null);
    }



    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }


}
