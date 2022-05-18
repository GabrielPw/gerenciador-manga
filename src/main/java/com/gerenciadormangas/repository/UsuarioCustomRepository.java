package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class UsuarioCustomRepository {

    @Autowired
    private final EntityManager em;

    @Autowired
    UsuarioRepository userRepo;

    public UsuarioCustomRepository(EntityManager em) {
        this.em = em;
    }

    Usuario buscarNomePorEmail(String email){

        String query = "SELECT u.nome from Usuario u where u.email = :email";

        var q = em.createQuery(query, Usuario.class);
        return null;
    }

    public Usuario buscaPorEmailESenha(String email, String senha){

        try{
            String query = "SELECT u from usuario as u where u.email = :email and u.senha = :senha";

            var q = em.createQuery(query, Usuario.class);

            q.setParameter("email", email);
            q.setParameter("senha", senha);

            return q.getSingleResult();
        } catch (Exception e){

            return null;
        }
    }

    public String nomePorEmailESenha(String email, String senha){

        try{
            String query = "SELECT u from usuario as u where u.email = :email and u.senha = :senha";

            var q = em.createQuery(query, Usuario.class);

            q.setParameter("email", email);
            q.setParameter("senha", senha);

            return q.getSingleResult().getNome();
        } catch (Exception e){

            return null;
        }
    }

    public Long IdPorEmail(String email){

        try{
            String query = "SELECT u from usuario as u where u.email = :email";

            var q = em.createQuery(query, Usuario.class);

            q.setParameter("email", email);

            return q.getSingleResult().getId();
        } catch (Exception e){

            return null;
        }
    }


    public void atualizarDescricao(String desc, Long id){

        Optional<Usuario> user = userRepo.findById(id);

        user.get().setDesc(desc);
        userRepo.save(user.get());

//        try{
//            String query = "update Usuario user set user.desc = :desc where user.id = :id";
//
//            var q = em.createQuery(query, Usuario.class);
//
//            q.setParameter("desc", desc);
//            q.setParameter("id", id);
//
//        } catch (Exception e){
//
//
//        }
    }
}
