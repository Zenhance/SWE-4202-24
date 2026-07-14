public class SendMoney extends Transaction {
    public SendMoney(Transaction fromId, Transaction toId, double amount, String pin) {
        super(fromId.toString(), toId.toString(), amount, pin);
    }
    @Override
    public double fee() {
        return 5.0;
    }
}
