public class SendMoney extends Transaction{

    public SendMoney(Wallet fromId, Wallet toId, double amount, String pin) {
        super(fromId, toId, amount, pin);
    }

    @Override
    protected void validateSpecificRules() throws TransactionException {

    }
    public double fee(){
        return 5.0;
    }

    @Override
    protected void executeMovement() throws InsufficientBalanceException {
        fromId.debit(amount+fee());
        toId.credit(amount);
    }
}
