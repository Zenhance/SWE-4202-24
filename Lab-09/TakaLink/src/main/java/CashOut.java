public class CashOut extends Transaction{
    public CashOut(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void settle() throws InsufficientBalanceException {
        double cashoutFee = amount * 0.0185;
        if (payingWallet.verifyPin(super.getPIN())) {
            payingWallet.debit(amount + cashoutFee);
            receivingWallet.credit(amount + cashoutFee);
        }
    }
}
