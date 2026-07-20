public class SendMoney extends Transaction {
    public SendMoney(Wallet payerWallet,
                     Wallet receiverWallet,
                     double amount,
                     String pin) {

        super(payerWallet, receiverWallet, amount, pin);
    }

    @Override
    protected double fee() {
        return 5.0;
    }

    @Override
    protected void movement()
            throws TransactionException {

        getPayerWallet().debit(getAmount() + fee());

        getReceiverWallet().credit(getAmount());

    }

    @Override
    public void settle()
            throws TransactionException {

        if (!getPayerWallet().verifyPin(getPin())) {
            throw new InvalidPinException();
        }

        if (getPayerWallet().isFrozen()) {
            throw new FrozenAccountException();
        }

        if (getPayerWallet().remainingLimit() < getAmount()) {
            throw new DailyLimitExceededException();
        }

        movement();

        getPayerWallet().addSpentToday(getAmount());

    }
}
