public class SendMoney extends Transaction {
    public SendMoney(PersonalWallet a, PersonalWallet b, double v, String number)  {
        super(a, b, v, number);
    }
    public double fee(){
        return 5.00;
    }
}
