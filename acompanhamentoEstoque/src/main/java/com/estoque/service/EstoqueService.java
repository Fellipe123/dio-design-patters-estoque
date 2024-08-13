package com.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

import com.estoque.model.Produto;

@Service
public class EstoqueService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private AtualizacaoService atualizacaoService;

    @Transactional
    public void adicionaProduto(Produto produto) {
        produtoRepository.save(produto);
    }
    
    public List<Produto> pegarProduto() {
        return produtoRepository.findAll();
    }

    @Transactional
    public void atualizarProduto(Long produtoId, Integer quantidade, String nome, Integer limite) {
        Optional<Produto> opcional = produtoRepository.findById(produtoId);
        if (opcional.isPresent()) {
            Produto p = opcional.get();
            p.setNome(nome);
            p.setQuantidade(quantidade);
            p.setLimite(limite);
            produtoRepository.save(p);
            if (p.getQuantidade() < p.getLimite()) {
                notificacao(p);
            }
        }
    }

	private void notificacao(Produto produto) {
		atualizacaoService.atualiza(produto);
    }
    
}
