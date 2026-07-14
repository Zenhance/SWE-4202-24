public class Payment extends Transaction {
    public Payment(Wallet payer, Wallet merchant, double amount, String pin) {
        super(payer, merchant, amount, pin);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    protected TransactionType type() {
        return TransactionType.PAYMENT;
    }
    }

