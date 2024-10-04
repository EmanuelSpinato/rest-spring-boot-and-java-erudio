package com.exemplo.produto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProdutoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Produto produto = (Produto) target;

        if (produto.getImagens().size() > 10) {
            errors.rejectValue("imagens", "Limite de 10 imagens excedido");
        }

        if (produto.getVideos().size() > 5) {
            errors.rejectValue("videos", "Limite de 5 vídeos excedido");
        }
    }
}
