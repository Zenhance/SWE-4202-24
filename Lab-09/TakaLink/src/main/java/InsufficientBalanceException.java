public class InsufficientBalanceException extends TransactionException {
    public InsufficientBalanceException(Wallet payer, double required) {
        super("Wallet " + payer.getId() + " needs " + required
                + " but only holds " + payer.getBalance());
    }
}
