package com.ecole221.spring1.gestionclasse.repositories;

import com.ecole221.spring1.gestionclasse.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    Filiere findByLibelle(String libelle);
}
