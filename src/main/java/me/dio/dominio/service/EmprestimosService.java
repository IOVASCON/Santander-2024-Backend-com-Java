package me.dio.dominio.service;

import me.dio.dominio.model.Emprestimos;
import me.dio.dominio.repository.EmprestimosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimosService {

    @Autowired
    private EmprestimosRepository emprestimosRepository;

    public List<Emprestimos> findAll() {
        return emprestimosRepository.findAll();
    }

    public Optional<Emprestimos> findById(Long id) {
        return emprestimosRepository.findById(id);
    }

    public Emprestimos save(Emprestimos emprestimos) {
        return emprestimosRepository.save(emprestimos);
    }

    public void deleteById(Long id) {
        emprestimosRepository.deleteById(id);
    }
}
