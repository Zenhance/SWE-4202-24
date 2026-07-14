public class TopUp extends Transaction {

    public TopUp(Wallet payer, Wallet provider, double amount, String pin) {
        super(payer, provider, amount, pin);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    protected TransactionType type() {
        return TransactionType.TOPUP;
    }
    }

