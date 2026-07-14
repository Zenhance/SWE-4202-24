public class SendMoney extends Transaction{
    private static final double FEE = 5.0;
    public SendMoney(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }

}
