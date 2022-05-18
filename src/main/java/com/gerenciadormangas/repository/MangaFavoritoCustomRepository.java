package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.model.MangaFavorito;
import com.gerenciadormangas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MangaFavoritoCustomRepository {

    @Autowired
    private final EntityManager em;

    public MangaFavoritoCustomRepository(EntityManager em) {this.em = em;}

    public List<Manga> listaMangaFavoritoPorId(Long id){

        String query = "select m from manga m left outer join manga_favorito mf on m.id = mf.manga left outer join usuario u on u.id = mf.usuario where u.id = :id";

        var q = em.createQuery(query, Manga.class);


        q.setParameter("id", id);


        return q.getResultList();
    }
}
