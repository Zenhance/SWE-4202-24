public class SendTransaction extends Transaction {

    private static final double FEE = 5.0;

    public SendTransaction(Wallet from, Wallet to,
                           double amount, String pin) {
        super(from, to, amount, pin);
    }

    @Override
    public double getFee() {
        return FEE;
    }

    @Override
    protected void moveMoney() {
        to.credit(amount);
    }
}
