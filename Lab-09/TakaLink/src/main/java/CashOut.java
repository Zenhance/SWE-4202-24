public class CashOut extends Transaction {
    public CashOut(PersonalWallet a, AgentWallet g, double v, String number) throws InsufficientBalanceException, InvalidPinException {
        super(a, g, v, number);
    }
    public double fee(){
        return transactionAmount * 0.0185;
    }
}
