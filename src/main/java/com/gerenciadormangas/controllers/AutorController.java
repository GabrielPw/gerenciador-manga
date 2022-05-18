package com.gerenciadormangas.controllers;

import com.gerenciadormangas.model.Autor;
import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorController {



    @Autowired
    public AutorRepository ar;


    @RequestMapping(value = "/cadastrarAutor", method = RequestMethod.GET)
    public String autor(){
        return "autor/formAutor";
    }

    @RequestMapping(value = "/cadastrarAutor", method = RequestMethod.POST)
    public String autor(Autor autor){

        ar.save(autor);
        return "redirect:/cadastrarAutor";
    }

    @RequestMapping(value = "/autor")
    public ModelAndView listaAutores(){
        ModelAndView mv = new ModelAndView("home");
        List<Autor> autores = ar.findAll();

        mv.addObject("autores", autores);
        return mv;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public ModelAndView detalhesAutor(@PathVariable("Id") long id){

        ModelAndView mv = new ModelAndView("detalhesAutor");
        Optional<Autor> autorId = ar.findById(id);

        mv.addObject("autorid", autorId);
        return mv;
    }
}
