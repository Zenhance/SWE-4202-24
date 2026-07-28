package src.main.java;
public class PersonalWallet extends Wallet {
    public PersonalWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    public double getDailyLimit() {
        return 25000;
    }
    public void validateOperation(Transaction transaction) throws OperationNotAllowedException {
    }
}