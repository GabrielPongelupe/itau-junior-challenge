package itau.challenge.backend.controllers;

import itau.challenge.backend.dto.StatisticsResponse;
import itau.challenge.backend.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class StatisticsController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        log.info("Pegando as estatisticas das transações feitas nos últimos 60 segundos");
        return ResponseEntity.ok(transactionService.getStatistics());
    }
}
