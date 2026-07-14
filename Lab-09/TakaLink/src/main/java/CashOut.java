public class CashOut extends Transaction  {
    private static final double RATE = 0.0185;

    public CashOut(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }
    @Override
    public double fee() {
        return amount * RATE;
    }
    @Override
    public void checkPermission() throws OperationNotAllowedException {
        from.assertCanCashOut();
        to.assertCanReceiveCashOut();
    }
    @Override
    protected void moveMoney(double fee) throws InsufficientBalanceException {
        from.debit(amount + fee);
        to.credit(amount + fee);
    }
}
