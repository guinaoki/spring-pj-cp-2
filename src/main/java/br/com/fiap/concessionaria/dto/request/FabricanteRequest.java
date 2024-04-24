package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.constraints.NotNull;

public record FabricanteRequest(
        @NotNull(message = "Nome é obrigatório")
        String nome,
        @NotNull(message = "Nome fantasia é obrigatório")
        String nomeFantasia
) {
}