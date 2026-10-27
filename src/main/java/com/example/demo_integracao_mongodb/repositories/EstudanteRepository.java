package com.example.demo_integracao_mongodb.repositories;

import com.example.demo_integracao_mongodb.models.Estudante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudanteRepository extends MongoRepository<Estudante, String> {
}
