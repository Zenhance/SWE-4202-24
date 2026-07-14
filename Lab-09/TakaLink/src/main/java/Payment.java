public class Payment extends Transaction{
    public Payment(Wallet pay, Wallet recieve, double amount, String pin) {
        super(pay, recieve, amount, pin);
    }

    @Override
    public double fee() {
        return 0;
    }

    @Override
    protected double debitAmount() {
        return 0;
    }
}
