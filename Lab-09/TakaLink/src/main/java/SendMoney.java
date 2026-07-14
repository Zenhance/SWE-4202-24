public class SendMoney extends Transaction{
    private static final double FEE = 5.0;
    public SendMoney(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }
    @Override
    public double fee() {
        return FEE;
    }
    @Override
    public void checkPermission() throws OperationNotAllowedException {
        from.assertCanSend();
    }
    @Override
    protected void moveMoney(double fee) throws InsufficientBalanceException {
        from.debit(amount + fee);
        to.credit(amount);
    }
}
