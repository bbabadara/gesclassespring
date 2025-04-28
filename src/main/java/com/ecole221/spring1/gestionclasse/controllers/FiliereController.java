package com.ecole221.spring1.gestionclasse.controllers;

import com.ecole221.spring1.gestionclasse.entities.Filiere;
import com.ecole221.spring1.gestionclasse.services.FiliereService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @PostMapping
    public Filiere addFiliere(@RequestBody @Valid Filiere filiere) {
        return filiereService.addFiliere(filiere);
    }

    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAll();
    }
}
