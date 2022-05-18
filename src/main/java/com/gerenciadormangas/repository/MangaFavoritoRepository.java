package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.MangaFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaFavoritoRepository extends JpaRepository<MangaFavorito, Long> {
}
