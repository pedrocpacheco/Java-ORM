package com.cursoorm.entity;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @SequenceGenerator(name = "consulta", sequenceName = "sq_tb_consulta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta")
    @Column(name = "id_consulta")
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_consulta")
    private Calendar dataConsulta;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Agendamento agendamento;

    @ManyToOne
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;
    
}
