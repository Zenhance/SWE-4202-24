public class TopUp extends Transaction{
    public TopUp(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void settle() {

    }
}