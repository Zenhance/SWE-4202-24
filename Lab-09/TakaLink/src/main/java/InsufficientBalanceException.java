public class InsufficientBalanceException extends TransactionRefused {
    private final double currentBalance;
    private final double shortfall;
    public InsufficientBalanceException(String message, double currentBalance, double shortfall) {
        super(message);
        this.currentBalance = currentBalance;
        this.shortfall = shortfall;

    }
}
