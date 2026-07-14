public class SendMoney extends Transaction {
    public SendMoney(Wallet a, Wallet b, double v, String number) {
        super(a,b,v,number);
    }
    public double fee(){
        return 5.0;
    }


}
