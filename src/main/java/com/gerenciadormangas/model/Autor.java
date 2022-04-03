package com.gerenciadormangas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "autor")
public class Autor {

    @javax.persistence.Id
    @Column(name = "id_autor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "dt_nasc")
    private String dt_nasc;

}
