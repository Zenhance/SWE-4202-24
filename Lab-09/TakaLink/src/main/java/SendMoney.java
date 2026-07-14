public class SendMoney extends Transaction{
    public SendMoney(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void settle() throws InsufficientBalanceException {
        if (payingWallet.verifyPin(super.getPIN())) {
            double FLAT_FEE = 5.0;
            payingWallet.debit(amount + FLAT_FEE);
            receivingWallet.credit(amount);
        }
    }
}
