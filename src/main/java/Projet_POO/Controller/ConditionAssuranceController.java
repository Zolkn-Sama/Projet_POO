package Projet_POO.Controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.web.bind.annotation.*;

import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Service.ConditionAssuranceService;

@RestController
@RequestMapping("/conditions-assurance")
public class ConditionAssuranceController {

    private final ConditionAssuranceService conditionService;

    public ConditionAssuranceController(ConditionAssuranceService conditionService) {
        this.conditionService = conditionService;
    }

    // (Optionnel) toutes les conditions
    @GetMapping
    public List<ConditionAssurance> getAll() {
        return conditionService.findAll();
    }

    // (Optionnel) une condition par id
    @GetMapping("/{id}")
    public ConditionAssurance getById(@PathVariable Long id) {
        return conditionService.findById(id);
    }

    // tes endpoints existants (mais renommés proprement)
    @PostMapping("/assurance/{assuranceId}")
    public ConditionAssurance createForAssurance(@PathVariable Long assuranceId,
                                                 @RequestBody ConditionAssurance condition) {
        return conditionService.createForAssurance(assuranceId, condition);
    }

    @GetMapping("/assurance/{assuranceId}")
    public List<ConditionAssurance> getByAssurance(@PathVariable Long assuranceId) {
        return conditionService.findByAssurance(assuranceId);
    }

    // (Optionnel) update/delete par id
    @PutMapping("/{id}")
    public ConditionAssurance update(@PathVariable Long id, @RequestBody ConditionAssurance condition) {
        return conditionService.update(id, condition);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conditionService.delete(id);
    }
}
=======
import Projet_POO.Domain.Entity.ConditionAssurance;
import Projet_POO.Service.ConditionAssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// On change le chemin ici pour éviter le conflit avec AssuranceController
@RequestMapping("/conditions-assurances")
public class ConditionAssuranceController {

    private final ConditionAssuranceService service;

    public ConditionAssuranceController(ConditionAssuranceService service) {
        this.service = service;
    }

    // Cette méthode répondra maintenant à GET http://localhost:8090/conditions-assurances
    @GetMapping
    public List<ConditionAssurance> getAll() {
        return service.listerToutes();
    }

    // Cette méthode répondra à POST http://localhost:8090/conditions-assurances
    @PostMapping
    public ConditionAssurance creer(@RequestBody ConditionAssurance condition) {
        return service.sauvegarder(condition);
    }
}
>>>>>>> ALEX
