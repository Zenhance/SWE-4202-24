public class CashOut extends Transaction{
    public CashOut(String type,double amount, Wallet fromId, Wallet toId, String pin){
        super(type,amount,fromId,toId,pin);
    }
}
