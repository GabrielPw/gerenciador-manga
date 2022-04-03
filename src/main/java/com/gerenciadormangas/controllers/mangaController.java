package com.gerenciadormangas.controllers;

import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mangaController {

    @Autowired
    private MangaRepository mr;

    @RequestMapping(value = "/cadastrarManga", method = RequestMethod.GET)
    public String manga(){
        return "manga/formManga";
    }

    @RequestMapping(value = "/cadastrarManga", method = RequestMethod.POST)
    public String manga(Manga manga){

        mr.save(manga);
        return "redirect:/cadastrarManga";
    }

    @RequestMapping(value = "/mangas")
    public ModelAndView listaManga(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Manga> mangas = mr.findAll();

        mv.addObject("mangas", mangas);
        return mv;
    }

}
