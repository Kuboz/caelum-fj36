package com.caelum.demofj36.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caelum.demofj36.domain.Aluno;
import com.caelum.demofj36.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		super();
		this.alunoService = alunoService;
	}

	@GetMapping
	public List<Aluno> getAlunos() {
		return alunoService.buscaTodos();
	}
	
	@PostMapping
	public Aluno criaAluno(@RequestBody Aluno aluno) {
		return alunoService.cria(aluno);
	}
}
