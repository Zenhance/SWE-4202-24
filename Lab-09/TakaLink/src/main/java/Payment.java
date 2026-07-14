public class Payment extends Transaction{
    public Payment(String type, double amount, Wallet fromId, Wallet toId, String pin) {
        super(type, amount, fromId, toId, pin);
    }

    public Payment(PersonalWallet a, MerchantWallet m, double v, String number) {
        this.fromId = a;
        this.toId = m;
        this.amount = v;
        this.pin = number;
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
