public class CashOut extends Transaction{
    public CashOut(Wallet a, Wallet b, double v, String number) {
        super(a,b,v, number);
    }


    @Override
    public double fee() {
        return super.amount * 0.019;
    }

    public void settle() {

    }
}