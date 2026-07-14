public class TopUp extends Transaction {
    public TopUp(Wallet fromId, Wallet toId, double amount, String pin) {
        super(TransactionType.PAYMENT, amount, fromId, toId, pin);
    }
    @Override
    public
}
