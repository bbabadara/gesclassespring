package com.ecole221.spring1.gestionclasse.controllers;


import com.ecole221.spring1.gestionclasse.entities.Classe;
import com.ecole221.spring1.gestionclasse.entities.Filiere;
import com.ecole221.spring1.gestionclasse.services.ClasseService;
import com.ecole221.spring1.gestionclasse.services.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClasseWebController {
    private final ClasseService classeService;
    private final FiliereService filiereService;

    public ClasseWebController(ClasseService classeService, FiliereService filiereService) {
        this.classeService = classeService;
        this.filiereService = filiereService;
    }

    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classeService.getAllClasses());
        return "classes/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        List<Filiere> filieres = filiereService.getAll();
        System.out.println(filieres);
        if(filieres == null) {
            filieres = Collections.emptyList(); // Liste vide plutôt que null
        }

        model.addAttribute("classe", new Classe());
        model.addAttribute("filieres", filiereService.getAll());

        return "classes/ajout";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("classe", classeService.getClasseById(id));
        model.addAttribute("filieres", filiereService.getAll());
        return "classes/ajout";
    }

    @PostMapping("/save")
    public String saveClasse(@ModelAttribute("classe") Classe classe, Model model) {
        classeService.saveClasse(classe);
        return "redirect:/classes";
    }


    @GetMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return "redirect:/classes";
    }
}
