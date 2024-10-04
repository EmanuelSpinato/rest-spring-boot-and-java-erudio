package com.exemplo.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import jakarta.validation.ValidationException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoValidator produtoValidator;

    public Produto salvarProduto(Produto produto, BindingResult result) {
        produtoValidator.validate(produto, result);
        if (result.hasErrors()) {
            throw new ValidationException("Erro de validação");
        }
        return produtoRepository.save(produto);
    }
}
