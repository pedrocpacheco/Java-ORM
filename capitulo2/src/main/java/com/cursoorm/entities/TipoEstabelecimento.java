package com.cursoorm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_estabelecimento")
public class TipoEstabelecimento {
    
    @Id
    @Column(name = "id_tipo")
    private int id;

    @Column(name = "nm_tipo")
    private String nome;

}
