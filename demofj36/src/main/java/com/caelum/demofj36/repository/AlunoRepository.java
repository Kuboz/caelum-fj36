package com.caelum.demofj36.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.caelum.demofj36.domain.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

	List<Aluno> findByNome(String nome);
}
