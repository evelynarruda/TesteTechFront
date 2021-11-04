package org.generation.BlogPessoal.controller;

import org.generation.BlogPessoal.repository.TemaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<org.generation.BlogPessoal.model.Tema>> getAll(){
        return ResponseEntity.ok(repositorio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<org.generation.BlogPessoal.model.Tema> GetById(@PathVariable long id){
        return repositorio.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<org.generation.BlogPessoal.model.Tema>> GetByName(@PathVariable String nome){
        return ResponseEntity.ok(repositorio.findAllByTemaContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<org.generation.BlogPessoal.model.Tema> Post(@RequestBody org.generation.BlogPessoal.model.Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repositorio.save(tema));
    }

    @PutMapping
    public ResponseEntity<org.generation.BlogPessoal.model.Tema> Put(@RequestBody org.generation.BlogPessoal.model.Tema tema){
        return ResponseEntity.ok(repositorio.save(tema));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repositorio.deleteById(id);
    }


}