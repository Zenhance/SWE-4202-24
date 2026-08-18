public class CashOut extends Transaction{
    private static final double fee =0.0185;
    public CashOut(Wallet pay, Wallet recieve, double amount, String pin) {
        super(pay, recieve, amount, pin);
    }

    @Override
    public double fee() {
        return getAmount()*fee;
    }

}
