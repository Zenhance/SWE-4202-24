public class SendMoney extends Transaction {
    private static final double FLAT_FEE=5.0;

    public SendMoney(String type, double amount, Wallet fromId,Wallet toId,String pin ){
        super(type,amount,fromId,toId,pin);
    }

    public SendMoney(Wallet a, PersonalWallet b, double v, String number) {
        this.fromId = a;
        this.toId = b;
        this.amount = v;
        this.pin = number;
    }

    public double fee(){
        return FLAT_FEE;
    }

    protected  boolean isPermittedForPayer(Wallet payer){
        return payer.canInitiateSend();
    }

    protected String kindName(){
        return "send";
    }
}
