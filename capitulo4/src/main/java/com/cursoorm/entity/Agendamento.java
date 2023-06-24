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
@Table(name = "tb_agendamento")
public class Agendamento {
    
    @Id
    @SequenceGenerator(name = "agendamento", sequenceName = "sq_tb_agendamento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "agendamento")
    @Column(name = "id_agendamento")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_")
    private Calendar dataAgendamento;

    @Column(name = "dt_consulta_prevista")
    private Calendar dataConsultaPrevista;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;

}