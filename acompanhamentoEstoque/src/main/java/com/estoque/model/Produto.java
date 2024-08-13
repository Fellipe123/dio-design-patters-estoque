package com.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUTO_TB")
@Getter
@Setter
@ToString
@NoArgsConstructor 
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
	private Long id;
	
	@Column(name = "NOME" ,length = 100, nullable = false)
	private String nome;
	
	@Column(name = "QUANTIDADE" , nullable = false)
	private int quantidade;

	@Column(name = "LIMITE" , nullable = false)
	private int limite;
	
}
