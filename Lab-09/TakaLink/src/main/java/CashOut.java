public class CashOut extends Transaction{
    public CashOut(Wallet fromId, Wallet toId, double amount, String pin) {
        super(fromId, toId, amount, pin);
    }

    @Override
    public double fee() {
        return amount*0.0185;
    }

    @Override
    protected void validateSpecificRules() throws TransactionException {

    }

    @Override
    protected void executeMovement() throws InsufficientBalanceException {
        fromId.debit(amount+fee());
        toId.credit(amount+fee());

    }
}
