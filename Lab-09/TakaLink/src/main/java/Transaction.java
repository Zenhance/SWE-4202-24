public abstract class Transaction {

    private final Wallet payer;
    private final Wallet receiver;
    private final double amount;
    private final String offeredPin;

    protected Transaction(
            Wallet payer,
            Wallet receiver,
            double amount,
            String offeredPin
    ) {
        this.payer = payer;
        this.receiver = receiver;
        this.amount = amount;
        this.offeredPin = offeredPin;
    }

    public Wallet payer() {
        return payer;
    }

    public Wallet receiver() {
        return receiver;
    }

    public double amount() {
        return amount;
    }

    protected String offeredPin() {
        return offeredPin;
    }

    public abstract double fee();

    public void settle() throws TransactionException {
    }
}