public class CashOut extends Transaction{
    double cashoutFee;

    public CashOut(Wallet payingWallet, Wallet receivingWallet, double amount, String PIN) {
        super(payingWallet, receivingWallet, amount, PIN);
        cashoutFee  = amount * 0.0185;
    }

    @Override
    public double fee() {
        return cashoutFee;
    }

    @Override
    public void settle() throws TransactionException {
        if (!(receivingWallet instanceof AgentWallet))
            throw new OperationNotAllowedException("Operation not allowed");
        if (!payingWallet.verifyPin(super.getPIN())) {
            throw new InvalidPinException("Wrong PIN");
        }
        payingWallet.debit(amount + cashoutFee);
        receivingWallet.credit(amount + cashoutFee);
    }
}
