public class TopUp extends Transaction{
    public TopUp(Wallet sender,Wallet reciever,double amount,String pin){
        super(sender,reciever,amount,pin);
    }

    @Override
    public double fee() {
        return 0.0;
    }

    @Override
    public void validOperation() throws TransactionException {

    }

    @Override
    public void moveMoney() throws TransactionException {
        sender.credit(amount());
        reciever.debit(amount());
    }
}
