package com.cursoorm.entity;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_paciente")
public class Paciente {
    
    @Id
    @SequenceGenerator(name = "paciente", sequenceName = "sq_tb_paciente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paciente")
    @Column(name = "id_paciente")
    private int id;

    @Column(name = "nm_paciente", nullable = false, length = 50)
    private String nome;

    @Column(name = "ds_email_paciente", nullable = false, length = 80)
    private String email;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nasc_paciente")
    private Calendar dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_genero_paciente")
    private Genero genero;


}
