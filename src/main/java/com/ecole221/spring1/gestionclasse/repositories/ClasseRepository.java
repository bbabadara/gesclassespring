package com.ecole221.spring1.gestionclasse.repositories;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
    boolean existsByCode(String code);
    boolean existsByLibelle(String libelle);
}
