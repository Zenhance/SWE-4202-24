public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(double amount, double balance) {
        super("Tried to debit " + amount + " but balance was " + balance);
    }
}
