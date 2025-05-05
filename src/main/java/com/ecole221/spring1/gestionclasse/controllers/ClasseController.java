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


    private final ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @PostMapping
    public Classe addClasse(@RequestBody @Valid Classe classe) {
        return classeService.saveClasse(classe);
    }

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAll();
    }
}
