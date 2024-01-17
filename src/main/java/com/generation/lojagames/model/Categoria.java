package com.generation.lojagames.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="Nome não pode estar vazio")
	@Size(min=6, max=50, message="Nome deve conter entre 6 e 50 caracteres")
	private String nome;
	
	@NotBlank(message="Descrição nunca pode estar vazia")
	@Size(min=10, max=100, message="Descrição deve ter entre 10 e 100 caracteres")
	private String descricao;

    // Alteração no tipo do campo nome para BigDecimal
    @NotNull(message = "Preço não pode ser nulo")
    private BigDecimal preco;

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

    // Getters e setters para o campo preco

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
