public class Payment extends Transaction {
    public Payment(Wallet fromId, Wallet toId, double amount, String pin) {
        super(TransactionType.PAYMENT, amount, fromId, toId, pin);
    }
}
