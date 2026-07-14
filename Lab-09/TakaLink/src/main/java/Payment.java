public class Payment extends Transaction{

    public Payment(Wallet fromId, Wallet toId, double amount, String pin) {
        super(fromId, toId, amount, pin);
    }

    @Override
    public double fee() {
        return 0;
    }

    @Override
    protected void validateSpecificRules() throws TransactionException {

    }

    @Override
    protected void executeMovement() throws InsufficientBalanceException {
            fromId.debit(amount);
    }
}
