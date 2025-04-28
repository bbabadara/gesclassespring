package com.ecole221.spring1.gestionclasse;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import com.ecole221.spring1.gestionclasse.entities.Filiere;
import com.ecole221.spring1.gestionclasse.repositories.ClasseRepository;
import com.ecole221.spring1.gestionclasse.repositories.FiliereRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionclasseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionclasseApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(FiliereRepository filiereRepository, ClasseRepository classeRepository) {
		return args -> {
			// Vérifie si les données existent déjà
			if (filiereRepository.count() == 0) {
				Filiere info = new Filiere();
				info.setLibelle("Informatique");
				filiereRepository.save(info);

				Filiere gestion = new Filiere();
				gestion.setLibelle("Gestion");
				filiereRepository.save(gestion);

				// Ajout d'une classe liée à la filière Informatique
				Classe l1 = new Classe();
				l1.setCode("INFO-L1");
				l1.setLibelle("Licence 1 Info");
				l1.setMontantInscription(50000);
				l1.setMensualite(45000);
				l1.setAutresFrais(10000);
				l1.setFiliere(info);

				classeRepository.save(l1);
			}
		};
	}
}
