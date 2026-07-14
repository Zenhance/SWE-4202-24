public class TopUp extends Transaction {

    public TopUp(Wallet payer, Wallet paidTo, double amount, String pin) throws FrozenAccountException {
        super(payer, paidTo, amount, pin);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    protected void checkPermission() throws OperationNotAllowedException {

    }
}
