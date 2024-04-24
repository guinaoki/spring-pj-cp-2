package br.com.fiap.concessionaria.dto.response;

import br.com.fiap.concessionaria.entity.Veiculo;
import lombok.Builder;

import java.util.Set;
@Builder
public record LojaResponse(
        Long id,
        String nome,
        Set<VeiculoResponse> veiculosComercializados
) {
}