package br.com.fiap.concessionaria.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CaracteristicaRequest(

        @NotNull(message = "Nome é obrigatório")
        String nome,
        @NotNull(message = "Descricao é obrigatória")
        String descricao,
        @Valid @NotNull(message = "É necessário informar dados do veiculo")
        AbstractRequest veiculo
) {
}