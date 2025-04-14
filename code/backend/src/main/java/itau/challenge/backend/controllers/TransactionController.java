package itau.challenge.backend.controllers;

import itau.challenge.backend.dto.TransactionRequest;
import itau.challenge.backend.exception.costumExceptions.FutureTransactionDateException;
import itau.challenge.backend.services.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid TransactionRequest request) {
        if(request.getDataHora().isAfter(OffsetDateTime.now())) {
            log.warn("Transação invalida: a data precisa ser no passado");
            throw new FutureTransactionDateException("Transações com data futura não são permitidas.");
        }
        if(request.getValor() <= 0){
            log.warn("Transação invalida: o valor precisa ser maior que zero");
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
