package com.ecole221.spring1.gestionclasse.repositories;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    Classe findByCode(String code);
    Classe findByLibelle(String libelle);
}
