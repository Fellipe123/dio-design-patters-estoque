package com.estoque.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.estoque.model.Produto;
import com.estoque.service.AtualizacaoService;
import com.estoque.service.EstoqueService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueServico;
	
	@GetMapping("/produto")
	public ResponseEntity<?> getTodosProdutos(){
		return new ResponseEntity<>(estoqueServico.pegarProduto(), HttpStatus.OK);
	}
	
	@PostMapping("/produto")
	public ResponseEntity<?> adicionarProduto(@RequestBody Produto produto ) {
		estoqueServico.adicionaProduto(produto);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}

	@PutMapping("/produto/{id}")
	public ResponseEntity<?> atualizarQtdProduto(@PathVariable Long id, @RequestParam Integer quantidade, @RequestParam String nome, @RequestParam Integer limite){
		estoqueServico.atualizarProduto(id, quantidade, nome, limite);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}
