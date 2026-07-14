public class SendMoney extends Transaction{
    public SendMoney(Wallet a, Wallet b, double v, String number) {
        super(a, b, v, number);
    }

    @Override
    public double fee() {
        return 5.0;
    }

    @Override
    public void settle() {

    }
}
