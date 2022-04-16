package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {

    List<Manga> findAll();

//    value = "SELECT m.nome, a.nome, m.anoLanc from Manga as m inner join Autor as a on m.autor = a.Id order by a.Id;"

}
