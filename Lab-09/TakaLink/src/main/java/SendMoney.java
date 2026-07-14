public class SendMoney extends Transaction{

    PersonalWallet p1;
    PersonalWallet p2;

    public SendMoney(Wallet p1, Wallet p2, double amount, String pin) {

        super(p1, p2, amount, pin);

    }

    @Override
    public double fee(){
        return 5.0;
    }

    @Override
    public void settle() throws Exception {



        try {
            PersonalWallet pw = (PersonalWallet) a;
            PersonalWallet aw = (PersonalWallet) b;
        } catch (ClassCastException e) {
            throw new OperationNotAllowedException("Transaction NOT possible between these accounts");
        }
        if(a.daily < amount || a.getLimit() < amount )
            throw new DailyLimitExceededException("Daily Limit reached :')");

        super.settle();


        double out = amount + fee();
        a.debit(out);
        a.daily -= amount;
        b.credit(amount);

    }
}
