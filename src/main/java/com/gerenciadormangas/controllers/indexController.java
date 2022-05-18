package com.gerenciadormangas.controllers;

import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.model.MangaFavorito;
import com.gerenciadormangas.model.Usuario;
import com.gerenciadormangas.repository.MangaFavoritoRepository;
import com.gerenciadormangas.repository.UsuarioCustomRepository;
import com.gerenciadormangas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class indexController {

    @Autowired
    UsuarioRepository userrepo;

    @Autowired
    MangaFavoritoRepository mfRepo;

    @Autowired
    UsuarioCustomRepository ucustomrepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView("home");

        return mv;
    }

    @RequestMapping(value = "/efetuarLogin", method = RequestMethod.POST)
    public String efetuarLogin(Usuario usuario, HttpSession session){

//        Usuario user = userrepo.findByEmail(usuario.getEmail());
//        Usuario username = userrepo.findByNome(usuario.getNome());
//
//
//        System.out.println("\n---------------\nUser: " + user + "\n-------------------\n");
//        if (user != null && userrepo.findBySenha(usuario.getSenha()) != null){
//
//            System.out.println("\n---------------\nEmail: " + user.getEmail() + "\n-------------------\n");
//            System.out.println("\n---------------\nSenha: " + user.getSenha() + "\n-------------------\n");
//
//            System.out.println("Nome: " + usuario.getNome());
//            session.setAttribute("usuarioLogado", usuario);
//            return "redirect:/home";
//        }
//        return "redirect:/";

        Usuario user = ucustomrepo.buscaPorEmailESenha(usuario.getEmail(), usuario.getSenha());
        String nomeUser = ucustomrepo.nomePorEmailESenha(usuario.getEmail(), usuario.getSenha());

        Long idUser = ucustomrepo.IdPorEmail(usuario.getEmail());

        MangaFavorito mangaFav = mfRepo.getById(1L);

        System.out.println("\n---------------\nUser: " + user + "\n-------------------\n");
        if (user != null){


            System.out.println("Nome: " + usuario.getNome());
            System.out.println("senha: " + usuario.getSenha());

            usuario.setNome(nomeUser);
            session.setAttribute("usuarioLogado", usuario);
            session.setAttribute("id", idUser);
            session.setAttribute("listaManga", mangaFav.getManga());


            System.out.println("\n\n\n\nId do Usuário: " + idUser);
            System.out.println("\n\nMango: " + mangaFav.getManga().getNome());

            return "redirect:/home";
        }
        return "redirect:/";
    }
}
