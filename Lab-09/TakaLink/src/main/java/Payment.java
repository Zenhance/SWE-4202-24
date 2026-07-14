public class Payment extends Transaction{
    public Payment(String type, double amount, Wallet fromId, Wallet toId, String pin) {
        super(type, amount, fromId, toId, pin);
    }



    public double fee() {
        return 0.0;
    }


    protected boolean isPermittedForPayer(Wallet payer) {
        return payer.canInitiatePayment();
    }


    protected String kindName() {
        return "payment";
    }
}
