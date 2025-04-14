package itau.challenge.backend.services;

import itau.challenge.backend.dto.TransactionRequest;
import itau.challenge.backend.models.Transaction;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizer;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
public class TransactionService {
    /*
        Since the challenge does not allow using a database or files for persistence,
        all data must be stored in memory only.
        Therefore, the ConcurrentLinkedQueue was chosen,
        as it allows in-memory storage with thread-safe access for concurrent operations.
    */
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    private final ModelMapper modelMapper;


    public void add(TransactionRequest transactionRequest) {
        transactions.add(modelMapper.map(transactionRequest, Transaction.class));
    }

    public void deleteAll(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();

        return transactions.stream()
                .filter(T -> T.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }


}
