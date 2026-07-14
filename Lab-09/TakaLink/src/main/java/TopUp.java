public final class TopUp extends Transaction{
    public TopUp(Wallet payer, Wallet receiver, double amount, String offeredPin){
        super(payer, receiver, amount, offeredPin);
    }
    @Override
    public double fee(){
        return 0.0;
    }
    @Override
    protected Operation operation(){
        return Operation.TOP_UP;
    }
}
