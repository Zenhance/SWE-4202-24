public class CashOut extends Transaction {
    private static final double FEE_RATE = 0.0185;
    public CashOut(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }
    @Override
    public double fee() {
        return amount * FEE_RATE;
    }

    @Override
    protected double creditAmount() {
        return amount + fee();
    }

    @Override
    protected void validateOperation() throws OperationNotAllowedException {
        if (!from.canCashOut()) {
            throw new OperationNotAllowedException(from.name() + " may not cash out");
        }
        if (!to.isAgent()) {
            throw new OperationNotAllowedException("cash-out destination must be an agent");
        }
    }
}