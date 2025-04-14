package itau.challenge.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
public class TransactionRequest {
    @NotNull(message = "{comum.atributos.valor.obrigatorio}")
    @Min(0)
    private double valor;

    @NotNull(message = "{comum.atributos.valor.dataHora}")
    private OffsetDateTime dataHora;
}
