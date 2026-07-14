public class CashOut extends Transaction {
    private static final double FEE_RATE = 0.0185;
    public CashOut(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }

}
