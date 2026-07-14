public class Payment extends Transaction {

    public Payment(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    protected TransactionKind kind() {
        return TransactionKind.PAYMENT;
    }
}