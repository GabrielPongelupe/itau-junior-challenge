package itau.challenge.backend.exception;

public class FutureTransactionDateException extends RuntimeException {
    public FutureTransactionDateException(String message) {
        super(message);
    }
}
