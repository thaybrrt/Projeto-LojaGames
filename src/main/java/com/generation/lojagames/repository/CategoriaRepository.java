package com.generation.lojagames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Ajuste o nome da propriedade conforme o campo real na classe Categoria
    Optional<Categoria> findByNome(String nome);
}
