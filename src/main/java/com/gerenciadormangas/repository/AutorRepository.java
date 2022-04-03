package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    
}
