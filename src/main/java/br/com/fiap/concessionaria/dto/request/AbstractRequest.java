package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest(
        @Positive(message = "O ID deve ser um número positivo")
        @NotNull(message = "O ID é obrigatório")
        Long id
) {
}