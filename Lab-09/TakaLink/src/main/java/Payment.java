public class Payment extends Transaction{

    PersonalWallet p;
    MerchantWallet m;


    public Payment(Wallet p, Wallet m, double amount, String pin){
        super(p, m, amount, pin);
        this.a = p;
        this.b = m;
    }

    @Override
    public double fee(){return 0.0;}


    @Override
    public void settle() throws Exception {

        try {
            PersonalWallet pw = (PersonalWallet) a;
            MerchantWallet aw = (MerchantWallet) b;
        } catch (ClassCastException e) {
            throw new OperationNotAllowedException("Transaction NOT possible between these accounts");
        }
        if(a.balance() < amount)
            throw new OperationNotAllowedException("Transaction NOT possible between these accounts");

        super.settle();
        double out = amount + fee();
        a.debit(out);
        a.daily -= amount;
        b.credit(amount);

    }
}
