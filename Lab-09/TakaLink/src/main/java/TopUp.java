public class TopUp extends Transaction {
    public TopUp(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }
    @Override
    public double fee() {
        return 0.0;
    }
    @Override
    public void checkPermission() {}

    @Override
    public void moveMoney(double fee) throws InsufficientBalanceException {
        from.debit(amount);
        to.credit(amount);
    }
}
