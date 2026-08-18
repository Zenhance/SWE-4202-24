public class SendMoney extends Transaction {
    public SendMoney(Wallet fromId, Wallet toId, double amount, String pin) {

        super(TransactionType.SEND, amount, fromId, toId, pin);

    }
    @Override
    public double fee() {
        return 5.0;
    }
    @Override
    protected void validateSpecific() {
    }
    @Override
    protected void moveMoney()
            throws TransactionException {

        fromId().debit(amount() + fee());

        toId().credit(amount());
    }
}
