package com.gerenciadormangas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Autor {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String nome;
    private String dt_nasc;

    @OneToMany
    private List<Manga> manga;
}
