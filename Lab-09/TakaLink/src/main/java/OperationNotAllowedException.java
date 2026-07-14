public class OperationNotAllowedException extends TransactionException {
    public OperationNotAllowedException(Wallet fromId, TransactionType type) {
        super("Wallet " + fromId.getId() + " may not be the payer of a " + type + " transaction");
    }
}
