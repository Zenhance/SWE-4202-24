public class InsufficientBalanceException extends TransactionException {
    private final String walletId;
    private final double required;
    private final double available;

    public InsufficientBalanceException(String walletId, double required, double available) {
        super("");
        this.walletId = walletId;
        this.required = required;
        this.available = available;
    }

    public String getWalletId() { return walletId; }
    public double getRequired() { return required; }
    public double getAvailable() { return available; }
}
