public abstract class Transaction {

    protected final Wallet from;
    protected final Wallet to;
    protected final double amount;
    protected final String pin;

    protected Transaction(Wallet from, Wallet to, double amount, String pin) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("transaction requires two real wallets");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("transaction amount must be positive");
        }
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.pin = pin;
    }