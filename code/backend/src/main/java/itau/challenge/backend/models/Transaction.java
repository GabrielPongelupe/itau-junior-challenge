package itau.challenge.backend.models;

import lombok.*;

import java.time.OffsetDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Transaction {
    private double valor;
    private OffsetDateTime dataHora;
}
