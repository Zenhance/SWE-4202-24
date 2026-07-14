public class Payment extends Transaction{
    public Payment(Wallet a, Wallet b, double v, String number) {
        super(a,b,v,number);
    }

    public double fee() {
        return 0;
    }

    public void settle() {

    }
}