package com.cursoorm.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @SequenceGenerator(name = "estabelecimento", sequenceName = "sq_tb_estabelecimento", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estabelecimento")
    @Column(name = "id_estabelecimento")
    private int id;

    @Column(name = "nm_estabelecimento", length = 50)
    private String nome;    

    @OneToOne(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST) // Bi relacionamento (ja foi feito em outra classe) -> Diz o nome do atributo ja mapeado
    private ContratoAluguel contrato;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tipo_estabelecimento")
    private TipoEstabelecimento tipo;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "id_estabelecimento"), inverseJoinColumns = @JoinColumn(name = "id_cliente"), name = "tb_cliente_estabelecimento")
    private List<Cliente> clientes;

    public Estabelecimento(){
        
    }    

    public Estabelecimento(int id, String nome, ContratoAluguel contrato, TipoEstabelecimento tipo,
            List<Cliente> clientes) {
        this.id = id;
        this.nome = nome;
        this.contrato = contrato;
        this.tipo = tipo;
        this.clientes = clientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContratoAluguel getContrato() {
        return contrato;
    }

    public void setContrato(ContratoAluguel contrato) {
        this.contrato = contrato;
    }

    public TipoEstabelecimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstabelecimento tipo) {
        this.tipo = tipo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    
}
