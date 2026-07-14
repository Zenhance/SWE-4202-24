public class Payment extends Transaction {
    public Payment(PersonalWallet a, MerchantWallet m, double v, String number) {
        super(a,m,v,number);
    }

}
