package me.dio.dominio.repository;

import me.dio.dominio.model.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {
}
