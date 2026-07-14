public class CashOut extends Transaction {
    private static final double FEE_RATE = 0.0185; // placeholder -- match the test file

    public CashOut( Wallet fromId, Wallet toId,double amount,  String pin) {
        super(fromId, toId,amount, pin);
    }

    @Override
    public double fee() {
        return getAmount() * FEE_RATE;
    }

    @Override
    protected TransactionType type() {
        return TransactionType.CASHOUT;
    }
    }

