public class CashOut extends Transaction{
    public CashOut(String type,double amount, Wallet fromId, Wallet toId, String pin){
       super(type,amount,fromId,toId,pin);
   }

    public CashOut(Wallet a, Wallet b, double v, String number) {

        this.fromId = a;
        this.toId = b;
        this.amount = v;
        this.pin = number;
    }

    public double fee() {
        return 0.0;
    }

    public void settle() {

    }
}

