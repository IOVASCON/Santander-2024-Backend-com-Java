package me.dio.dominio.controller;

import me.dio.dominio.model.Emprestimos;
import me.dio.dominio.service.EmprestimosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimosController {

    @Autowired
    private EmprestimosService emprestimosService;

    @GetMapping
    public List<Emprestimos> getAllEmprestimos() {
        return emprestimosService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Emprestimos> getEmprestimosById(@PathVariable Long id) {
        return emprestimosService.findById(id);
    }

    @PostMapping
    public Emprestimos createEmprestimos(@RequestBody Emprestimos emprestimos) {
        return emprestimosService.save(emprestimos);
    }

    @DeleteMapping("/{id}")
    public void deleteEmprestimos(@PathVariable Long id) {
        emprestimosService.deleteById(id);
    }
}
