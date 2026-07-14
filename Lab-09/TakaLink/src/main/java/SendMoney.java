public class SendMoney extends Transaction {
    private static final double FLAT_FEE = 5.0;
    public SendMoney(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }

    @Override
    public double fee() {
        return FLAT_FEE;
    }

    @Override
    protected void validateOperation() throws OperationNotAllowedException {
        if (!from.canSend()) throw new OperationNotAllowedException(from.name() + " may not send money");
    }
}
