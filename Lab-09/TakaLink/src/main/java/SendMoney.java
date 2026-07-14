public class SendMoney extends Transaction{
    public SendMoney(Wallet payingWallet, Wallet receivingWallet,double amount,String PIN){
        super(payingWallet,receivingWallet,amount,PIN);
    }
}
