package com.caelum.clientdemo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.caelum.clientdemo.domain.Aluno;

@Component
public class AlunoConsumer {

	@RabbitListener(queues = "alunos")
	public void leMensagem(Aluno aluno){
		System.out.println("msg: " + aluno);
	}
}
