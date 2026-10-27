package com.example.demo_integracao_mongodb.repositories;

import com.example.demo_integracao_mongodb.models.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {
}
