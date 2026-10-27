package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Estudante;
import com.example.demo_integracao_mongodb.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @PostMapping
    public void gravar(@RequestBody Estudante estudante) {
        this.estudanteRepository.save(estudante);
    }

    @GetMapping
    public List<Estudante> buscarTodos() {
        return this.estudanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarPorId(@PathVariable String id) {
        return this.estudanteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizar(@PathVariable String id, @RequestBody Estudante estudante) {
        if (!this.estudanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estudante.setId(id);
        return ResponseEntity.ok(this.estudanteRepository.save(estudante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        if (!this.estudanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        this.estudanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
