package com.caelum.demofj36.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {
	
	@Autowired
	private ConnectionFactory connectionFactory;

	@Value("${spring.rabbitmq.fila.alunos}")
	private String NOME_FILA_ALUNOS;
	
	@Value("${spring.rabbitmq.topico.nome}")
	private String NOME_TOPICO;
	
	@Value("${spring.rabbitmq.routingKey.alunos}")
	private String ROUTING_KEY_ALUNOS;
	
	
	@Bean
	public RabbitTemplate rabbitTemplate(MessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

	@Bean
	public Queue queueAlunos() {
		return new Queue(NOME_FILA_ALUNOS);
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(NOME_TOPICO);
	}
	
	@Bean
	public Binding bindingTopicEventosComFilaAlunos(Queue queueAlunos, TopicExchange topicExchange) {
		return BindingBuilder
					.bind(queueAlunos)
					.to(topicExchange)
					.with(ROUTING_KEY_ALUNOS);
	}
}
