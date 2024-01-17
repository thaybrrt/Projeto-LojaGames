package com.generation.lojagames.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome deste produto não pode estar vazio")
    @Size(min = 6, max = 30, message = "Este nome deve conter entre 6 e 30 caracteres")
    private String nome;

    @NotBlank(message = "A descrição nunca pode estar vazia")
    @Size(min = 6, max = 80, message = "A descrição deve ter entre 6 e 80 caracteres")
    private String descricao;

    @Column(precision = 8, scale = 2)
    private BigDecimal preco;

    @NotBlank(message = "É obrigatório conter uma imagem")
    private String foto;

    public Produto() {

    }

    public Produto(String nome, String descricao, BigDecimal preco, String foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
