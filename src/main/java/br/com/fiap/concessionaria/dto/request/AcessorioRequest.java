package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;

public record AcessorioRequest(
        @NotNull(message = "Nome é obrigatório")
        String nome,
        @NotNull(message = "Preço é obrigatório")
        Double preco
) {
}