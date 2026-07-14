public final class CashOut extends Transaction {
    private static final double FEE_RATE = 0.0185;

    public CashOut(Wallet payer, Wallet receiver, double amount, String offeredPin) {
        super(payer, receiver, amount, offeredPin);
    }

    @Override
    public double fee() {
        return amount() * FEE_RATE;
    }

    @Override
    protected Operation operation() {
        return Operation.CASH_OUT;
    }

    @Override
    protected void validateParties()
            throws OperationNotAllowedException {
        if (!(receiver() instanceof AgentWallet)) {
            throw new OperationNotAllowedException("Cash-out destination must be an agent");
        }
    }
    @Override
    protected double amountCreditedToReceiver(){
        return amount()+fee();
    }
}