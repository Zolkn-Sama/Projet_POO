package Projet_POO.Controller;

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
