package src.main.java;
public class AgentWallet extends Wallet {
    public AgentWallet(String id, double balance, String pin) {
        super(id, balance, pin);
    }
    public double getDailyLimit() {
        return 500000;
    }
    public void validateOperation(Transaction transaction) throws OperationNotAllowedException {
    }
}