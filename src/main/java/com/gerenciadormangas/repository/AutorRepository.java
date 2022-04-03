package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
