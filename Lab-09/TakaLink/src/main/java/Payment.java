public class Payment extends Transaction{
    public Payment(Wallet from, Wallet to, double amount, String pin) {
        super(from, to, amount, pin);
    }
}
