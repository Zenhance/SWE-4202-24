public class SendMoney extends Transaction {
    public SendMoney(PersonalWallet a, PersonalWallet b, double v, String number) throws InvalidPinException, InsufficientBalanceException {
        super(a, b, v, number);
        if(!a.verifyPin(number)){
            throw new InvalidPinException(number);
        }
        if(v > a.balance()){
            throw new InsufficientBalanceException(v, a.balance());
        }
        a.debit(v + 5.0);
        b.credit(v);
    }
}
