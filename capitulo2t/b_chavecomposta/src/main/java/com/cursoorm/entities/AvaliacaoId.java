package com.cursoorm.entities;

import java.io.Serializable;

public class AvaliacaoId implements Serializable{
    
    private int usuario;

    private int estabalecimento;

    public AvaliacaoId(){

    }

    public AvaliacaoId(int usuario, int estabalecimento) {
        this.usuario = usuario;
        this.estabalecimento = estabalecimento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEstabalecimento() {
        return estabalecimento;
    }

    public void setEstabalecimento(int estabalecimento) {
        this.estabalecimento = estabalecimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + usuario;
        result = prime * result + estabalecimento;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AvaliacaoId other = (AvaliacaoId) obj;
        if (usuario != other.usuario)
            return false;
        if (estabalecimento != other.estabalecimento)
            return false;
        return true;
    }
}

/*
 * 1- Criando os Ids
 *      - Cria um atributo de ID para cada um dos itens da outra classe
 *      - Os tributos precisam ter o mesmo nome e a mesma ordem da classe original
 * 
 * Atenção -> Implementar a classe Serializable
 */