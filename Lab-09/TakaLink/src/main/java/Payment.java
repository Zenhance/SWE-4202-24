public class Payment extends Transaction{
    public Payment(Wallet sender, Wallet reciever, double amount, String pin) {
        super(sender, reciever, amount, pin);
    }
    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void validOperation() throws TransactionException {
        if(!sender.canSend())
            throw new OperationNotAllowedException();
        if(!(reciever instanceof MerchantWallet))
            throw new OperationNotAllowedException();
    }

    @Override
    public void moveMoney() throws TransactionException {
        sender.debit(amount());
        reciever.credit(amount());
    }
}
