public class CashOut extends Transaction {


    public CashOut(Wallet payer, Wallet paidTo, double amount, String pin) throws FrozenAccountException {
        super(payer, paidTo, amount, pin);
    }


    @Override
    public double fee() {
        return 0;
    }

    protected double payeeCredit(){
        return amount+fee();
    }

    @Override
    protected void checkPermission() throws OperationNotAllowedException {
        if (!payer.canCashOut()) {
            throw new OperationNotAllowedException(payer.id() + " may not cash out");
        }
        if (!(paidTo instanceof AgentWallet)) {
            throw new OperationNotAllowedException("cash-out destination must be an agent");
        }

    }
}
