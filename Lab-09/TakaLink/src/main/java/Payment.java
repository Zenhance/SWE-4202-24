public class Payment extends Transaction {
    @Override
    public double getFee() {
        return 0;
    }

    public Payment(PersonalWallet a, MerchantWallet m, double v, String number) {
        super();
    }

    public double fee() {
        return 0.0;
    }

    public void settle() {
    }
}
