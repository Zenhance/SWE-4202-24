public final class Payment extends Transaction{
    public Payment(Wallet payer, Wallet receiver, double amount, String offeredPin){
        super(payer, receiver, amount, offeredPin);
    }
    @Override
    public double fee(){
        return 0.0;
    }
    @Override
    protected Operation operation(){
        return Operation.PAYMENT;
    }
    @Override
    protected void validateParties()
        throws OperationNotAllowedException {
        if (!(receiver() instanceof MerchantWallet)) {
            throw new OperationNotAllowedException("payment destination must be a merchant");
        }
    }
}
