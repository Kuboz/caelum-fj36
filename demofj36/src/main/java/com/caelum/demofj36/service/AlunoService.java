package com.caelum.demofj36.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.caelum.demofj36.domain.Aluno;
import com.caelum.demofj36.repository.AlunoRepository;

@Service
public class AlunoService {

	@Value("${spring.rabbitmq.fila.alunos}")
	private String NOME_FILA_ALUNOS;
	
	@Value("${spring.rabbitmq.topico.nome}")
	private String NOME_TOPICO;
	
	@Value("${spring.rabbitmq.routingKey.alunos}")
	private String ROUTING_KEY_ALUNOS;
	
	private AlunoRepository repository;
	private RabbitTemplate rabbitTemplate;

	@Autowired
	public AlunoService(AlunoRepository repository, RabbitTemplate rabbitTemplate) {
		super();
		this.repository = repository;
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public Aluno cria(Aluno aluno) {
		aluno = repository.save(aluno);
		
		rabbitTemplate.convertAndSend(NOME_TOPICO, ROUTING_KEY_ALUNOS, aluno);
		
		return aluno;
	}
	
	public List<Aluno> listaByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public Aluno byId(String id) {
		return repository.findOne(id);
	}
	
	public List<Aluno> buscaTodos() {
		return repository.findAll();
	}
}
