package com.gerenciadormangas.controllers;

import com.gerenciadormangas.model.Autor;
import com.gerenciadormangas.model.Manga;
import com.gerenciadormangas.repository.AutorRepository;
import com.gerenciadormangas.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class mangaController {

    @Autowired
    private MangaRepository mr;

    @Autowired
    private AutorRepository ar;

    @RequestMapping(value = "/cadastrarManga", method = RequestMethod.GET)
    public ModelAndView manga(){

        ModelAndView mv = new ModelAndView("manga/formManga");
        List<Autor> autores = ar.findAll();
        List<Manga> mangas = mr.findAll();
        Manga manga = new Manga();

        mv.addObject("autores", autores);
        mv.addObject("mangas", mangas);

        return mv;
    }

    @RequestMapping(value = "/cadastrarManga", method = RequestMethod.POST)
    public String manga(Manga manga){

        mr.save(manga);
        return "redirect:/cadastrarManga";
    }

    @RequestMapping(value = "/mangas")
    public ModelAndView listaManga(){
        ModelAndView mv = new ModelAndView("home");
        List<Manga> mangas = mr.findAll();

        mv.addObject("mangas", mangas);
        return mv;
    }

    @GetMapping("/mangas/{id}")
    public ModelAndView mangaPorId(@PathVariable Long id){

        Optional<Manga> manga = mr.findById(id);

        ModelAndView mv = new ModelAndView("manga/detalhesManga");
        mv.addObject("manga_", manga.get());

        return mv;
    }

}
