public final class SendMoney extends Transaction {
    private static final double FLAT_FEE = 5.0;

    public SendMoney(Wallet payer, Wallet receiver, double amount, String offeredPin){
        super(payer, receiver, amount, offeredPin);
    }
    @Override
    public double fee(){
        return FLAT_FEE;
    }
    @Override
    protected Operation operation(){
        return Operation.SEND_MONEY;
    }
}
