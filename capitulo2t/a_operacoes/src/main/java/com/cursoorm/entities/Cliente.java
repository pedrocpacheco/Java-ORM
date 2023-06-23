package com.cursoorm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    
    @Id
    @SequenceGenerator(name = "cliente", sequenceName = "sq_tb_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente")
    @Column(name = "id_cliente")
    private int id;

    @Column(name = "nm_cliente")
    private String name;
}
