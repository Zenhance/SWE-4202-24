public class CashOut extends Transaction{
    private static final double fe =0.0185
    public CashOut(Wallet pay, Wallet recieve, double amount, String pin) {
        super(pay, recieve, amount, pin);
    }

    @Override
    public double fee() {
        return amount()*fe;
    }

    @Override
    protected double debitAmount() {
        return 0;
    }
}
