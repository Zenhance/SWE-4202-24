public class Payment extends Transaction{
    public Payment(PersonalWallet a, MerchantWallet m, double amount, String pin){
        super(a, m, amount, pin);
    }

    public double fee(){
        return 0.00;
    }
}
