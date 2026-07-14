public class OperationNotAllowedException extends TransactionRefused {
    private final TransactionType attemptedOperation;
    private final String accountType
    public OperationNotAllowedException(String message, TransactionType attemptedOperation, String accountType) {
        super(message);
        this.attemptedOperation = attemptedOperation;
        this.accountType = accountType;
    }
    public TransactionType getAttemptedOperation() {
        return attemptedOperation;
    }
    public String getAccountType() {
        return accountType;
    }

}
