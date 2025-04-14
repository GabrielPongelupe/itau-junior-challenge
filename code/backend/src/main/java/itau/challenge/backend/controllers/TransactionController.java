package itau.challenge.backend.controllers;

import itau.challenge.backend.dto.TransactionRequest;
import itau.challenge.backend.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
@AllArgsConstructor
@RequestMapping()
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/estatistica")
    public DoubleSummaryStatistics getStatistics() {
        return transactionService.getStatistics();
    }


}
