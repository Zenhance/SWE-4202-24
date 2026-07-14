public class Payment extends Transaction {
    public Payment(PersonalWallet a, MerchantWallet m, double v, String number) {
    }

    public double fee() {
        return 0.0;
    }

    public void settle() {
    }
}
