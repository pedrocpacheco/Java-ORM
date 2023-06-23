package com.cursoorm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    
    @Id
    @SequenceGenerator(name = "usuario", sequenceName = "sq_tb_usuario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuario")
    @Column(name = "id_usuario")
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, length = 12)
    private String usuario;

}
