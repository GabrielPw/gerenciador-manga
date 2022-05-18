package com.gerenciadormangas.repository;

import com.gerenciadormangas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


    public Usuario findByNome(String nome);
    public Usuario findByEmail(String email);
    public Usuario findBySenha(String senha);
}

