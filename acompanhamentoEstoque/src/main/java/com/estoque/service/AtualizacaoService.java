package com.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.estoque.contato.Estoque;
import com.estoque.model.Produto;

@Service
public class AtualizacaoService implements Estoque {

	@Autowired
	private KafkaTemplate<String, Produto> kafkaTemplate;

	@Override
	@KafkaListener(topics = "Topico-Estoque", groupId = "nome")
	public void atualiza(Produto produto) {
		kafkaTemplate.send("test-Topico", produto);
	}

}