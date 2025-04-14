package itau.challenge.backend.controllers;

import itau.challenge.backend.dto.TransactionRequest;
import itau.challenge.backend.exception.FutureTransactionDateException;
import itau.challenge.backend.services.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@RestController
@AllArgsConstructor
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid TransactionRequest request) {
        if(request.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new FutureTransactionDateException("Transações com data futura não são permitidas.");
        }
        if(request.getValor() <= 0){
            throw new FutureTransactionDateException("Transações com valores iguais ou menores que zero não são permitidas.");
        }

        transactionService.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransaction(@RequestBody @Valid TransactionRequest request) {
        transactionService.deleteAll();
        return ResponseEntity.ok().build();
    }


}
