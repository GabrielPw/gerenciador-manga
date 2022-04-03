package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MangaRepository extends CrudRepository<Manga, Long> {
}
