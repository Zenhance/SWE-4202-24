public abstract class Transaction {

    private final Wallet payer;
    private final Wallet receiver;
    private final double amount;
    private final String offeredPin;

    protected Transaction(Wallet payer, Wallet receiver, double amount, String offeredPin) {
        if (payer== null || receiver== null) {
            throw new IllegalArgumentException("Wallet cannot be null");
        }
        if (amount < 0.0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (offeredPin == null) {
            throw new IllegalArgumentException("PIN cannot be null");
        }

        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
        this.offeredPin = offeredPin;
    }
    public final Wallet payer() {
        return payer;
    }

    public final Wallet receiver() {
        return receiver;
    }

    public final double amount() {
        return amount;
    }


}