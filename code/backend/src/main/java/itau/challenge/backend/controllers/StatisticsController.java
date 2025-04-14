package itau.challenge.backend.controllers;

import itau.challenge.backend.dto.StatisticsResponse;
import itau.challenge.backend.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class StatisticsController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        return ResponseEntity.ok(transactionService.getStatistics());
    }
}
