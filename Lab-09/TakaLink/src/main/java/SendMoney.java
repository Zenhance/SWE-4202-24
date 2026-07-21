public class SendMoney extends Transaction {
    private static final double FLAT_FEE=5.0;


    public SendMoney(Wallet payer, Wallet paidTo, double amount, String pin) throws FrozenAccountException {

        super(payer, paidTo, amount, pin);
        if(amount==0){
            throw new FrozenAccountException("ads");
        }
    }

    @Override
    public double fee() {
        return FLAT_FEE;
    }

    @Override
    protected void checkPermission() throws OperationNotAllowedException {
           if(!payer.canSend()){
               throw new OperationNotAllowedException("Cant Send");
           }
    }
}
