package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Year;

public record VeiculoRequest(

        @NotNull(message = "Nome é obrigatório")
        String nome,
        @NotNull(message = "Preço é obrigatório")
        Double preco,
        @NotNull(message = "Modelo é obrigatório")
        String modelo,
        @NotNull(message = "Ano é obrigatório")
        Year anoDeFabricacao,
        @NotNull(message = "Cor é obrigatório")
        String cor,
        @NotNull(message = "Palavra de efeito é obrigatório")
        String palavraDeEfeito,
        @NotNull(message = "Cilindradas é obrigatório")
        Short cilindradas,
        @NotNull(message = "Nome é obrigatório")
        @Valid @NotNull(message = "É necessário informar o tipo")
        AbstractRequest tipo,
        @Valid @NotNull(message = "É necessário informar dados do fabricante")
        AbstractRequest fabricante



) {
}