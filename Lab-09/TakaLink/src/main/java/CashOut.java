public class CashOut extends Transaction {
    public CashOut(PersonalWallet a, AgentWallet g, double v, String number) throws InsufficientBalanceException, InvalidPinException {
        super(a, g, v, number);
        double total_amount = v * 0.0185;
        if(a.balance() < total_amount){
            throw new InsufficientBalanceException(v, a.balance());
        }
        if(a.verifyPin(number)){
            throw new InvalidPinException(number);
        }
        a.debit(total_amount);
        g.credit(v);
    }
}
