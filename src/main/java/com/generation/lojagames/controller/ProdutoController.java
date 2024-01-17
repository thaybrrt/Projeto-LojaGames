package com.generation.lojagames.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagames.repository.ProdutoRepository;
import com.generation.lojagames.model.Produto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable long id) {
        return produtoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
        if (nome == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> put(@PathVariable long id, @Valid @RequestBody Produto produto) {
        return produtoRepository.findById(id)
                .map(resposta -> {
                    produto.setId(id);
                    return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");

        produtoRepository.deleteById(id);
    }
}
