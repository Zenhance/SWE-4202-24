public class SendMoney extends Transaction{
    private static final double fee =5.0
    public SendMoney(Wallet pay, Wallet recieve, double amount, String pin) {
        super(pay, recieve, amount, pin);
    }

    @Override
    public double fee() {
        return fee;
    }

    @Override
    protected double debitAmount() {
        return debitAmount();
    }
}
