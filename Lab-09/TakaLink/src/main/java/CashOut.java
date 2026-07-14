public class CashOut extends Transaction {

    PersonalWallet p;
    AgentWallet g;


    public CashOut(PersonalWallet p, Wallet g, double amount, String pin) {
        super(p, g, amount, pin);
        this.a = p;
        this.b = g;
    }

    @Override
    public double fee() {
        return amount * 1.85 / 100.00;
    }

    @Override
    public void settle() throws Exception {
        super.settle();
        try {
            PersonalWallet pw = (PersonalWallet) a;
            AgentWallet aw = (AgentWallet) b;
        } catch (ClassCastException e) {
            throw new OperationNotAllowedException("Transaction NOT possible between these accounts");
        }

        super.settle();
        //if(a.daily < amount)
        //    throw new DailyLimitExceededException("Daily Limit reached :')");
        b.credit(amount + fee());
    }
}
