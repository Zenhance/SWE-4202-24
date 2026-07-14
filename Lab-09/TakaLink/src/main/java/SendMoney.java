public class SendMoney extends Transaction {
    public SendMoney(Wallet sender, Wallet receiver, double amount, String pin) {
        super(sender, receiver, amount, pin);
    }
    @Override
    public double fee() {
        return 5.0;
    }
}
