public class InsufficientBalanceException extends TransactionException {

    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

}
