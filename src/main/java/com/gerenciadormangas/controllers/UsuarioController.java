package com.gerenciadormangas.controllers;

import com.gerenciadormangas.model.Autor;
import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.model.MangaFavorito;
import com.gerenciadormangas.model.Usuario;
import com.gerenciadormangas.repository.MangaFavoritoCustomRepository;
import com.gerenciadormangas.repository.MangaRepository;
import com.gerenciadormangas.repository.UsuarioCustomRepository;
import com.gerenciadormangas.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.hibernate.type.StringNVarcharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository userRepo;

    @Autowired
    UsuarioCustomRepository userCustomRepo;

    @Autowired
    MangaFavoritoCustomRepository mfcustomrepo;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView listaUsers(){

        ModelAndView mv = new ModelAndView("home");
        List<Usuario> usuarios = userRepo.findAll();

        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/usuarios/{id}")
    public ModelAndView show(@PathVariable("id") Long id){

        Optional<Usuario> optional = userRepo.findById(id);

        if (optional.isPresent()){
            Usuario user = optional.get();
            Optional<Usuario> userId = userRepo.findById(id);

            List<Manga> listaFav = mfcustomrepo.listaMangaFavoritoPorId(userId.get().getId());

            ModelAndView mv = new ModelAndView("usuario/detalhesUsuario");

            System.out.println("\n\nID: " + userId.get().getId() + "\n\n");


            class MangaNome{
                public List<String> nomes = new ArrayList<>();
            }

            MangaNome mn = new MangaNome();
            for (int i=0; i < listaFav.size(); i++){mn.nomes.add(listaFav.get(i).getNome());}


            System.out.println("\n\nListaFav Size: "+ listaFav.size());
            System.out.println("\n\nLista FAVORITOS: " + mn.nomes + "\n\n");
            mv.addObject("usuario", userId.get());
            mv.addObject("favoritos", mn.nomes.toString().replace("[", "").replace("]", ""));
            return mv;
        }

        return new ModelAndView("redirect:/usuarios");
    }

    @PostMapping("/usuarios/{id}")
    public String editarDescricao(@PathVariable("id") Long id, Usuario user, @RequestParam(name = "desc") String descricao){


        System.out.println("\n\nDescrição: " + descricao + "\n\nUsuario: " + id);
        userCustomRepo.atualizarDescricao(descricao, id);
        System.out.println("\n\nAtualizou?????\n\n");

        return "redirect:/usuarios/{id}";
    }

    @RequestMapping(value = "/usuarios/new", method = RequestMethod.GET)
    public  String nnew(){

        return "usuario/formUsuario";
    }

    @RequestMapping(value = "/usuarios/new", method = RequestMethod.POST)
    public String nnew(Usuario user){

        userRepo.save(user);
        return "redirect:/usuarios";
    }

}
