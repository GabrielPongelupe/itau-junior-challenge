package itau.challenge.backend.exception;

import itau.challenge.backend.exception.costumExceptions.FutureTransactionDateException;
import itau.challenge.backend.exception.costumExceptions.InvalidTransactionAmountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FutureTransactionDateException.class)
    public ResponseEntity<Map<String, Object>> handleFutureTransactionDateException(FutureTransactionDateException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
                "timestamp", OffsetDateTime.now(),
                "status", HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "error", "Transação inválida",
                "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(InvalidTransactionAmountException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidTransactionAmountException(InvalidTransactionAmountException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(Map.of(
                "timestamp", OffsetDateTime.now(),
                "status", HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "error", "Transação inválida",
                "message", ex.getMessage()
        ));
    }

}
