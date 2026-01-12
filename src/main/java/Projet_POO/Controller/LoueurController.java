 package Projet_POO.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projet_POO.Domain.Entity.Loueur;
import Projet_POO.Service.LoueurService;

@RestController
@RequestMapping("/loueurs")
public class LoueurController {

    private final LoueurService loueurService;

    public LoueurController(LoueurService loueurService) {
        this.loueurService = loueurService;
    }

    @GetMapping
    public List<Loueur> getAll() {
        return loueurService.findAll();
    }

    @GetMapping("/{id}")
    public Loueur getById(@PathVariable Long id) {
        return loueurService.findById(id);
    }


    @GetMapping("/{email}")
    public Loueur getByEmail(@PathVariable String email) {
        return loueurService.findByEmail(email);
    }


    @PostMapping
    public Loueur create(@RequestBody Loueur loueur) {
        return loueurService.create(loueur);
    }

    @PutMapping("/{id}")
    public Loueur update(@PathVariable Long id, @RequestBody Loueur loueur) {
        return loueurService.update(id, loueur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loueurService.delete(id);
    }
}
