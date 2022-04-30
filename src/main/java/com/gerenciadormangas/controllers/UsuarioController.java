package com.gerenciadormangas.controllers;

import com.gerenciadormangas.model.Autor;
import com.gerenciadormangas.model.Usuario;
import com.gerenciadormangas.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository userRepo;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView listaUsers(){

        ModelAndView mv = new ModelAndView("index");
        List<Usuario> usuarios = userRepo.findAll();

        mv.addObject("usuarios", usuarios);
        return mv;
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
