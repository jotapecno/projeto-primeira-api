package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Curso;
import com.example.demo_integracao_mongodb.repositories.CursoRepository;
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
@RequestMapping("api/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void gravar(@RequestBody Curso curso) {
        this.cursoRepository.save(curso);
    }

    @GetMapping
    public List<Curso> buscarTodos() {
        return this.cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable String id) {
        return this.cursoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable String id, @RequestBody Curso curso) {
        if (!this.cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        curso.setId(id);
        return ResponseEntity.ok(this.cursoRepository.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        if (!this.cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        this.cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
