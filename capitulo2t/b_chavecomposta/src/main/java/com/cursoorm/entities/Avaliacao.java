package com.cursoorm.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
@IdClass(AvaliacaoId.class)
public class Avaliacao implements Serializable{

    @Id
    @JoinColumn(name = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    @Id
    @JoinColumn(name = "id_estabalecimento")
    @ManyToOne(optional = false)
    private Estabelecimento estabalecimento;

    @Column(name="vl_nota")
    private int nota;

    public Avaliacao(){

    }

    public Avaliacao(Usuario usuario, Estabelecimento estabalecimento, int nota) {
        this.usuario = usuario;
        this.estabalecimento = estabalecimento;
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estabelecimento getEstabalecimento() {
        return estabalecimento;
    }

    public void setEstabalecimento(Estabelecimento estabalecimento) {
        this.estabalecimento = estabalecimento;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}

/*
 * 1- Colocar as duas classes que terão essa relação nessa outra classe
 *       Neste caso:
 *          - Usuario faz avalização de Estabelecimento
 *          - Estabelecimento recebe avaliação de usuario
 *          (como uma relação de mts para mts, mas com algo proprio)
 * 
 * 2- Não queremos todas as informações dessas classes, so os seus IDS:
 *      - @JoinColumn com name = id_nomeClasse
 *      - @ManyToOne com optinal = false
 *        (pense que aqui é a central que liga os dois many to many) 
 * 
 * 3- Criando classe para armazenar os IDS:
 *      - Cria-se uma classe AvaliacaoID
 *      (olhe as informações nela presentes)
 * 
 * 4- Finalizando a Classe de Relação:
 *      - Coloque no topo da Classe a anotação @IdClass
 *           - Passando no () o .class da classe com os ids
 *             (AvaliacaoId.class)
 *           - Coloque @Id nos atributos de classes com Ids
 * 
 * Atenção -> Implementar a classe Serializable
 */