public class SendMoney extends Transaction {
    public SendMoney(Wallet fromId, Wallet toId, double amount, String pin) {

        super(TransactionType.SEND, amount, fromId, toId, pin);

    }

    public double fee() {
        return 5.0;
    }

}
