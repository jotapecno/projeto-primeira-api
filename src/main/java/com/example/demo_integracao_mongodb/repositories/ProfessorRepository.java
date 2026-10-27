package com.example.demo_integracao_mongodb.repositories;

import com.example.demo_integracao_mongodb.models.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
