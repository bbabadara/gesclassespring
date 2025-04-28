package com.ecole221.spring1.gestionclasse.controllers;

import com.ecole221.spring1.gestionclasse.entities.Classe;
import com.ecole221.spring1.gestionclasse.services.ClasseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @PostMapping
    public Classe addClasse(@RequestBody @Valid Classe classe) {
        return classeService.addClasse(classe);
    }

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAll();
    }
}
