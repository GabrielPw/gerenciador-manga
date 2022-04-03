package com.gerenciadormangas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity(name = "manga")
public class Manga {

    @Id
    @Column(name = "id_manga")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "ano_lanc")
    private String anoLanc;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    Autor autor;

}
