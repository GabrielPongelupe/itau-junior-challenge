package itau.challenge.backend.exception.costumExceptions;

public class FutureTransactionDateException extends RuntimeException {
    public FutureTransactionDateException(String message) {
        super(message);
    }
}
