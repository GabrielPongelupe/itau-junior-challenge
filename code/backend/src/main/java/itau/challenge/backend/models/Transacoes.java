package itau.challenge.backend.models;

import lombok.*;

import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
@Getter
public class Transacoes {
    private double valor;
    private OffsetDateTime dataHora;
}
