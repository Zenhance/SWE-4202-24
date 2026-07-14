public class SendMoney extends Transaction{
    public SendMoney(Wallet from, Wallet to, double amount, String pin){
        super(from, to, amount, pin);
    }

    @Override
    public double fee() {
        return 5;
    }

    @Override
    public Operation operation() {
        return Operation.SEND_MONEY;
    }
}
