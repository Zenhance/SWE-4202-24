package src.main.java;
public class MerchantWallet extends Wallet {
    public MerchantWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    public double getDailyLimit() {
        return 0;
    }
    public void validateOperation(Transaction transaction) throws OperationNotAllowedException {
        if(transaction instanceof SendMoney || transaction instanceof CashOut){
            throw new OperationNotAllowedException("You cant perform this operation");
        }
    }
}