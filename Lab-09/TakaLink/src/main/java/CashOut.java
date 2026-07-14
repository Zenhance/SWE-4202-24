public class CashOut extends Transaction{
    public CashOut(Wallet a, Wallet b, double v, String number) {
        super(a,b,v,number);
    }
    public double fee() {return amount*.0185;}
}
