public class Payment extends Transaction{
    public Payment(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void settle() throws InsufficientBalanceException {
        if (payingWallet.verifyPin(super.getPIN())) {
            payingWallet.debit(amount);
            receivingWallet.credit(amount);
        }
    }
}
