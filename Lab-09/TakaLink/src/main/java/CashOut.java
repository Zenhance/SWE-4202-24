public class CashOut extends Transaction{
    public CashOut(Wallet from, Wallet to, double amount, String pin){
        super(from, to, amount, pin);
    }

    @Override
    public double fee() {
        return getAmount()*0.0185;
    }

    @Override
    public Operation operation() {
        return Operation.CASH_OUT;
    }
}
