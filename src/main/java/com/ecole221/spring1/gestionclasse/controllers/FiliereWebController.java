package com.ecole221.spring1.gestionclasse.controllers;

import com.ecole221.spring1.gestionclasse.entities.Filiere;
import com.ecole221.spring1.gestionclasse.repositories.FiliereRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filieres")
public class FiliereWebController {

    private final FiliereRepository filiereRepository;

    public FiliereWebController(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    @GetMapping
    public String listFilieres(Model model) {
        model.addAttribute("filieres", filiereRepository.findAll());
        model.addAttribute("filiere", new Filiere());
        return "filiere/list";
    }


    @PostMapping
    public String addFiliere(@ModelAttribute Filiere filiere) {
        filiereRepository.save(filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/delete/{id}")
    public String deleteFiliere(@PathVariable Long id) {
        filiereRepository.deleteById(id);
        return "redirect:/filieres";
    }

    @GetMapping("/edit/{id}")
    public String editFiliere(@PathVariable Long id, Model model) {
        model.addAttribute("filieres", filiereRepository.findAll());
        model.addAttribute("filiere", filiereRepository.findById(id).orElse(new Filiere()));
        return "filiere/list";
    }

    @PostMapping("/update")
    public String updateFiliere(@ModelAttribute Filiere filiere) {
        filiereRepository.save(filiere);
        return "redirect:/filieres";
    }

    @GetMapping("/{id}/classes")
    public String voirClassesParFiliere(@PathVariable Long id, Model model) {
        Filiere filiere = filiereRepository.findById(id).orElse(null);
        if (filiere != null) {
            model.addAttribute("filiere", filiere);
            model.addAttribute("classes", filiere.getClasses());
        }
        return "filiere/classes";
    }

}

